package com.hcl.app.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.app.domain.Employee;

@RestController
public class EmployeeServiceController {

	private static Map<String, List<Employee>> departmentDB = new HashMap<String, List<Employee>>();

	static {
		departmentDB = new HashMap<String, List<Employee>>();

		List<Employee> lst = new ArrayList<Employee>();
		Employee employee = new Employee(52017416, "Employee1");
		lst.add(employee);
		employee = new Employee(52017416, "Employee2");
		lst.add(employee);

		departmentDB.put("IT", lst);

		lst = new ArrayList<Employee>();
		employee = new Employee(52017415, "HR1");
		lst.add(employee);
		employee = new Employee(52017414, "HR2");
		lst.add(employee);

		departmentDB.put("HR", lst);

	}

	@RequestMapping(value = "/getEmpDetailsForDept/{deptname}", method = RequestMethod.GET)
	public List<Employee> getEmployees(@PathVariable String deptname) {
		System.out.println("Getting Employee details for " + deptname);

		List<Employee> empList = departmentDB.get(deptname);
		if (empList == null) {
			empList = new ArrayList<Employee>();
			Employee employee = new Employee(0, "N/A");
			empList.add(employee);
		}
		return empList;
	}
}
