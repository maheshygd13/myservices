package com.hcl.employee.app.model;

public class EmployeeActivity {
	
	private Long employeeCode;
	private String activityDate;
	private String activityDescription;
	private String activityStatus;
	
	public EmployeeActivity(){
		
	}
	public EmployeeActivity(Long employeeCode, String activityDate,
			String activityDescription, String activityStatus) {
		super();
		this.employeeCode = employeeCode;
		this.activityDate = activityDate;
		this.activityDescription = activityDescription;
		this.activityStatus = activityStatus;
	}
	
	public Long getEmployeeCode() {
		return employeeCode;
	}
	public String getActivityDate() {
		return activityDate;
	}
	public String getActivityDescription() {
		return activityDescription;
	}
	public String getActivityStatus() {
		return activityStatus;
	}
	public void setEmployeeCode(Long employeeCode) {
		this.employeeCode = employeeCode;
	}
	public void setActivityDate(String activityDate) {
		this.activityDate = activityDate;
	}
	public void setActivityDescription(String activityDescription) {
		this.activityDescription = activityDescription;
	}
	public void setActivityStatus(String activityStatus) {
		this.activityStatus = activityStatus;
	}
	@Override
	public String toString() {
		return "EmployeeActivity [employeeCode=" + employeeCode
				+ ", activityDate=" + activityDate + ", activityDescription="
				+ activityDescription + ", activityStatus=" + activityStatus
				+ "]";
	}
 
   
}
