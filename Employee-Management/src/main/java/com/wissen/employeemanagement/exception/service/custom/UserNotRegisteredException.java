package com.wissen.employeemanagement.exception.service.custom;

import com.wissen.employeemanagement.exception.service.EmployeeManagementServiceException;

public class UserNotRegisteredException extends EmployeeManagementServiceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserNotRegisteredException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserNotRegisteredException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public UserNotRegisteredException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public UserNotRegisteredException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public UserNotRegisteredException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
