package com.hometeach.service.Impl;

import com.hometeach.dao.EntityDao;
import com.hometeach.dao.TableConfigDao;
import com.hometeach.dto.Column;
import com.hometeach.dto.TableConfig;
import com.hometeach.service.EntityService;
import com.hometeach.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.*;

/*
    服务端主要服务处理类
    主要负责数据库的 增删改查操作
 */
@Component
public class EntityServiceImpl implements EntityService {


	private static final String COURSE = "course";
	private static final String GRADE = "grade";
	private static final String TEACHING = "teaching";
	private static final String SALARY = "salary";

	@Autowired
	public EntityDao entityDao;

	@Autowired
	public TableConfigDao tableConfigDao;

	private HashMap<String, List<String>> tableKeyMap = new HashMap<String, List<String>>();
	private HashMap<String, HashMap<String, Column>> tableColumnMap = new HashMap<String, HashMap<String, Column>>();

	// 获取表的主键,作为修改和删除的依据
	private List<String> getKeyByTable(String tableName){
		if(tableKeyMap.size() == 0){
			List<TableConfig> list = tableConfigDao.findTableConfig();
			for(TableConfig tableConfig : list){
				List<String> keyList = Arrays.asList(tableConfig.getKeyList().split(","));
				tableKeyMap.put(tableConfig.getTableName(),  keyList);
			}
		}
		return tableKeyMap.get(tableName);
	}

	private HashMap<String, Column> getColumnByTable(String tableName){
		if(tableColumnMap.size() == 0){
			List<HashMap> list = tableConfigDao.findTableColumn();
			for(HashMap map : list){
				String table = map.get("table_name").toString();
				String columnName = map.get("column_name").toString();
				HashMap<String, Column> tableMap = tableColumnMap.get(table) == null ? new HashMap<String, Column>() : tableColumnMap.get(table);
				tableMap.put(columnName, new Column(columnName, map.get("table_name").toString()));
				tableColumnMap.put(table, tableMap);
			}
		}
		return tableColumnMap.get(tableName);
	}

	interface Loop{
		void run(String key, String value);
	}

	// 迭代前端传入的数据
	private void iterator(Map<String, Object> map, Loop loop){
		Iterator<Map.Entry<String, Object>> iterator = map.entrySet().iterator();
		while(iterator.hasNext()){
			Map.Entry<String, Object> entry = iterator.next();
			loop.run(entry.getKey(), entry.getValue().toString());
		}
	}

	// 插入数据
	@RequestMapping(value = "/{tableName}/addEntity", method = RequestMethod.POST)
	public int addService(@PathVariable("tableName") String tableName, @RequestBody Map<String, Object> map){
		List<String> keyColumns = new LinkedList<String>();
		List<String> valueColumns = new LinkedList<String>();
		List<String> keys = getKeyByTable(tableName);
		iterator(map, new Loop() {
			@Override
			public void run(String key, String value) {
				if(keys.contains(key)) return; // 目前所有主键都是自动生成,这里屏蔽
				keyColumns.add(key);
				valueColumns.add(Utils.fillColumn(value));
			}
		});
		return entityDao.addEntity(tableName, Utils.join(keyColumns, ","), Utils.join(valueColumns, ","));
	}

	private void loadKeyColumns(String tableName, Map<String, Object> map, List<String> keyColumns, List<String> keys, List<String> updateColumns){
		HashMap<String, Column> columnMap = getColumnByTable(tableName);
		iterator(map, new Loop() {
			@Override
			public void run(String key, String value) {
				Column column = columnMap.get(key);
				// 类型判断和处理,临时写一下,以后再考虑系统处理
				if(column == null || value == null) return;
				if(column.getDataType().equals("int") && value.length() == 0) return;
				String oneSetting = String.format(Utils.EQUAL_SQL, key, Utils.fillColumn(value));
				if(keys.contains(key)){
					keyColumns.add(oneSetting);
				}else{
					if (updateColumns != null) updateColumns.add(oneSetting);
				}
			}
		});
	}

