package com.bursary.exception;

import com.bursary.common.exception.ErrorResponse;
import com.bursary.common.exception.GlobalExceptionHandler;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GlobalExceptionHandlerTest {

    private final ThreadLocal<GlobalExceptionHandler> exceptionHandler = new ThreadLocal<GlobalExceptionHandler>();

    @Test
    public void testHandleException() {
        ResponseEntity<ErrorResponse> responseEntity = exceptionHandler.get().handleException(new IllegalStateException("test"));
        assertEquals(500, responseEntity.getStatusCode());
        assertEquals("test", responseEntity.getBody().getMessage());
    }
}