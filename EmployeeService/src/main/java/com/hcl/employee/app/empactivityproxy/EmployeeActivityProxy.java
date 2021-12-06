package com.hcl.employee.app.empactivityproxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hcl.employee.app.model.EmployeeActivity;


@FeignClient(name="DailyActivity-Service" )
public interface EmployeeActivityProxy {
	
	   @RequestMapping("/api/dailyactivity/dailyactivity")
	   public List<EmployeeActivity> viewDailyActivities();

}
