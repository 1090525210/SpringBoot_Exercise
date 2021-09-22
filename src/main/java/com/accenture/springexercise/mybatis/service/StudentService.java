package com.accenture.springexercise.mybatis.service;

import java.util.List;

import com.accenture.springexercise.mybatis.entity.StudentEntity;


/**
 * @ClassName StudentService
 * @Description A service interface to implement the service logic. 
 * @author jiazhen.ruan
 *
 */
public interface StudentService {
	
	
	List<StudentEntity> selectAll();
	StudentEntity selectbyId(Integer id);
	int update(Integer id, String name, Integer age);
	int insert(Integer id, String name, Integer age);
	int delete(Integer id);
}
