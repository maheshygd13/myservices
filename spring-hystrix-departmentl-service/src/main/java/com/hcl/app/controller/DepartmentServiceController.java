package com.hcl.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.app.delegate.EmployeeServiceDelegate;

@RestController
public class DepartmentServiceController {
	
	@Autowired
	EmployeeServiceDelegate empServiceDelegate;

	@RequestMapping(value = "/getDeptDetails/{deptName}", method = RequestMethod.GET)
	public String getStudents(@PathVariable String deptName) {
		System.out.println("Going to call employee service to get data!");
		return empServiceDelegate.callempServiceAndGetData(deptName);
	}
	
}
