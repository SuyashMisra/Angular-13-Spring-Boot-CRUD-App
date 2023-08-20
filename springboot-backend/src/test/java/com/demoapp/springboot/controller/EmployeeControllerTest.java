package com.demoapp.springboot.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.demoapp.springboot.model.Employee;
import com.demoapp.springboot.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {

	
	@MockBean
	private EmployeeService employeeService;
	
	@Autowired
	private MockMvc mockMvc;
	
	ObjectMapper objectMapper = new ObjectMapper();
	ObjectWriter objectWriter = objectMapper.writer();
	

	@Test
	void testGetAllEmployees() throws Exception {
		when(employeeService.getAllEmployees()).thenReturn(Arrays.asList(
					new Employee("Suyash","Misra","abcd@gmail.com"),
					new Employee("John","Doe","john.doe@gmail.com")
					)
				);
		
		RequestBuilder request = MockMvcRequestBuilders
				.get("/api/v1/employees").accept(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("[{firstName:Suyash, lastName:Misra, emailId:abcd@gmail.com},{firstName:John, lastName:Doe, emailId:john.doe@gmail.com}]"))
				.andReturn();
		
	}

	@Test
	void testCreateEmployee() throws Exception {
		Employee e = new Employee("John","Doe","john.doe@gmail.com");
		when(employeeService.createEmployee(Mockito.any(Employee.class))).thenReturn(e);
		
		String req = objectWriter.writeValueAsString(e);
		
		RequestBuilder request = MockMvcRequestBuilders
				.post("/api/v1/employees")
				.contentType(MediaType.APPLICATION_JSON)
				.content(req)
				.accept(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("{firstName:John, lastName:Doe, emailId:john.doe@gmail.com}"))
				.andReturn();
				
	}

	@Test
	void testGetEmployeeById() throws Exception {
		when(employeeService.getEmployeeById(1L)).thenReturn(
				new Employee("John","Doe","john.doe@gmail.com")
			);
	
		RequestBuilder request = MockMvcRequestBuilders
				.get("/api/v1/employees/{id}", 1).accept(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("{firstName:John, lastName:Doe, emailId:john.doe@gmail.com}"))
				.andReturn();
	}

	@Test
	void testUpdateEmployee() throws Exception {
		Employee e = new Employee("John","Doe","john.doe@gmail.com");
		when(employeeService.updateEmployee(any(), Mockito.any(Employee.class))).thenReturn(e);
		
		String req = objectWriter.writeValueAsString(e);
		
		RequestBuilder request = MockMvcRequestBuilders
				.put("/api/v1/employees/{id}", 0)
				.contentType(MediaType.APPLICATION_JSON)
				.content(req)
				.accept(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("{firstName:John, lastName:Doe, emailId:john.doe@gmail.com}"))
				.andReturn();
	}

	@Test
	void testDeleteEmployee() throws Exception {
		when(employeeService.deleteEmployee(1L)).thenReturn(true);
	
		RequestBuilder request = MockMvcRequestBuilders
				.delete("/api/v1/employees/{id}", 1).accept(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().string("true"))
				.andReturn();
	}

}
