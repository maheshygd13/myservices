package com.hcl.app.delegate;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class EmployeeServiceDelegate {
	@Autowired
	RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "callEmpServiceAndGetData_Fallback")
	public String callempServiceAndGetData(String deptName) {
		System.out.println("Getting Dept details for " + deptName);
		String response = restTemplate
				.exchange("http://localhost:8098/getEmpDetailsForDept/{deptName}"
				, HttpMethod.GET
				, null
				, new ParameterizedTypeReference<String>() {
			}, deptName).getBody();

		System.out.println("Response Received as " + response + " -  " + new Date());

		return "NORMAL FLOW !!! - Dept Name -  " + deptName + " :::  Employee Details " + response + " -  " + new Date();
	}
	
	@SuppressWarnings("unused")
	private String callEmpServiceAndGetData_Fallback(String deptName) {
		System.out.println("Employee Service is down!!! fallback route enabled...");
		return "CIRCUIT BREAKER ENABLED!!!No Response From Employee Service at this moment. Service will be Up Based on Availability - " + new Date();
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
