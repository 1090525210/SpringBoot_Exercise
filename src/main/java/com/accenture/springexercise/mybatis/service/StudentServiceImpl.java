package com.accenture.springexercise.mybatis.service;

import java.io.IOException;
import java.io.InvalidClassException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import com.accenture.springexercise.mybatis.entity.StudentEntity;
import com.accenture.springexercise.mybatis.repository.StudentRepository;
import com.fasterxml.jackson.databind.JsonMappingException;



@Service
@CacheConfig(cacheNames = "student")
public class StudentServiceImpl implements StudentService{
	
	@Autowired
    private StudentRepository stMapper;
	
	/**
     * 
     * override the function of selecting all the StudentEntity in the database by calling the function of mapper object.
     * @return A list of all StudentEntity objects in the database. 
     */
	@Override
	@Cacheable()
    public List<StudentEntity> selectAll(){
        List<StudentEntity> list = new ArrayList<>();
        list = stMapper.selectAll();
        return list;
    }
 
	/**
     * select the StudentEntity object with this id from the cache. If it can't find in the cache, then search the database.
     * @param id The id is used to select the student with this id.
     * @return A StudentEntity object whose Id is the parameter id.
     */
	@Override
	@Cacheable(key = "#id")
    public StudentEntity selectbyId(Integer id) {
		System.out.println("Success!");
    	StudentEntity st = new StudentEntity();
    	st = stMapper.selectbyId(id);
        return st;
    }
	
	/**
     * update the information of this student according to the id, implementing the transaction management. 
     * @param id The id of the student in the database whose information needs to be updated.
     * @param name The name of this id will be updated. 
     * @param age The age of this id will be updated.
     * @return The number of students have been updated.
     */
    @Override
    @CachePut(key = "#st.studentid")
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = {IOException.class, InvalidClassException.class},noRollbackFor = {JsonMappingException.class})
    public StudentEntity update(StudentEntity st) {
        int res = stMapper.update(st);
        // throw new RuntimeException(“I’m wrong,I will be rollback!");
        return st;
    }
    
	
    @Override
    @CachePut(key = "#st.studentid")
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = {IOException.class, InvalidClassException.class},noRollbackFor = {JsonMappingException.class})
    public int insert(StudentEntity st) {
        int res = stMapper.insert(st);
        // throw new RuntimeException(“I’m wrong,I will be rollback!");
        return res;
    }

    @Override
    @CacheEvict(key = "#id")
    public int delete(Integer id){
    	int res = stMapper.delete(id);
        return res;
    }
}
