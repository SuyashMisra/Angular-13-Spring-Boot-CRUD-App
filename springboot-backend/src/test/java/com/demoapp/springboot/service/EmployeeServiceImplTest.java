package com.demoapp.springboot.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.demoapp.springboot.exception.ResourceNotFoundException;
import com.demoapp.springboot.model.Employee;
import com.demoapp.springboot.repository.EmployeeRepository;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {
	
	@Mock
	private EmployeeRepository employeeRepository;
	
	@InjectMocks
	private EmployeeServiceImpl employeeService;
	

	@Test
	void testGetAllEmployees() {
		when(employeeRepository.findAll()).thenReturn(Arrays.asList(
				new Employee("Suyash","Misra","abcd@gmail.com"),
				new Employee("John","Doe","john.doe@gmail.com")
			));
		List<Employee> allEmployees = employeeService.getAllEmployees();
		assertEquals("Suyash", allEmployees.get(0).getFirstName());
		assertEquals("Misra", allEmployees.get(0).getLastName());
		assertEquals("abcd@gmail.com", allEmployees.get(0).getEmailId());
		assertEquals("John", allEmployees.get(1).getFirstName());
		assertEquals("Doe", allEmployees.get(1).getLastName());
		assertEquals("john.doe@gmail.com", allEmployees.get(1).getEmailId());
	}
	
	@Test
	void testGetEmployeeById_whenEmployeeDoesNotExist() {
		when(employeeRepository.findById(any())).thenReturn(Optional.empty());
		assertThrows(ResourceNotFoundException.class, () -> employeeService.getEmployeeById(0L), "Employee does not exist with id: 0");
	}

	@Test
	void testGetEmployeeById_whenEmployeeExists() {
		when(employeeRepository.findById(1L)).thenReturn(Optional.of(new Employee("Suyash","Misra","abcd@gmail.com")));
		Employee employee = employeeService.getEmployeeById(1L);
		assertEquals("Suyash", employee.getFirstName());
		assertEquals("Misra", employee.getLastName());
		assertEquals("abcd@gmail.com", employee.getEmailId());
	}
	
	
	

	@Test
	void testCreateEmployee() {
		Employee e = new Employee("John", "Doe", "john.doe@gmail.com");
		when(employeeRepository.save(e)).thenReturn(e);
		Employee employee = employeeService.createEmployee(e);
		assertEquals("John", employee.getFirstName());
		assertEquals("Doe", employee.getLastName());
		assertEquals("john.doe@gmail.com", employee.getEmailId());
	}

	@Test
	void testUpdateEmployee() {
		Employee updatedEmployee = new Employee("John", "Doe", "john.doe@gmail.com");
		Employee originalEmployee = new Employee("Suyash", "Misra", "abcd@gmail.com");
		when(employeeRepository.findById(any())).thenReturn(Optional.of(originalEmployee));
		when(employeeRepository.save(any())).thenReturn(updatedEmployee);
		Employee employee = employeeService.updateEmployee(1L,updatedEmployee);
		assertEquals("John", employee.getFirstName());
		assertEquals("Doe", employee.getLastName());
		assertEquals("john.doe@gmail.com", employee.getEmailId());
	}

	@Test
	void testDeleteEmployee_whenEmployeeExists() {
		when(employeeRepository.findById(1L)).thenReturn(Optional.of(new Employee("Suyash","Misra","abcd@gmail.com")));
		boolean result = employeeService.deleteEmployee(1L);
		assertTrue(result);
	}
	
	@Test
	void testDeleteEmployee_whenEmployeeDoesNotExist() {
		when(employeeRepository.findById(1L)).thenReturn(Optional.empty());
		boolean result = employeeService.deleteEmployee(1L);
		assertFalse(result);
	}

}
