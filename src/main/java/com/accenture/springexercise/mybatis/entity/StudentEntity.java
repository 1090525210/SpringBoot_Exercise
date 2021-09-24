package com.accenture.springexercise.mybatis.entity;



public class StudentEntity {
	
	private int studentid;
	private String name;
	private int age;
	private int createuserId;
	private String createdateTime;
	private int updateuserId;
	private String updatedateTime;
	
	
	public StudentEntity() {}
	public StudentEntity(int id, String name) {
		this.studentid=id;
		this.name =name;
	}
	
	public StudentEntity(int studentid, String name, int age, int createuserId, String createdateTime, int updateuserId,
			String updatedateTime) {
		super();
		this.studentid = studentid;
		this.name = name;
		this.age = age;
		this.createuserId = createuserId;
		this.createdateTime = createdateTime;
		this.updateuserId = updateuserId;
		this.updatedateTime = updatedateTime;
	}
	public int getStudentid() {
		return studentid;
	}

	public void setStudent_id(int studentid) {
		this.studentid = studentid;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public int getCreateuserId() {
		return createuserId;
	}

	public void setCreateuserId(int createuserId) {
		this.createuserId = createuserId;
	}

	public String getCreatedateTime() {
		return createdateTime;
	}

	public void setCreatedateTime(String createdateTime) {
		this.createdateTime = createdateTime;
	}

	public int getUpdateuserId() {
		return updateuserId;
	}

	public void setUpdateuserId(int updateuserId) {
		this.updateuserId = updateuserId;
	}

	public String getUpdatedateTime() {
		return updatedateTime;
	}

	public void setUpdatedateTime(String updatedateTime) {
		this.updatedateTime = updatedateTime;
	}

	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	
	
	
	
	
	
}
