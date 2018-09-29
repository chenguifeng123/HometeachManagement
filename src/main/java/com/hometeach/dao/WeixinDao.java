package com.hometeach.dao;

import java.util.LinkedHashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hometeach.dto.BaseUser;
import com.hometeach.dto.Job;
import com.hometeach.dto.JoinClass;
import com.hometeach.dto.JoinPerson;
import com.hometeach.dto.SignTeaching;

/**
 * 微信处理
 */
public interface WeixinDao {
	
    //public List<BaseUser> findUser(@Param("openid")String openid);
    public int addJoinClass(JoinClass joinClass);
    public List<LinkedHashMap> getAllJoinClass(@Param("showCount") int showCount);
    public List<LinkedHashMap> getNewAllJoinClass();
    
    public int addJoinPerson(JoinPerson joinPerson);
    public int deleteJoinPerson(@Param("personId") String personId);
    public int updateJoinClassName(@Param("classId") int classId, @Param("className") String className);
    public int updateJoinPersonContact(BaseUser baseUser);
    public int updateJoinClassContact(BaseUser baseUser);
    public List<LinkedHashMap> hasPersonJoined(@Param("classId") String classId, @Param("openid") String openid);
    
    public List<LinkedHashMap> getJoinClassById(@Param("classId") String classId);
    public List<LinkedHashMap> getJoinPersonById(@Param("personId") String personId);
    public List<LinkedHashMap> getJoinPersonByClass(@Param("classId") String classId);
    public List<LinkedHashMap> getJoinClassByOpenId(@Param("openid") String openid);
    public List<LinkedHashMap> getJoinPersonByOpenId(@Param("openid") String openid);
    
    // 学员相关处理
    public List<LinkedHashMap> getStudent(@Param("studentId") String studentId);
    public List<LinkedHashMap> getGradeByStudent(@Param("studentId") String studentId);
    public List<LinkedHashMap> getTeachingListByStudent(@Param("studentId") String studentId);
    
    // 学习要点处理
    public List<LinkedHashMap> getBookId();
    public List<LinkedHashMap> getUnitLesson(@Param("bookId") int bookId, @Param("unitId") int unitId);
    
    // Link job 处理
    public int addJob(Job job);
    public List<LinkedHashMap> getAllJobs();
    
    // Hometeach
    public List<LinkedHashMap> getLocalTeacher(@Param("phone") String phone);
    public List<LinkedHashMap> getTeacherLecture(@Param("teacherId")String teacherId);
    public List<LinkedHashMap> getDurationByClass(@Param("classId")String classId, @Param("week")String week);
    public List<LinkedHashMap> getLastClassNumber(@Param("classId")String classId);
    public int addSignTeaching(SignTeaching signTeaching);
    public List<LinkedHashMap> getClassListByTeacher(@Param("teacherId")String teacherId);
    public List<LinkedHashMap> getClassRecordByTeacher(@Param("teacherId")String teacherId);
    public List<LinkedHashMap> getTeachingSignInToday(@Param("classId")String classId, @Param("teacherId")String teacherId, @Param("teachingDate")String teachingDate);
}
