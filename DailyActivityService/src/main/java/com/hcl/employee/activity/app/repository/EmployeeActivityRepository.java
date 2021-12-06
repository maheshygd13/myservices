package com.hcl.employee.activity.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.employee.activity.app.model.EmployeeActivity;

public interface EmployeeActivityRepository extends JpaRepository<EmployeeActivity, Long> {

}
