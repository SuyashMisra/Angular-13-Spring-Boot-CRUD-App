package com.demoapp.springboot.exception;

import org.junit.jupiter.api.BeforeEach;

class ResourceNotFoundExceptionTest {
    private ResourceNotFoundException resourceNotFoundExceptionUnderTest;
    @BeforeEach
    void setUp() {
        resourceNotFoundExceptionUnderTest = new ResourceNotFoundException("message");
    }
}
