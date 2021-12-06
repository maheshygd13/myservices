package com.hcl.employee.app.service;

import java.util.List;

import com.hcl.employee.app.model.Employee;

public interface EmployeeService {
	public Employee createEmployee(Employee article);
	public List<Employee> getAllEmployees();

}
