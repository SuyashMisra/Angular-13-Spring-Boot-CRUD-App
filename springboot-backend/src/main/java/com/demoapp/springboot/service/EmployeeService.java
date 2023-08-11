package com.demoapp.springboot.service;

import java.util.List;

import com.demoapp.springboot.model.Employee;

public interface EmployeeService {
	
	public List<Employee> getAllEmployees();
	
	public Employee createEmployee(Employee employee);
	
	public Employee getEmployeeById(Long id);
	
	public Employee updateEmployee(Long id, Employee employee);
	
	public boolean deleteEmployee(Long id);

}
