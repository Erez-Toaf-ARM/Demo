package com.arm.billingSystem;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
//@Aspect
public class SystemArchitecture {
	
	//@Pointcut("execution(public com.arm.billingSystem.BillingSystemsController.*(..))")
	public void callPublicMethod() {
		System.out.println("Hi");
	}

}
