package com.hometeach.dto;

public class JoinPerson extends BaseUser{

	private int personId;
	private int classId;
	
	private int isStarter;

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public int getIsStarter() {
		return isStarter;
	}

	public void setIsStarter(int isStarter) {
		this.isStarter = isStarter;
	}
	
	
}
