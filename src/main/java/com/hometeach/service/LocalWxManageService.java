package com.hometeach.service;

import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hometeach.dao.EntityDao;
import com.hometeach.dto.Job;
import com.hometeach.dto.SignTeaching;
import com.hometeach.util.Utils;

@RestController
public class LocalWxManageService extends AbstractWeixinService{
	
    @Autowired
    public EntityDao entityDao;

	@Override
	protected String getAppId() {
		return "wx8679650c3bdbd0ab";
	}

	@Override
	protected String getSecret() {
		return "778cf7fe0d90f56ba69158b2f3169197";
	}

	// 获取老师信息
	@RequestMapping(value="/local/login/{phone}", method=RequestMethod.GET)
	private Map getLocalTeacher(@PathVariable("phone") String phone){
		return composeList(weixinDao.getLocalTeacher("'%" + phone + "%'"));
	}
	
	@RequestMapping(value="/local/getSignClass/{teacherId}", method=RequestMethod.GET)
	private List<LinkedHashMap> getSignClass(@PathVariable("teacherId") int teacherId){
		List<LinkedHashMap> list = entityDao.findCourse(Utils.getCurrentWeekDay());
		for(Iterator<LinkedHashMap> it = list.listIterator(); it.hasNext();){
			LinkedHashMap map = it.next();
			int localTeacherId = Integer.parseInt(map.get("teacherId").toString());
			if(teacherId != localTeacherId) it.remove();
		}
		return list;
	}
	
	@RequestMapping(value="/local/getTeacherLecture/{teacherId}", method=RequestMethod.GET)
	private List<LinkedHashMap> getTeacherLecture(@PathVariable("teacherId") String teacherId){
		return weixinDao.getTeacherLecture(teacherId);
	}
	
	@RequestMapping(value="/local/getClassListByTeacher/{teacherId}", method=RequestMethod.GET)
	private List<LinkedHashMap> getClassListByTeacher(@PathVariable("teacherId") String teacherId){
		return weixinDao.getClassListByTeacher(teacherId);
	}
	
	@RequestMapping(value="/local/getClassRecordByTeacher/{teacherId}", method=RequestMethod.GET)
	private List<LinkedHashMap> getClassRecordByTeacher(@PathVariable("teacherId") String teacherId){
		return weixinDao.getClassRecordByTeacher(teacherId);
	}
	
	@RequestMapping(value="/local/getTeachingSignInToday/{classId}-{teacherId}", method=RequestMethod.GET)
	private List<LinkedHashMap> getTeachingSignInToday(@PathVariable("classId") String classId, @PathVariable("teacherId") String teacherId){
		return weixinDao.getTeachingSignInToday(classId, teacherId, Utils.date2String(new Date(), null));
	}
	
	// 发布工作
	@Transactional
	@RequestMapping(value="/local/addTeaching/{classId}-{teacherId}-{period}-{address:.+}", method=RequestMethod.POST)
	private int addTeaching(@PathVariable("classId") String classId, @PathVariable("teacherId") String teacherId,
			@PathVariable("period") String period, @PathVariable("address") String address){
		Map map = composeList(weixinDao.getDurationByClass(classId, Utils.getCurrentWeekDay()));
		Map mapClass = composeList(weixinDao.getLastClassNumber(classId));
		if(map.size() == 0 || mapClass.size() == 0) return -1;
		
		SignTeaching sign = new SignTeaching();
		sign.setClassId(Integer.parseInt(classId));
		sign.setTeacherId(Integer.parseInt(teacherId));
		//sign.setTeachingAddress(map.get("address").toString());
		sign.setTeachingAddress(address);
		sign.setTeachingTime(map.get("teachingTime").toString());
		sign.setTeachingDate(Utils.date2String(new Date(), null));
		sign.setTeacherArriveTime(Utils.date2String(new Date(), "yyyy-MM-dd HH:mm:ss"));
		sign.setCurrentTeachingPeriod(period);
		
		float duration = Float.parseFloat(map.get("duration").toString());
		
		float classNumber = Float.parseFloat(mapClass.get("classNumber").toString());
		sign.setLastClassNumber(classNumber);
		sign.setCurrentClassNumber(classNumber + duration);
		weixinDao.addSignTeaching(sign);
		return sign.getTeachingId();
	}
}
