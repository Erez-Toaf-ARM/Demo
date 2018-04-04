package com.arm.billingSystem;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;


@Component
public class ControllerMethodsInvocationMap {
	private Map<String, Integer> methodsInvikationMap = new HashMap<String, Integer>();
	
	
	public ControllerMethodsInvocationMap() {
		super();
	}
	
	
	public ControllerMethodsInvocationMap(Map<String, Integer> methodsInvikationMap) {
		super();
		this.methodsInvikationMap = methodsInvikationMap;
	}


	public void setMethodsInvikationMap(Map<String, Integer> methodsInvikationMap) {
		this.methodsInvikationMap = methodsInvikationMap;
	}


	public Map<String, Integer> getInvokationMap() {
		return methodsInvikationMap;
	}
	
	
	public Integer getMethodInvocationNumber(String methodName) {
		Integer numOfInvocations = methodsInvikationMap.get(methodName);
		if (numOfInvocations == null)
			numOfInvocations = 0;
		
		return numOfInvocations;
	}
	
	
	public void increaseMethodInvocationsNumber(String methodName, Integer numberOfOccurences) {
		methodsInvikationMap.put(methodName, numberOfOccurences); 
	}
	


	@Override
	public String toString() {
		return "InvokationAspect [methodsInvikationMap=" + methodsInvikationMap + "]";
	}

}
