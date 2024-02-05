package com.dcb.dcb.exception;

import com.dcb.dcb.model.ErrorMessageDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessageDTO employeeNotFoundException(EmployeeNotFoundException employeeNotFoundException) {
        return new ErrorMessageDTO(HttpStatus.NOT_FOUND, employeeNotFoundException.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessageDTO genericExceptionHandler(Exception exception) {
        return new ErrorMessageDTO(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
    }

}
