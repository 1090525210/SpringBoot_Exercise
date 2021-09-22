package com.accenture.springexercise.student;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;


@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ZipcodeConstraintValidator.class)
@Target(ElementType.TYPE)
public @interface ZipCodeValidation {
	
	    String message() default "{zipcode.invalid}";
	    Class<?>[] groups() default {};
	    Class<? extends Payload>[] payload() default {};
	    
	
}
