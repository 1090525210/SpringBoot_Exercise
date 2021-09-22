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

/**
 * 
 * @ClassName StudentControllerRest.java
 * @Description The controller of student service, implements several functions.
 * @author jiazhen.ruan
 *
 */
@RestController
@RequestMapping("student")
public class StudentControllerRest {
	
    @Autowired
    private StudentService stService;

    
    /**
     * 
     * @Title: postRequest
     * @Description: implement the function of selecting all the student with posting request URL.
     * @return A list of all StudentEntity objects in the database. 
     */
    @GetMapping("retrieve")
    public List<StudentEntity> postRequest() {
        return stService.selectAll();
    }
    
    /**
     * @Title: findbyId
     * @Description: use selectbyId function of service to select the StudentEntity object with this id.
     * @param id The id from the parameter of URL is used to select the student with this id.
     * @return A StudentEntity object whose Id is the parameter id.
     */
    @GetMapping("retrieve-by-id")
    public StudentEntity findbyId(@RequestParam("studentId") Integer id) {
        return stService.selectbyId(id);
    }
    
    /**
     * @Title: update
     * @Description: update the information of this student according to the id. 
     * @param id The studentId on the URL is the id of the student whose information needs to be updated.
     * @param name The name on the URL of this id will be updated as new name. 
     * @param age The age on the URL of this id will be updated.
     * @return The number of students have been updated.
     */
    @GetMapping("update")
    public int update(@RequestParam("studentId") Integer id, @RequestParam("name") String name,@RequestParam("age") Integer age) {
        return stService.update(id, name, age);
    }
    
    @GetMapping("insert")
    public String insert(@RequestParam("studentId") Integer id, @RequestParam("name") String name,@RequestParam("age") Integer age) {
        stService.insert(id, name, age);
        return "Insert successfully!";
    }
    
    @GetMapping("delete")
    public String delete(@RequestParam("studentId") Integer id) {
    	stService.delete(id);
        return "Delete successfully!";
    }
	
}
