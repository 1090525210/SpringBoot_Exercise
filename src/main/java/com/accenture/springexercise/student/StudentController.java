package com.accenture.springexercise.student;



import javax.validation.Valid;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
@RequestMapping("/user")
public class StudentController {
	
	public static final Logger LOGGER = LogManager.getLogger(StudentController.class);
	
    @Autowired
    private StudentService stService;

    @RequestMapping(value="/save", method=RequestMethod.POST)
    @ResponseBody
    public StudentInfoForm postRequest(@Valid @RequestBody StudentInfoForm st,BindingResult bingdingResult) {
        
    	if(bingdingResult.hasErrors()) {
    		bingdingResult.getFieldErrors().forEach(fieldError ->LOGGER.error("error field is :{}, message is :{}",fieldError.getField(),fieldError.getDefaultMessage()));
    		
    		throw new RuntimeException("Form has error!");
    	}
    	return stService.postRequest(st);
    }
	
}
