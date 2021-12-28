package com.hcl.app.domain;

public class Employee {
	private int employeeCode;
	private String employeeName;
	
	public int getEmployeeCode() {
		return employeeCode;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeCode(int employeeCode) {
		this.employeeCode = employeeCode;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public Employee(int employeeCode, String employeeName) {
		super();
		this.employeeCode = employeeCode;
		this.employeeName = employeeName;
	}

	
}
