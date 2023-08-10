package com.demoapp.springboot.controller;

import com.demoapp.springboot.model.Employee;
import com.demoapp.springboot.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmployeesControllerTest {

    @Mock
    private EmployeeService mockEmployeeService;

    @InjectMocks
    private EmployeesController employeesControllerUnderTest;

    @Test
    void testGetAllEmployees() {
        final Employee employee = new Employee();
        employee.setId(0L);
        employee.setFirstName("firstName");
        employee.setLastName("lastName");
        employee.setEmailId("emailId");
        final List<Employee> expectedResult = List.of(employee);
        final Employee employee1 = new Employee();
        employee1.setId(0L);
        employee1.setFirstName("firstName");
        employee1.setLastName("lastName");
        employee1.setEmailId("emailId");
        final List<Employee> employees = List.of(employee1);
        when(mockEmployeeService.getAllEmployees()).thenReturn(employees);
        final List<Employee> result = employeesControllerUnderTest.getAllEmployees();
        assertEquals(expectedResult, result);
    }

    @Test
    void testGetAllEmployees_EmployeeServiceReturnsNoItems() {
        when(mockEmployeeService.getAllEmployees()).thenReturn(Collections.emptyList());
        final List<Employee> result = employeesControllerUnderTest.getAllEmployees();
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    void testCreateEmployee() {
        final Employee employee = new Employee();
        employee.setId(0L);
        employee.setFirstName("firstName");
        employee.setLastName("lastName");
        employee.setEmailId("emailId");

        final Employee expectedResult = new Employee();
        expectedResult.setId(0L);
        expectedResult.setFirstName("firstName");
        expectedResult.setLastName("lastName");
        expectedResult.setEmailId("emailId");
        final Employee employee1 = new Employee();
        employee1.setId(0L);
        employee1.setFirstName("firstName");
        employee1.setLastName("lastName");
        employee1.setEmailId("emailId");
        final Employee employee2 = new Employee();
        employee2.setId(0L);
        employee2.setFirstName("firstName");
        employee2.setLastName("lastName");
        employee2.setEmailId("emailId");
        when(mockEmployeeService.createEmployee(employee2)).thenReturn(employee1);
        final Employee result = employeesControllerUnderTest.createEmployee(employee);
        assertEquals(expectedResult, result);
    }

    @Test
    void testGetEmployeeById() {
        final Employee employee = new Employee();
        employee.setId(0L);
        employee.setFirstName("firstName");
        employee.setLastName("lastName");
        employee.setEmailId("emailId");
        final Employee employee1 = new Employee();
        employee1.setId(0L);
        employee1.setFirstName("firstName");
        employee1.setLastName("lastName");
        employee1.setEmailId("emailId");
        when(mockEmployeeService.getEmployeeById(0L)).thenReturn(employee1);
        final ResponseEntity<Employee> expectedResult = new ResponseEntity<>(employee, HttpStatus.OK);
        final ResponseEntity<Employee> result = employeesControllerUnderTest.getEmployeeById(0L);
        assertEquals(expectedResult, result);
    }


    @Test
    void testUpdateEmployee() {
        final Employee employee = new Employee();
        employee.setId(0L);
        employee.setFirstName("firstName");
        employee.setLastName("lastName");
        employee.setEmailId("emailId");
        final Employee updatedEmployee = new Employee();
        updatedEmployee.setId(0L);
        updatedEmployee.setFirstName("updatedFirstName");
        updatedEmployee.setLastName("updatedLastName");
        updatedEmployee.setEmailId("updatedEmailId");
        when(mockEmployeeService.updateEmployee(0L, employee)).thenReturn(updatedEmployee);
        final ResponseEntity<Employee> expectedResult = new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
        final ResponseEntity<Employee> result = employeesControllerUnderTest.updateEmployee(0L, employee);
        assertEquals(expectedResult, result);
    }


    @Test
    void testDeleteEmployee() {
        final ResponseEntity<Boolean> expectedResult = new ResponseEntity<>(false, HttpStatus.OK);
        when(mockEmployeeService.deleteEmployee(0L)).thenReturn(false);
        final ResponseEntity<Boolean> result = employeesControllerUnderTest.deleteEmployee(0L);
        assertEquals(expectedResult, result);
    }
}
