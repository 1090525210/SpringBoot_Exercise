package com.accenture.springexercise.mybatis.service;

import java.util.List;

import com.accenture.springexercise.mybatis.entity.StudentEntity;


/**
 * A service interface to implement the service logic. 
 * @author jiazhen.ruan
 *
 */
public interface StudentService {
	
	
	List<StudentEntity> selectAll();
	StudentEntity selectbyId(Integer id);
	StudentEntity update(StudentEntity st);
	int insert(StudentEntity st);
	int delete(Integer id);
}
