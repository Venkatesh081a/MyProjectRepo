package com.wissen.employeemanagement.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.wissen.employeemanagement.entity.Employee;
import com.wissen.employeemanagement.exception.service.EmployeeManagementServiceException;

public interface EmployeeService {

	String insertEmployee(Employee employee) throws EmployeeManagementServiceException;

	Employee getEmployeeById(int id) throws EmployeeManagementServiceException;

	Page<Employee> getAllEmployees(int pageNo, int pageSize) throws EmployeeManagementServiceException;

	Employee getEmployeeByFirstName(String firstName) throws EmployeeManagementServiceException;

	Employee getEmployeeByLastName(String lastName) throws EmployeeManagementServiceException;

	String updateEmployee(Employee employee, int id) throws EmployeeManagementServiceException;

	String deleteEmployee(int id) throws EmployeeManagementServiceException;

	List<Employee> getEmployeeBySalaryRange(double minSal, double maxSal) throws EmployeeManagementServiceException;

	List<Employee> getEmployeesByFirstNameContaining(String firstName) throws EmployeeManagementServiceException;

	List<Employee> getEmployeesByDesignation(String designation) throws EmployeeManagementServiceException;

}
