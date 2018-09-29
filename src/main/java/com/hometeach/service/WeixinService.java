package com.hometeach.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.hometeach.dto.BaseUser;
import com.hometeach.dto.JoinClass;
import com.hometeach.dto.JoinPerson;
import com.hometeach.util.Utils;


@RestController
public class WeixinService extends AbstractWeixinService{

	private static final int DEFAULT_RESULT_COUNT = 2000;

	@Override
	protected String getAppId(){
		return "wx0e8534bda472d8de";
	}
	
	@Override
	protected String getSecret(){
		return "d9021c52e6f0a481c6e26ac1e745fee4";
	}
	
	
	// 转换发起拼班和加入拼班
	private JoinPerson class2Person(JoinClass joinClass){
		JoinPerson joinPerson = new JoinPerson();
		
		joinPerson.setAddress(joinClass.getAddress());
		joinPerson.setArea(joinClass.getArea());
		joinPerson.setChildAge(joinClass.getChildAge());
		joinPerson.setClassId(joinClass.getClassId());
		joinPerson.setContactName(joinClass.getContactName());
		joinPerson.setIconPath(joinClass.getIconPath());
		joinPerson.setNickName(joinClass.getNickName());
		joinPerson.setOpenid(joinClass.getOpenid());
		joinPerson.setPhoneNumber(joinClass.getPhoneNumber());
		
		return joinPerson;
	}
	
	// 判断用户是否已经加入该班
	@RequestMapping(value="/wx/hasPersonJoined/{classId}-{code}", method=RequestMethod.GET)
	private boolean hasPersonJoined(@PathVariable("classId")String classId, @PathVariable("code")String code){
		String openid = getOpenId(code);
		List list = weixinDao.hasPersonJoined(classId, openid);
		if(list.size() > 0) return true;
		return false;
	}
	
	// 发起拼班
	@Transactional
	@RequestMapping(value="/wx/addJoinClass", method=RequestMethod.POST)
	private int wxAddJoinClass(@RequestBody JoinClass joinClass){
		try{
			String openid = getOpenId(joinClass.getOpenid());
			
			joinClass.setOpenid(openid);
			weixinDao.addJoinClass((JoinClass) Utils.refreshNickName(joinClass));
			int classId = joinClass.getClassId();
			
			weixinDao.updateJoinClassName(classId, Utils.getJoinClassName(classId));
		
			JoinPerson joinPerson = class2Person(joinClass);
			joinPerson.setIsStarter(1);
		
			weixinDao.addJoinPerson(joinPerson);
			
			return classId;
		}catch(Exception e){
			e.printStackTrace();
			return -1;
		}
	}
	
	// 加入拼班
	@RequestMapping(value="/wx/addJoinPerson", method=RequestMethod.POST)
	private int wxAddJoinPerson(@RequestBody JoinPerson joinPerson){
		try{
			String openid = getOpenId(joinPerson.getOpenid());
			joinPerson.setOpenid(openid);
			joinPerson.setIsStarter(0);
			
			return weixinDao.addJoinPerson((JoinPerson) Utils.refreshNickName(joinPerson));
			
		}catch(Exception e){
			e.printStackTrace();
			return -1;
		}
	}
	
	// 删除拼班
	@RequestMapping(value="/wx/deleteJoinPerson/{personId}", method=RequestMethod.DELETE)
	private int wxDeleteJoinPerson(@PathVariable("personId") String personId){
		try{
			return weixinDao.deleteJoinPerson(personId);
		}catch(Exception e){
			e.printStackTrace();
			return -1;
		}
	}
	
	// 获取所有拼班记录
	@RequestMapping(value="/wx/getAllJoinClass", method=RequestMethod.GET)
	private List<LinkedHashMap> getAllJoinClass(){
		return Utils.refreshNickName( weixinDao.getAllJoinClass(DEFAULT_RESULT_COUNT) );
	}
	
	// 获取最新拼班记录
	@RequestMapping(value="/wx/getLastJoinClass", method=RequestMethod.GET)
	private List<LinkedHashMap> getLastJoinClass(){
		return Utils.refreshNickName( weixinDao.getAllJoinClass(3) );
	}
	
	// 获取所有拼班记录
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/wx/getNewAllJoinClass", method=RequestMethod.GET)
	private List<LinkedHashMap> getNewAllJoinClass(){
		List<LinkedHashMap> list = weixinDao.getNewAllJoinClass();
		for(LinkedHashMap map : list){
			map.put("personList", Utils.refreshNickName((List<LinkedHashMap>) map.get("personList")));
			int[] lastNumList = new int[Integer.parseInt(map.get("lastNum").toString())];
			map.put("lastNumList", new int[Integer.parseInt(map.get("lastNum").toString())]);
		}
		return list;
	}
	
