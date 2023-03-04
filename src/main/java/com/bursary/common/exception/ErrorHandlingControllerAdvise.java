package com.bursary.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class ErrorHandlingControllerAdvise {

    @ExceptionHandler
    public ProblemDetail handlingIllegalStateException(IllegalStateException exception) {
        var problemDetail = ProblemDetail.forStatus(HttpStatusCode.valueOf(404));
        log.error(problemDetail.getDetail());
        problemDetail.setDetail(exception.getMessage());
        return problemDetail;
    }
}
