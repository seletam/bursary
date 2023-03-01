package com.bursary.exception;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

class GlobalExceptionHandlerTest {

    private final ThreadLocal<GlobalExceptionHandler> exceptionHandler = new ThreadLocal<GlobalExceptionHandler>();

    @Test
    public void testHandleException() {
        ResponseEntity<ErrorResponse> responseEntity = exceptionHandler.get().handleException(new IllegalStateException("test"));
        assertEquals(500, responseEntity.getStatusCode());
        assertEquals("test", responseEntity.getBody().getMessage());
    }
}