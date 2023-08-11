package com.demoapp.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demoapp.springboot.exception.ResourceNotFoundException;
import com.demoapp.springboot.model.Employee;
import com.demoapp.springboot.repository.EmployeeRepository;

@Component
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(Long id) {
		return employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee does not exist with id: " + id));
	}

	@Override
	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee updateEmployee(Long id, Employee employee) {
		Employee emp = getEmployeeById(id);
		emp.setEmailId(employee.getEmailId());
		emp.setFirstName(employee.getFirstName());
		emp.setLastName(employee.getLastName());
		employeeRepository.save(emp);
		return null;
	}

	@Override
	public boolean deleteEmployee(Long id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		if(employee.isPresent()) {
			employeeRepository.deleteById(id);
			return true;
		}
		return false;
	}

	
}
