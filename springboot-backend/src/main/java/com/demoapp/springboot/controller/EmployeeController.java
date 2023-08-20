package com.demoapp.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demoapp.springboot.model.Employee;
import com.demoapp.springboot.service.EmployeeService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/v1/")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	
	//get all employees
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	
	
	//create employee
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeService.createEmployee(employee);
	}
	
	
	//get employee by id
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
		Employee employee = employeeService.getEmployeeById(id);
		return ResponseEntity.ok(employee);
	}
	
	//update employee
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
		Employee emp = employeeService.updateEmployee(id, employee);
		
		return ResponseEntity.ok(emp);
	}
	
	//delete employee
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Boolean> deleteEmployee(@PathVariable Long id){
		boolean deleted = employeeService.deleteEmployee(id);
		return ResponseEntity.ok(deleted);
	}
	
}
