package com.demoapp.springboot.service;

import com.demoapp.springboot.exception.ResourceNotFoundException;
import com.demoapp.springboot.model.Employee;
import com.demoapp.springboot.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {

    @Mock
    private EmployeeRepository mockEmployeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeServiceImplUnderTest;

    @Test
    void testGetAllEmployees() {
        // Setup
        final Employee employee = new Employee();
        employee.setId(0L);
        employee.setFirstName("firstName");
        employee.setLastName("lastName");
        employee.setEmailId("emailId");
        final List<Employee> expectedResult = List.of(employee);

        // Configure EmployeeRepository.findAll(...).
        final Employee employee1 = new Employee();
        employee1.setId(0L);
        employee1.setFirstName("firstName");
        employee1.setLastName("lastName");
        employee1.setEmailId("emailId");
        final List<Employee> employees = List.of(employee1);
        when(mockEmployeeRepository.findAll()).thenReturn(employees);

        // Run the test
        final List<Employee> result = employeeServiceImplUnderTest.getAllEmployees();

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    void testGetAllEmployees_EmployeeRepositoryReturnsNoItems() {
        // Setup
        when(mockEmployeeRepository.findAll()).thenReturn(Collections.emptyList());

        // Run the test
        final List<Employee> result = employeeServiceImplUnderTest.getAllEmployees();

        // Verify the results
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    void testCreateEmployee() {
        // Setup
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

        // Configure EmployeeRepository.save(...).
        final Employee employee1 = new Employee();
        employee1.setId(0L);
        employee1.setFirstName("firstName");
        employee1.setLastName("lastName");
        employee1.setEmailId("emailId");
        final Employee entity = new Employee();
        entity.setId(0L);
        entity.setFirstName("firstName");
        entity.setLastName("lastName");
        entity.setEmailId("emailId");
        when(mockEmployeeRepository.save(entity)).thenReturn(employee1);

        // Run the test
        final Employee result = employeeServiceImplUnderTest.createEmployee(employee);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    void testGetEmployeeById() {
        // Setup
        final Employee expectedResult = new Employee();
        expectedResult.setId(0L);
        expectedResult.setFirstName("firstName");
        expectedResult.setLastName("lastName");
        expectedResult.setEmailId("emailId");

        // Configure EmployeeRepository.findById(...).
        final Employee employee1 = new Employee();
        employee1.setId(0L);
        employee1.setFirstName("firstName");
        employee1.setLastName("lastName");
        employee1.setEmailId("emailId");
        final Optional<Employee> employee = Optional.of(employee1);
        when(mockEmployeeRepository.findById(0L)).thenReturn(employee);

        // Run the test
        final Employee result = employeeServiceImplUnderTest.getEmployeeById(0L);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    void testGetEmployeeById_EmployeeRepositoryReturnsAbsent() {
        // Setup
        when(mockEmployeeRepository.findById(0L)).thenReturn(Optional.empty());

        // Run the test
        assertThrows(ResourceNotFoundException.class, () -> employeeServiceImplUnderTest.getEmployeeById(0L));
    }

    @Test
    void testUpdateEmployee() {
        // Setup
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

        // Configure EmployeeRepository.findById(...).
        final Employee employee2 = new Employee();
        employee2.setId(0L);
        employee2.setFirstName("firstName");
        employee2.setLastName("lastName");
        employee2.setEmailId("emailId");
        final Optional<Employee> employee1 = Optional.of(employee2);
        when(mockEmployeeRepository.findById(0L)).thenReturn(employee1);

        // Configure EmployeeRepository.save(...).
        final Employee employee3 = new Employee();
        employee3.setId(0L);
        employee3.setFirstName("firstName");
        employee3.setLastName("lastName");
        employee3.setEmailId("emailId");
        final Employee entity = new Employee();
        entity.setId(0L);
        entity.setFirstName("firstName");
        entity.setLastName("lastName");
        entity.setEmailId("emailId");
        when(mockEmployeeRepository.save(entity)).thenReturn(employee3);

        // Run the test
        final Employee result = employeeServiceImplUnderTest.updateEmployee(0L, employee);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    void testUpdateEmployee_EmployeeRepositoryFindByIdReturnsAbsent() {
        // Setup
        final Employee employee = new Employee();
        employee.setId(0L);
        employee.setFirstName("firstName");
        employee.setLastName("lastName");
        employee.setEmailId("emailId");

        when(mockEmployeeRepository.findById(0L)).thenReturn(Optional.empty());

        // Run the test
        assertThrows(ResourceNotFoundException.class, () -> employeeServiceImplUnderTest.updateEmployee(0L, employee));
    }

    @Test
    void testDeleteEmployee() {
        // Setup
        // Configure EmployeeRepository.findById(...).
        final Employee employee1 = new Employee();
        employee1.setId(0L);
        employee1.setFirstName("firstName");
        employee1.setLastName("lastName");
        employee1.setEmailId("emailId");
        final Optional<Employee> employee = Optional.of(employee1);
        when(mockEmployeeRepository.findById(0L)).thenReturn(employee);

        // Run the test
        final boolean result = employeeServiceImplUnderTest.deleteEmployee(0L);

        // Verify the results
        assertTrue(result);

        // Confirm EmployeeRepository.delete(...).
        final Employee entity = new Employee();
        entity.setId(0L);
        entity.setFirstName("firstName");
        entity.setLastName("lastName");
        entity.setEmailId("emailId");
        verify(mockEmployeeRepository).delete(entity);
    }

    @Test
    void testDeleteEmployee_EmployeeRepositoryFindByIdReturnsAbsent() {
        // Setup
        when(mockEmployeeRepository.findById(0L)).thenReturn(Optional.empty());

        // Run the test
        final boolean result = employeeServiceImplUnderTest.deleteEmployee(0L);

        // Verify the results
        assertFalse(result);
    }
}
