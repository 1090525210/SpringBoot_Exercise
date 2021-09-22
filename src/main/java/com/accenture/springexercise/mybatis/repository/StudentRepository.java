package com.accenture.springexercise.mybatis.repository;

import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import com.accenture.springexercise.mybatis.entity.StudentEntity;

/**
 * @ClassName StudentRepository.java
 * @Description An interface for Mapper, connected with StudentRepository.xml file, to implements several functions.
 * @author jiazhen.ruan
 * 
 */

@Repository
public interface StudentRepository {
	
	
	/**
     * 
     * @Title: selectAll
     * @Description: select all the StudentEntity in the database.
     * @return A list of all StudentEntity objects in the database. 
     */
	List<StudentEntity> selectAll();
	
	/**
     * @Title: selectbyId
     * @Description: select the StudentEntity object from database with this id.
     * @param id The id is used to select the student with this id.
     * @return A StudentEntity object whose Id is the parameter id.
     */
	StudentEntity selectbyId(Integer id);
	
	/**
     * @Title: update
     * @Description: update the information of this student according to the id. 
     * @param id The id of the student in the database whose information needs to be updated.
     * @param name The name of this id will be updated. 
     * @param age The age of this id will be updated.
     * @return The number of students have been updated.
     */
	int update(Integer id, String name, Integer age);
	
	int insert(Integer id, String name, Integer age);
	int delete(Integer id);
}
