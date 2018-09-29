package com.hometeach.dao;

import java.util.LinkedHashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * 处理数据库操作的接口
 */
public interface EntityDao {
    public int addEntity(@Param("tableName")String tableName, @Param("tableColumns") String tableColumns, @Param("tableValues") String tableValues);
    public int updateEntity(@Param("tableName")String tableName, @Param("updateColumns") String updateColumns, @Param("keyColumns") String keyColumns);
    public int deleteEntity(@Param("tableName")String tableName, @Param("keyColumns") String keyColumns);
    public List<LinkedHashMap> findEntityByKey(@Param("tableName")String tableName, @Param("keyColumns") String keyColumns);
    public List<LinkedHashMap> findEntitys(@Param("tableName")String tableName);
    public List<LinkedHashMap> findSpecialEntitys(@Param("selectList")String selectList, @Param("tableName")String tableName);
    
    /* 
     * 以下是特殊处理
     */
    // 班级查询需要join 授课记录查询当前课时
    public List<LinkedHashMap> findGrade();
    // 当日课程需要模糊查询匹配
    public List<LinkedHashMap> findCourse(@Param("week")String week);
    // 搜索授课记录
    public List<LinkedHashMap> searchTeaching(@Param("key") String key);

    
    public List<LinkedHashMap> findSalary(@Param("startDate")String startDate, @Param("endDate")String endDate);
    public List<LinkedHashMap> findLecture(@Param("teacherId")String teacherId, @Param("startDate")String startDate, @Param("endDate")String endDate);
}
