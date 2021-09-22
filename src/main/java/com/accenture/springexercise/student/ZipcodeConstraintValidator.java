package com.accenture.springexercise.student;

import javax.annotation.Resource;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ZipcodeConstraintValidator implements ConstraintValidator<ZipCodeValidation, StudentInfoForm>{
	
 
    
    @Override
    public boolean isValid(StudentInfoForm st, ConstraintValidatorContext context) {
        if(st.getAddress()!=null) {
        	if(st.getZipcode()==null) {
        		return false;
        	}else {
        		return true;
        	}
        }else {
        	return true;
        }
    }

}
