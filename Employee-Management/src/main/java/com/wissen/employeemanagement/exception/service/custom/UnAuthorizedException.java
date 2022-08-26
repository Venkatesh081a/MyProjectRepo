package com.wissen.employeemanagement.exception.service.custom;

import com.wissen.employeemanagement.exception.service.EmployeeManagementServiceException;

public class UnAuthorizedException extends EmployeeManagementServiceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UnAuthorizedException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UnAuthorizedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public UnAuthorizedException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public UnAuthorizedException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public UnAuthorizedException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
