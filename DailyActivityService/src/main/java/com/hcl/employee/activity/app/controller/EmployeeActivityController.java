package com.hcl.employee.activity.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.employee.activity.app.exception.*;
import com.hcl.employee.activity.app.model.EmployeeActivity;
import com.hcl.employee.activity.app.repository.EmployeeActivityRepository;
import com.hcl.employee.activity.app.service.EmployeeActivityService;

@RestController
@RequestMapping("/api/dailyactivity")
public class EmployeeActivityController {
	@Autowired
	private EmployeeActivityRepository employeeRepository;
	@Autowired
	private EmployeeActivityService employeeService;
	
	@PostMapping(value = "/add", consumes = { "application/json" }, produces = { "application/json" })
	public EmployeeActivity addDailyActivity(@Valid @RequestBody EmployeeActivity employeeActivity) {
		return employeeService.addDailyActivity(employeeActivity);
	}

	@GetMapping("/dailyactivity")
	public List<EmployeeActivity> viewDailyActivities() {
		return employeeService.viewDailyActivities();
	}

	@GetMapping("/getEmployee/{employeeCode}")
	public ResponseEntity<EmployeeActivity> viewDailyActivitywithname(
			@PathVariable(value = "employeeCode") Long employeeId)
			throws ResourceNotFoundException {
		EmployeeActivity employee = employeeRepository.findById(employeeId).orElseThrow(
				() -> new ResourceNotFoundException(
						"Employee not found for this id :: " + employeeId));
		return ResponseEntity.ok().body(employee);
	}

	@PutMapping("/updateEmployee/{employeeCode}")
	public ResponseEntity<EmployeeActivity> updateEmployee(
			@PathVariable(value = "employeeCode") Long employeeId,
			@Valid @RequestBody EmployeeActivity employeeDetails)
			throws ResourceNotFoundException {
		EmployeeActivity employee = employeeRepository.findById(employeeId).orElseThrow(
				() -> new ResourceNotFoundException(
						"Employee not found for this id :: " + employeeId));
		//employee.setTitle(employeeDetails.getTitle());
		//employee.setDescription(employeeDetails.getDescription());
		//employee.setBody(employeeDetails.getBody());
		final EmployeeActivity updateEmployee = employeeRepository.save(employee);
		return ResponseEntity.ok(updateEmployee);
	}

	@DeleteMapping("/deleteEmployee/{employeeCode}")
	public Map<String, Boolean> deleteEmployee(
			@PathVariable(value = "employeeCode") Long employeeId)
			throws ResourceNotFoundException {
		EmployeeActivity employee = employeeRepository.findById(employeeId).orElseThrow(
				() -> new ResourceNotFoundException(
						"employee not found for this id :: " + employeeId));
		employeeRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
