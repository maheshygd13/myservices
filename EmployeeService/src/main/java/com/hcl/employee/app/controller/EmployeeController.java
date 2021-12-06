package com.hcl.employee.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hcl.employee.app.empactivityproxy.EmployeeActivityProxy;
import com.hcl.employee.app.exception.*;
import com.hcl.employee.app.model.Employee;
import com.hcl.employee.app.model.EmployeeActivity;
import com.hcl.employee.app.repository.EmployeeRepository;
import com.hcl.employee.app.service.EmployeeService;
import org.springframework.http.HttpStatus;
@RestController
@RequestMapping("/api/employee")
@Validated
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired(required=true)
	EmployeeActivityProxy employeeActivityProxy;
	
	 @PostMapping("/createEmployee")
	 @ResponseStatus(HttpStatus.CREATED)
	 Employee createEmployee(@Valid @RequestBody Employee employee) {
	        return employeeService.createEmployee(employee);
	    }
	 
	@GetMapping("/getEmployees")
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	@GetMapping("/getEmployee/{employeeCode}")
	public ResponseEntity<Employee> getEmployeeId(
			@PathVariable (value = "employeeCode") long employeeCode)
			throws EmployeeNotFoundException {
		Employee employee = employeeRepository.findById(employeeCode).orElseThrow(
				() -> new EmployeeNotFoundException(
						"Employee not found for this id :: " + employeeCode));
		return ResponseEntity.ok().body(employee);
	}

	@PutMapping("/updateEmployee/{employeeCode}")
	public ResponseEntity<Employee> updateEmployee(
			@PathVariable(value = "employeeCode") Long employeeId,
			@Valid @RequestBody Employee employeeDetails)
			throws EmployeeNotFoundException {
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(
				() -> new EmployeeNotFoundException(
						"Employee not found for this id :: " + employeeId));
		employee.setEmployeePhoneNo(employeeDetails.getEmployeePhoneNo());
		employee.setEmployeeLocation(employeeDetails.getEmployeeLocation());
		employee.setEmployeeStatus(employeeDetails.getEmployeeStatus());
		final Employee updateEmployee = employeeRepository.save(employee);
		return ResponseEntity.ok(updateEmployee);
	}

	@DeleteMapping("/deleteEmployee/{employeeCode}")
	public Map<String, Boolean> deleteEmployee(
			@PathVariable(value = "employeeCode") Long employeeId)
			throws EmployeeNotFoundException {
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(
				() -> new EmployeeNotFoundException(
						"employee not found for this id :: " + employeeId));
		employeeRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	@GetMapping("/dailyactivity")
	public List<EmployeeActivity> viewDailyActivities() {
		List<EmployeeActivity> response = employeeActivityProxy.viewDailyActivities();
		return response;
	}
}
