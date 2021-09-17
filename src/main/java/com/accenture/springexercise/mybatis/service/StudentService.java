package com.accenture.springexercise.mybatis.service;

import java.util.List;

import com.accenture.springexercise.mybatis.entity.StudentEntity;

public interface StudentService {
	List<StudentEntity> selectAll();
	StudentEntity selectbyId(Integer id);
	int update(Integer id, String name, Integer age);
}
