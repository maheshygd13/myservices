package com.hcl.employee.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.employee.app.model.Employee;
import com.hcl.employee.app.repository.EmployeeRepository;
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}
}