	// 获取某一个 拼班的信息
	@RequestMapping(value="/wx/getJoinClassById/{classId}", method=RequestMethod.GET)
	private Map getJoinClassById(@PathVariable("classId") String classId){
		return composeList( Utils.refreshNickName( weixinDao.getJoinClassById(classId) ));
	}
	
	// 获取 某一条 拼班记录
	@RequestMapping(value="/wx/getJoinPersonById/{personId}", method=RequestMethod.GET)
	private Map getJoinPersonById(@PathVariable("personId") String personId){
		return composeList( Utils.refreshNickName( weixinDao.getJoinPersonById(personId) ));
	}
	
	// 获取某一个 拼班下的  所有 加入用户的情况
	@RequestMapping(value="/wx/getJoinPersonByClass/{classId}", method=RequestMethod.GET)
	private List<LinkedHashMap> getJoinPersonByClass(@PathVariable("classId") String classId){
		return Utils.refreshNickName( weixinDao.getJoinPersonByClass(classId) );
	}
	
	// 获取某一个 用户的 发起拼班情况
	@RequestMapping(value="/wx/getJoinClassByOpenId/{code}", method=RequestMethod.GET)
	private List<LinkedHashMap> getJoinClassByOpenId(@PathVariable("code") String code){
		String openId = getOpenId(code);
		return Utils.refreshNickName( weixinDao.getJoinClassByOpenId(openId) );
	}
	
	// 获取某一个用户的所有拼班记录
	@RequestMapping(value="/wx/getJoinPersonByOpenId/{code}", method=RequestMethod.GET)
	private List<LinkedHashMap> getJoinPersonByOpenId(@PathVariable("code") String code){
		String openId = getOpenId(code);
		return Utils.refreshNickName( weixinDao.getJoinPersonByOpenId(openId) );
	}
	
	@RequestMapping(value="/wx/updateContact", method=RequestMethod.POST)
	private int updateContactByOpenId(@RequestBody BaseUser baseUser){
		String openId = getOpenId(baseUser.getOpenid());
		baseUser.setOpenid(openId);
		weixinDao.updateJoinClassContact(baseUser);
		return weixinDao.updateJoinPersonContact(baseUser);
	}
	
	/*@RequestMapping(value="/wx/login", method=RequestMethod.POST)
	private Map<String, String> wxLogin(@RequestBody BaseUser userLogin){
		Map<String, String> result = new HashMap<String, String>();
		String openid = getOpenId(userLogin.getCode());
		
		List<LinkedHashMap> list = weixinDao.findUser(openid);
		if(list != null && list.size() > 0){
			Map map = list.get(0);
			String user = map.get(USER).toString();
			String pass = map.get(PASS).toString();
			if(!userLogin.getUser().equals(user)){
				result.put("message", "003");
				result.put("success", "0");
			}
			else if(!userLogin.getPwd().equals(pass)){
				result.put("message", "004");
				result.put("success", "0");
			}else{
				result.put("message", "001");
				result.put("success", "1");
				result.put("sessionId", sessionService.getSessionKey());
			}
		}else{
			result.put("message", "002");
			result.put("success", "0");
		}
		return result;
	}*/
	
	@RequestMapping(value="/wx/getStudent/{studentId}", method=RequestMethod.GET)
	private Map getStudent(@PathVariable("studentId") String studentId){
		return composeList(weixinDao.getStudent(studentId));
	}
	
	@RequestMapping(value="/wx/getGrade/{studentId}", method=RequestMethod.GET)
	private Map getGradeByStudent(@PathVariable("studentId") String studentId){
		return composeList(weixinDao.getGradeByStudent(studentId));
	}
	
	@RequestMapping(value="/wx/getTeaching/{studentId}", method=RequestMethod.GET)
	private List<LinkedHashMap> getTeachingListByStudent(@PathVariable("studentId") String studentId){
		List<LinkedHashMap> list = weixinDao.getTeachingListByStudent(studentId);
		Iterator<LinkedHashMap> it = list.iterator();
		while(it.hasNext()){
			LinkedHashMap map = it.next();
			Object object = map.get("absentStudentId");
			String absent = object != null ? object.toString() : "";
			if(absent.length() > 0){
				String[] split = absent.split(",");
				for(String s : split)
					if(studentId.trim().equalsIgnoreCase(s.trim()))
						it.remove();
			}
		}
		return list;
		
	}
	
	@RequestMapping(value="/wx/getBookId", method=RequestMethod.GET)
	private List<LinkedHashMap> getWeixinPointsBookId(){
		return weixinDao.getBookId();
	}
	
	@RequestMapping(value="/wx/getLesson/{bookId}-{unitId}", method=RequestMethod.GET)
	private List<LinkedHashMap> getWeixinPointsLesson(@PathVariable("bookId") int bookId, 
			@PathVariable("unitId") int unitId){
		return weixinDao.getUnitLesson(bookId, unitId);
	}
}
