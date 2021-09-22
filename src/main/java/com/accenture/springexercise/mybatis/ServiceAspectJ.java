package com.accenture.springexercise.mybatis;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Component;

import com.accenture.springexercise.student.StudentController;



@Aspect
@Component
public class ServiceAspectJ {
	public static final Logger logger = LogManager.getLogger(StudentController.class);

	private final String POINT_CUT = "execution(* com.accenture.springexercise.mybatis.service.StudentService.selectbyId(..))";
	
	@Pointcut(POINT_CUT)
	private void pointcut(){}
	
	@Before(value = POINT_CUT)
	public void before(JoinPoint joinPoint) {
		String className = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
		StringBuilder log = new StringBuilder();
		log.append("before: ")
		.append(className)
		.append("@")
		.append(methodName)
		.append(" , params: ");
		Object[] args = joinPoint.getArgs();
		for (Object arg : args) {
			log.append(arg.toString() + ", ");
		}
		logger.info(log.toString());
	}
	
	@AfterReturning(value = "pointcut()", returning = "returnObj")
	public void afterReturn(Object returnObj) {
		//String result = JSONObject.toString(returnObj);
		logger.info("afterReturning: "+returnObj.toString());
	}
	
	@AfterThrowing(value = POINT_CUT, throwing = "e")
	public void afterThrowing(Throwable e) {
		logger.error("afterThrowing: "+e.getMessage(), e);
	}
	
	@Around(value = "pointcut()")
	public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		Long begin = System.currentTimeMillis();
		StringBuilder log = new StringBuilder("around: ");
		Object result = null;
		try {
			result = proceedingJoinPoint.proceed();
		} catch (Exception e) {
			logger.error(log + e.getMessage(), e);
		}
		Long end = System.currentTimeMillis();
		log.append(" 执行时间: ")
		.append(end-begin)
		.append("ms");
		return result;
	}

}
