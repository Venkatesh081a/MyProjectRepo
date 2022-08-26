package com.wissen.employeemanagement.exception.service.custom;

import com.wissen.employeemanagement.exception.service.EmployeeManagementServiceException;

public class PasswordMisMatchException extends EmployeeManagementServiceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PasswordMisMatchException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PasswordMisMatchException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public PasswordMisMatchException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public PasswordMisMatchException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public PasswordMisMatchException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
