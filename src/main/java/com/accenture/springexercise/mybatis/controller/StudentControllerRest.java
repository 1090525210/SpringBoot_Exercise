package com.accenture.springexercise.mybatis.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.springexercise.mybatis.service.StudentService;
import com.accenture.springexercise.mybatis.entity.*;

@RestController
@RequestMapping("student")
public class StudentControllerRest {

    @Autowired
    private StudentService stService;

    @GetMapping("retrieve")
    public List<StudentEntity> postRequest() {
        return stService.selectAll();
    }
    
    @GetMapping("retrieve-by-id")
    public StudentEntity findbyId(@RequestParam("studentId") Integer id) {
        return stService.selectbyId(id);
    }
    
    @GetMapping("update")
    public int update(@RequestParam("studentId") Integer id, @RequestParam("name") String name,@RequestParam("age") Integer age) {
        return stService.update(id, name, age);
    }
    
	
}
