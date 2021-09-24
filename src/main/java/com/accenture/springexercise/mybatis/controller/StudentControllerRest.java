package com.accenture.springexercise.mybatis.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.springexercise.mybatis.service.StudentService;
import com.accenture.springexercise.mybatis.entity.*;

/**
 * 
 * The controller of student service, implements several functions.
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
     * implement the function of selecting all the student with posting request URL.
     * @return A list of all StudentEntity objects in the database. 
     */
    @GetMapping("retrieve")
    @ResponseStatus(code=HttpStatus.ACCEPTED)
    public List<StudentEntity> postRequest() {
        return stService.selectAll();
    }
    
    /**
     * use selectbyId function of service to select the StudentEntity object with this id.
     * @param id The id from the parameter of URL is used to select the student with this id.
     * @return A StudentEntity object whose Id is the parameter id.
     */
    
    @GetMapping("retrieve-by-id/{id}")
    @ResponseStatus(code=HttpStatus.ACCEPTED)
    public StudentEntity findbyId(@PathVariable("id") Integer id) {
        return stService.selectbyId(id);
    }
    
    /**
	 * update the information of this student according to the id. 
     * @param id The studentId on the URL is the id of the student whose information needs to be updated.
     * @param name The name on the URL of this id will be updated as new name. 
     * @param age The age on the URL of this id will be updated.
     * @return The number of students have been updated.
     */
    @PutMapping("update")//put
    public ResponseEntity<Map<String,Object>> update(@RequestBody StudentEntity st) {
    	stService.update(st);
    	Map<String,Object> map = new HashMap<String,Object>();
        map.put("name", "user");
        return new ResponseEntity<Map<String,Object>>(map,HttpStatus.ACCEPTED);
    }
    
    @PostMapping("insert")//post
    @ResponseStatus(code=HttpStatus.CREATED)
    public int insert(@RequestBody StudentEntity st) {
        int res=stService.insert(st);
        return res;
    }
    
    @DeleteMapping("delete/{id}")//delete
    //@ResponseStatus(code=HttpStatus.ACCEPTED)
    public ResponseEntity<Map<String,Object>> delete(@PathVariable("id") Integer id) {
    	int res=stService.delete(id);
    	Map<String,Object> map = new HashMap<String,Object>();
        map.put("name", "user");
        return new ResponseEntity<Map<String,Object>>(map,HttpStatus.ACCEPTED);
    }
	
}
