package com.accenture.springexercise.mybatis.service;

import java.io.IOException;
import java.io.InvalidClassException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import com.accenture.springexercise.mybatis.entity.StudentEntity;
import com.accenture.springexercise.mybatis.repository.StudentRepository;
import com.fasterxml.jackson.databind.JsonMappingException;



@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
    private StudentRepository stMapper;
 
	@Override
    public List<StudentEntity> selectAll(){
        List<StudentEntity> list = new ArrayList<>();
        list = stMapper.selectAll();
        
        return list;
    }
 
    //通过ID查找
	@Override
    public StudentEntity selectbyId(Integer id) {
    	StudentEntity st = new StudentEntity();
    	st = stMapper.selectbyId(id);
        return st;
    }
	
    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = {IOException.class, InvalidClassException.class},noRollbackFor = {JsonMappingException.class})
    public int update(Integer id, String name,Integer age) {
        int res = stMapper.update(id, name,age);
        // throw new RuntimeException(“I’m wrong,I will be rollback!");
        return res;
    }

	
	


}
