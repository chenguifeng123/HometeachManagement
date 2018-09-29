package com.hometeach.dto;

public class SignTeaching {
	
	private int teachingId;
	private int classId;
	private int teachingType = 0;
	private int teacherId;
	private String teachingDate;
	private String teachingTime;
	private String teachingAddress;
	private String teacherArriveTime;
	private String currentTeachingPeriod;
	private float lastClassNumber;
	private float currentClassNumber;
	private int beLate = 21;
	
		
	public int getTeachingId() {
		return teachingId;
	}
	public void setTeachingId(int teachingId) {
		this.teachingId = teachingId;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public int getTeachingType() {
		return teachingType;
	}
	public void setTeachingType(int teachingType) {
		this.teachingType = teachingType;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public String getTeachingDate() {
		return teachingDate;
	}
	public void setTeachingDate(String teachingDate) {
		this.teachingDate = teachingDate;
	}
	public String getTeachingTime() {
		return teachingTime;
	}
	public void setTeachingTime(String teachingTime) {
		this.teachingTime = teachingTime;
	}
	public String getTeachingAddress() {
		return teachingAddress;
	}
	public void setTeachingAddress(String teachingAddress) {
		this.teachingAddress = teachingAddress;
	}
	
	
	public String getTeacherArriveTime() {
		return teacherArriveTime;
	}
	public void setTeacherArriveTime(String teacherArriveTime) {
		this.teacherArriveTime = teacherArriveTime;
	}
	
	
	
	public String getCurrentTeachingPeriod() {
		return currentTeachingPeriod;
	}
	public void setCurrentTeachingPeriod(String currentTeachingPeriod) {
		this.currentTeachingPeriod = currentTeachingPeriod;
	}
	public float getLastClassNumber() {
		return lastClassNumber;
	}
	public void setLastClassNumber(float lastClassNumber) {
		this.lastClassNumber = lastClassNumber;
	}
	public float getCurrentClassNumber() {
		return currentClassNumber;
	}
	public void setCurrentClassNumber(float currentClassNumber) {
		this.currentClassNumber = currentClassNumber;
	}
	public int getBeLate() {
		return beLate;
	}
	public void setBeLate(int beLate) {
		this.beLate = beLate;
	}
	
	

}
