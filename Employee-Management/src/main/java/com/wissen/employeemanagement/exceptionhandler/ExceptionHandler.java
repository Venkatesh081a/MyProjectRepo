package com.wissen.employeemanagement.exceptionhandler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.wissen.employeemanagement.exception.EmployeeManagementAppException;
import com.wissen.employeemanagement.util.ExceptionHandling;

@RestControllerAdvice(annotations = RestController.class)
public class ExceptionHandler {

	@org.springframework.web.bind.annotation.ExceptionHandler(EmployeeManagementAppException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ExceptionHandling exceptionGetter(final EmployeeManagementAppException exception,
			final HttpServletRequest request) {
		ExceptionHandling exceptionResult = new ExceptionHandling();
		exceptionResult.setMessage(exception.getMessage());
		exceptionResult.setUrl(request.getRequestURI());
		return exceptionResult;
	}
}
