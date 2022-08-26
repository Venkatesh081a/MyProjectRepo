package com.wissen.employeemanagement.service;

import org.jasypt.util.text.AES256TextEncryptor;

import com.wissen.employeemanagement.entity.User;
import com.wissen.employeemanagement.exception.service.EmployeeManagementServiceException;

public interface UserService {

	String register(User user) throws EmployeeManagementServiceException;

	void updateLogInStatus(String name);

}
