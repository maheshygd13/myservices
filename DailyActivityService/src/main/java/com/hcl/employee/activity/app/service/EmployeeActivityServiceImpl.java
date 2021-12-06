package com.hcl.employee.activity.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.employee.activity.app.model.EmployeeActivity;
import com.hcl.employee.activity.app.repository.EmployeeActivityRepository;
@Service
public class EmployeeActivityServiceImpl implements EmployeeActivityService {

	@Autowired
	private EmployeeActivityRepository employeeRepository;

	@Override
	public EmployeeActivity addDailyActivity(EmployeeActivity employee) {
		return employeeRepository.save(employee);
	}
	@Override
	public List<EmployeeActivity> viewDailyActivities() {
		return employeeRepository.findAll();
	}
}
