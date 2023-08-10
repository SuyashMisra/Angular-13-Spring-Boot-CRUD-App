package com.demoapp.springboot.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {
    private Employee employeeUnderTest;
    @BeforeEach
    void setUp() {
        employeeUnderTest = new Employee();
    }
    @Test
    void testEquals() {
        assertFalse(employeeUnderTest.equals("o"));
    }
    @Test
    void testCanEqual() {
        assertFalse(employeeUnderTest.canEqual("other"));
    }
    @Test
    void testHashCode() {
        assertNotEquals(0, employeeUnderTest.hashCode());
    }
    @Test
    void testToString() {
        assertNotEquals("result", employeeUnderTest.toString());
    }
}
