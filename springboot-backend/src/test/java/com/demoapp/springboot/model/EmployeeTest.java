package com.demoapp.springboot.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class EmployeeTest {


	@Test
	void testEmployeeParamterizedConstructor() {
		Employee e = new Employee("John", "Doe", "john.doe@gmail.com");
		assertEquals("John", e.getFirstName());
		assertEquals("Doe", e.getLastName());
		assertEquals("john.doe@gmail.com", e.getEmailId());
	}

	@Test
	void testEmployee() {
		Employee e = new Employee();
		assertNotNull(e);
	}

	@Test
	void testGetId() {
		Employee e = new Employee();
		e.setId(1);
		assertEquals(1, e.getId());
	}


	@Test
	void testGetFirstName() {
		Employee e = new Employee();
		e.setFirstName("John");
		assertEquals("John", e.getFirstName());
	}


	@Test
	void testGetLastName() {
		Employee e = new Employee();
		e.setLastName("Doe");
		assertEquals("Doe", e.getLastName());
	}


	@Test
	void testGetEmailId() {
		Employee e = new Employee();
		e.setEmailId("john.doe@gmail.com");
		assertEquals("john.doe@gmail.com", e.getEmailId());
	}


}