	// 修改数据
	@RequestMapping(value = "/{tableName}/updateEntity", method = RequestMethod.POST)
	public int updateService(@PathVariable("tableName") String tableName, @RequestBody Map<String, Object> map){
		List<String> updateColumns = new LinkedList<String>();
		List<String> keyColumns = new LinkedList<String>();
		loadKeyColumns(tableName, map, keyColumns, getKeyByTable(tableName), updateColumns);
		return entityDao.updateEntity(tableName, Utils.join(updateColumns, ","), Utils.join(keyColumns, Utils.AND));
	}

	// 删除数据
	@RequestMapping(value = "/{tableName}/deleteEntity", method = RequestMethod.POST)
	public int deleteService(@PathVariable("tableName") String tableName, @RequestBody List<Map<String, Object>> list){
		List<String> allRecordKeys = new LinkedList<String>();
		for(Map<String, Object> map : list) {
			List<String> keyColumns = new LinkedList<String>();
			loadKeyColumns(tableName, map, keyColumns, getKeyByTable(tableName), null);
			allRecordKeys.add(String.format("(%s)", Utils.join(keyColumns, Utils.AND)));
		}
		return entityDao.deleteEntity(tableName, Utils.join(allRecordKeys, Utils.OR));
	}

	// 根据key查找数据
	@RequestMapping(value = "/{tableName}/findEntity", method = RequestMethod.POST)
	public List<LinkedHashMap> showService(@PathVariable("tableName") String tableName, @RequestBody Map<String, Object> map){
		if(tableName.equals(SALARY)){
			String teacherId = map.get("teacherId").toString();
			String dateString = map.get("dateString").toString();
			if(dateString == null || dateString.trim().length() == 0) dateString = Utils.todayString();
			return entityDao.findLecture(teacherId, Utils.getFirstDayByDateInMonth(dateString), Utils.getLastDayByDateInMonth(dateString));
		}
		String queryTableName = tableName.equals(COURSE) ? GRADE : tableName;
		List<String> keyColumns = new LinkedList<String>();
		loadKeyColumns(queryTableName, map, keyColumns, getKeyByTable(queryTableName), null);
		return entityDao.findEntityByKey(queryTableName, Utils.join(keyColumns, Utils.AND));
	}

	// 查询所有数据，目前分页在客户端做，将来可以考虑服务端做
	@RequestMapping(value = "/{tableName}/showEntitys", method = RequestMethod.POST)
	public List<LinkedHashMap> showAllService(@PathVariable("tableName") String tableName){
		if(tableName.equals("grade")) return entityDao.findGrade();
		if(tableName.equals("course")) return entityDao.findCourse(Utils.getCurrentWeekDay());
		if(tableName.equals(SALARY)) {
			String today = Utils.todayString();
			return entityDao.findSalary(Utils.getFirstDayByDateInMonth(today), Utils.getLastDayByDateInMonth(today));
		}
		return entityDao.findEntitys(tableName);
	}

	// 查询关联表的数据
	@RequestMapping(value = "/showSpecialService", method = RequestMethod.POST)
	public List<LinkedHashMap> showSpecialService(@RequestBody Map<String, Object> map){
		String tableName = map.get("model").toString();
		String key = map.get("key").toString();
		String value =  map.get("value").toString();
		String selectList = Utils.join(new String[]{key, value}, ",");
		return entityDao.findSpecialEntitys(selectList, tableName);
	}

	// 搜索功能
	@RequestMapping(value = "/{tableName}/search", method = RequestMethod.POST)
	public List<LinkedHashMap> search(@PathVariable("tableName") String tableName, @RequestBody Map<String, Object> map){
		String key = map.get("key").toString();
		if(tableName.equals(TEACHING)) return entityDao.searchTeaching(String.format("'%s%s%s'", "%", key, "%"));
		if(tableName.equals(COURSE)) return entityDao.findCourse(Utils.dateString2Week(key));
		if(tableName.equals(SALARY)) return entityDao.findSalary(Utils.getFirstDayByDateInMonth(key), Utils.getLastDayByDateInMonth(key));
		return null;
	}

}
