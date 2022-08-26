package com.wissen.employeemanagement.exception.service.custom;

import com.wissen.employeemanagement.exception.service.EmployeeManagementServiceException;

public class InvalidDetailsException extends EmployeeManagementServiceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidDetailsException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InvalidDetailsException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public InvalidDetailsException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidDetailsException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public InvalidDetailsException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
