package com.hcl.employee.activity.app.service;

import java.util.List;

import com.hcl.employee.activity.app.model.EmployeeActivity;

public interface EmployeeActivityService {
	public EmployeeActivity addDailyActivity(EmployeeActivity article);
	public List<EmployeeActivity> viewDailyActivities();

}
