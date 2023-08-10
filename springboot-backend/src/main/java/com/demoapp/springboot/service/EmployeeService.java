package com.demoapp.springboot.service;
import java.util.List;

import com.demoapp.springboot.model.Employee;
public interface EmployeeService {
    List<Employee> getAllEmployees();

    Employee createEmployee(Employee employee);

    Employee getEmployeeById(Long id);

    Employee updateEmployee(Long id, Employee employee);

    boolean deleteEmployee(Long id);
}
