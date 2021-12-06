package com.hcl.employee.activity.app.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEEACTIVITY")
public class EmployeeActivity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "employeeCode")
   	private Long employeeCode;
    @Column(name = "activityDate")
   	private String activityDate;
    @Column(name = "activityDescription")
   	private String activityDescription;
    @Column(name = "activityStatus")
   	private String activityStatus;
    
    public EmployeeActivity(){
    	
    }
    public EmployeeActivity(Long id, Long employeeCode, String activityDate,
			String activityDescription, String activityStatus) {
		super();
		this.id = id;
		this.employeeCode = employeeCode;
		this.activityDate = activityDate;
		this.activityDescription = activityDescription;
		this.activityStatus = activityStatus;
	}
    
	public Long getId() {
		return id;
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
	public void setId(Long id) {
		this.id = id;
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
		return "EmployeeActivity [id=" + id + ", employeeCode=" + employeeCode
				+ ", activityDate=" + activityDate + ", activityDescription="
				+ activityDescription + ", activityStatus=" + activityStatus
				+ "]";
	}

}
