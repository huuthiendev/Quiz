package com.tma.log;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Logging {
	@Pointcut("execution(* com.tma.controllers.UserController.listUsers(..))")
	private void allMethodInUser(){}
	
	@Before("allMethodInUser() && requestMapping()")
	public void attributesBeforeUserMethod(JoinPoint joinPoint){
		System.out.println("Method '" + getName(joinPoint) + "' is triggered" );
		System.out.println("Parameter : ");
		Object[] parameters = joinPoint.getArgs(); 
		
		int count = 1;
		for(Object param: parameters){
			System.out.println("param " + count++ + " : " + param.getClass().getName());
		}
	}

    @Pointcut("within(@org.springframework.web.bind.annotation.RequestMapping *)")
    public void requestMapping() {}
	
	@AfterReturning(pointcut = "allMethodInUser()", returning="retVal")
	private void resultFromUserMethod(Object retVal){
		System.out.println("returning : ");
		System.out.println(retVal);
	}
	
	
	String getName(JoinPoint joinPoint){
		return  joinPoint.getSignature().getName() + "() : "
                + Arrays.toString(joinPoint.getArgs());
	}
}
