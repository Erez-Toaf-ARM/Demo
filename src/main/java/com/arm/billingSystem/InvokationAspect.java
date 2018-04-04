package com.arm.billingSystem;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;




@Aspect
public class InvokationAspect {
	@Autowired
	private ControllerMethodsInvocationMap controllerMethodsInvocationMap;
	
		
	//@Before ("execution (com.arm.billingSystem.SystemArchitecture.callPublicMethod())")
	//@Before (value = "com.arm.billingSystem.SystemArchitecture.callPublicMethod()")
	@Before("execution (public com.arm.billingSystem.BillingSystemsController *(..))")
	public void countInvokations(JoinPoint joinPoint) {
		System.out.println("1");
		String methodName = joinPoint.getSignature().getName();
		Integer numberOfOccurences = controllerMethodsInvocationMap.getMethodInvocationNumber(methodName);
		numberOfOccurences ++;
				
		controllerMethodsInvocationMap.increaseMethodInvocationsNumber(methodName, numberOfOccurences);
	}
	
	
	
}
