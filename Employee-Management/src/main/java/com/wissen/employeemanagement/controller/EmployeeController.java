package com.wissen.employeemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wissen.employeemanagement.entity.Employee;
import com.wissen.employeemanagement.exception.EmployeeManagementAppException;
import com.wissen.employeemanagement.service.EmployeeService;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	/**
	 * This Method is used to create a new employee in DB
	 * 
	 * @param employee
	 * @return
	 * @throws EmployeeManagementAppException
	 */
	@PostMapping("/add")
	public ResponseEntity<String> addEmployee(@RequestBody Employee employee) throws EmployeeManagementAppException {
		String creationStatus = employeeService.insertEmployee(employee);
		return ResponseEntity.status(HttpStatus.OK).body(creationStatus);
	}

	/**
	 * This Method is used to retrieve the Employee Details based on the given Id
	 * 
	 * @param id
	 * @return
	 * @throws EmployeeManagementAppException
	 */
	@GetMapping("/getById/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) throws EmployeeManagementAppException {
		Employee employeeDetails = employeeService.getEmployeeById(id);
		return ResponseEntity.status(HttpStatus.OK).body(employeeDetails);
	}

	/**
	 * This Method is used to List all the available Employees from DB
	 * 
	 * @param pageNo
	 * @return
	 * @throws EmployeeManagementAppException
	 */
	@GetMapping("/getAllEmployees/page/{pageNo}")
	public ResponseEntity<List<Employee>> getAllEmployees(@PathVariable int pageNo)
			throws EmployeeManagementAppException {
		int pageSize = 2;
		Page<Employee> page = employeeService.getAllEmployees(pageNo, pageSize);
		List<Employee> employeesList = page.getContent();
		return ResponseEntity.status(HttpStatus.OK).body(employeesList);
	}

	/**
	 * This Method is used to retrieve the Employee based on the given first_name
	 * 
	 * @param firstName
	 * @return
	 * @throws EmployeeManagementAppException
	 */
	@GetMapping("/getByFirstName/{firstName}")
	public ResponseEntity<Employee> getEmployeeByFirstName(@PathVariable String firstName)
			throws EmployeeManagementAppException {
		Employee employeeDetails = employeeService.getEmployeeByFirstName(firstName);
		return ResponseEntity.status(HttpStatus.OK).body(employeeDetails);
	}

	/**
	 * This Method is used to retrieve the Employee based on the given last_name
	 * 
	 * @param lastName
	 * @return
	 * @throws EmployeeManagementAppException
	 */
	@GetMapping("/getByLastName/{lastName}")
	public ResponseEntity<Employee> getEmployeeByLastName(@PathVariable String lastName)
			throws EmployeeManagementAppException {
		Employee employeeDetails = employeeService.getEmployeeByLastName(lastName);
		return ResponseEntity.status(HttpStatus.OK).body(employeeDetails);
	}

	/**
	 * This Method is used to Update the Employee details for the given Id
	 * 
	 * @param employee
	 * @param id
	 * @return
	 * @throws EmployeeManagementAppException
	 */
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateEmployee(@RequestBody Employee employee, @PathVariable int id)
			throws EmployeeManagementAppException {
		String updationStatus = employeeService.updateEmployee(employee, id);
		return ResponseEntity.status(HttpStatus.OK).body(updationStatus);
	}

	/**
	 * This method is used to delete the employee based on the given Id
	 * 
	 * @param id
	 * @return
	 * @throws EmployeeManagementAppException
	 */
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable int id) throws EmployeeManagementAppException {
		String deletionStatus = employeeService.deleteEmployee(id);
		return ResponseEntity.status(HttpStatus.OK).body(deletionStatus);
	}

	/**
	 * This Method is used to get all the Employees with in the given salary range
	 * 
	 * @param minSal
	 * @param maxSal
	 * @return
	 * @throws EmployeeManagementAppException
	 */
	@GetMapping("/between/{minSal}/{maxSal}")
	public ResponseEntity<List<Employee>> getEmployeeBySalaryRange(@PathVariable double minSal,
			@PathVariable double maxSal) throws EmployeeManagementAppException {
		List<Employee> employees = employeeService.getEmployeeBySalaryRange(minSal, maxSal);
		return ResponseEntity.status(HttpStatus.OK).body(employees);
	}

	/**
	 * This Method is used List all the Employees whose firstName is like the given
	 * input
	 * 
	 * @param firstName
	 * @return
	 * @throws EmployeeManagementAppException
	 */
	@GetMapping("/get/firstNameContaining/{firstName}")
	public ResponseEntity<List<Employee>> getEmployeesByFirstNameContaining(@PathVariable String firstName)
			throws EmployeeManagementAppException {
		List<Employee> employees = employeeService.getEmployeesByFirstNameContaining(firstName);
		return ResponseEntity.status(HttpStatus.OK).body(employees);
	}

	/**
	 * This Method is used List all the Employees based on given designation
	 * 
	 * @param designation
	 * @return
	 * @throws EmployeeManagementAppException
	 */
	@GetMapping("/getByDesignation/{designation}")
	public ResponseEntity<List<Employee>> getEmployeesByDesignation(@PathVariable String designation)
			throws EmployeeManagementAppException {
		List<Employee> employees = employeeService.getEmployeesByDesignation(designation);
		return ResponseEntity.status(HttpStatus.OK).body(employees);
	}
}
