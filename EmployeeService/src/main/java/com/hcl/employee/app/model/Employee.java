package com.hcl.employee.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "EMPLOYEES")
public class Employee {
	
	@Id
	@Column(name = "EMPLOYEE_CODE")
	private Long employeeCode;
	@NotEmpty(message = "Employee Name is required")
	@Size(max = 100, message = "Employee name can have max 100 characters")
    @Column(name = "EMPLOYEE_NAME")
   	private String employeeName;
	@NotEmpty(message = "Employee Gender is required")
	@NotEmpty
	@Size(max = 1, message = "Employee Gender can have max 1 character")
    @Column(name = "EMPLOYEE_GENDER")
   	private String employeeGender;
	@NotEmpty(message = "Employee Designation is required")
	@NotEmpty
    @Size(max = 100, message = "Employee employeeDesignation can have max 100 characters")
    @Column(name = "EMPLOYEE_DESIG")
   	private String employeeDesignation;
	@NotEmpty(message = "Employee Email is required")
	@NotEmpty
    @Size(max = 100, message = "Employee employeeEmail can have max 100 characters")
    @Column(name = "EMPLOYEE_EMAIL")
   	private String employeeEmail;
	@NotEmpty(message = "Employee Experience is required")
	@NotEmpty
    @Size(max = 2, message = "Employee employeeExp can have max 2 characters")
    @Column(name = "EMPLOYEE_EXPE")
   	private String employeeExp;
	@Column(name = "EMPLOYEE_PHONE")
   	private Long employeePhoneNo;
   	@NotEmpty(message = "Employee Location is required")
    @Size(max = 100, message = "Employee Location can have max 100 characters")
    @Column(name = "EMPLOYEE_LOC")
   	private String employeeLocation;
	@NotEmpty(message = "Employee Status is required")
    @Size(max = 100, message = "Employee Status can have max 100 characters")
    @Column(name = "EMPLOYEE_STATUS")
   	private String employeeStatus;
    
    public Employee(){
    	
    }
	public Employee(Long employeeCode, String employeeName,
			String employeeGender, String employeeDesignation,
			String employeeEmail, String employeeExp, Long employeePhoneNo,
			String employeeLocation, String employeeStatus) {
		super();
		this.employeeCode = employeeCode;
		this.employeeName = employeeName;
		this.employeeGender = employeeGender;
		this.employeeDesignation = employeeDesignation;
		this.employeeEmail = employeeEmail;
		this.employeeExp = employeeExp;
		this.employeePhoneNo = employeePhoneNo;
		this.employeeLocation = employeeLocation;
		this.employeeStatus = employeeStatus;
	}
	
	public Long getEmployeeCode() {
		return employeeCode;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public String getEmployeeGender() {
		return employeeGender;
	}
	public String getEmployeeDesignation() {
		return employeeDesignation;
	}
	public String getEmployeeEmail() {
		return employeeEmail;
	}
	public String getEmployeeExp() {
		return employeeExp;
	}
	public Long getEmployeePhoneNo() {
		return employeePhoneNo;
	}
	public String getEmployeeLocation() {
		return employeeLocation;
	}
	public String getEmployeeStatus() {
		return employeeStatus;
	}
	public void setEmployeeCode(Long employeeCode) {
		this.employeeCode = employeeCode;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public void setEmployeeGender(String employeeGender) {
		this.employeeGender = employeeGender;
	}
	public void setEmployeeDesignation(String employeeDesignation) {
		this.employeeDesignation = employeeDesignation;
	}
	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}
	public void setEmployeeExp(String employeeExp) {
		this.employeeExp = employeeExp;
	}
	public void setEmployeePhoneNo(Long employeePhoneNo) {
		this.employeePhoneNo = employeePhoneNo;
	}
	public void setEmployeeLocation(String employeeLocation) {
		this.employeeLocation = employeeLocation;
	}
	public void setEmployeeStatus(String employeeStatus) {
		this.employeeStatus = employeeStatus;
	}
	@Override
	public String toString() {
		return "Employee [employeeCode=" + employeeCode + ", employeeName="
				+ employeeName + ", employeeGender=" + employeeGender
				+ ", employeeDesignation=" + employeeDesignation
				+ ", employeeEmail=" + employeeEmail + ", employeeExp="
				+ employeeExp + ", employeePhoneNo=" + employeePhoneNo
				+ ", employeeLocation=" + employeeLocation
				+ ", employeeStatus=" + employeeStatus + "]";
	}
  
}
