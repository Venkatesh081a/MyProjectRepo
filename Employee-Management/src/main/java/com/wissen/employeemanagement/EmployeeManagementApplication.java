package com.wissen.employeemanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeManagementApplication {

	/**
	 * When the application started initially , we will have User and Employee
	 * tables created in our DB. Every Endpoint present in UserController and
	 * EmployeeController needs authenticated except "/login" and "/register"
	 * 
	 * First we need to register user, for that we need to access "/register" end
	 * point
	 * 
	 * 1. UserController "/register" URI -> 2. UserService register method->
	 * 3.UserServiceImpl register method-> 4. UserRepository save method -> User
	 * saved to DB
	 * 
	 * After successful registration of User , we need to login by providing the
	 * user name and password which we have used during registration process
	 * 
	 * 1. UserController "/login" URI -> 2. AuthenticationManager authenticate
	 * method-> 3.UserService updateLogInStatus method-> 4. .UserService
	 * UpdateLogInStatus method -> 5. UserRepository findByName method -> 6.JwtUtil
	 * generateToken
	 * 
	 * After successful login the Server will generate a JWT Token and then Client
	 * has to send the same token in order to get access to other endpoints
	 * 
	 * For accessing other endpoints , first Client will send the JWT Token as
	 * "Authorization" Header , Then from the header we will fetch the token and
	 * validate user details
	 * 
	 * 1. JWT TOken in Authorization Header 2.JwtFilter doFilterInternal ,then Upon
	 * successful validation of JWT Token , one can get access to other end points
	 * 
	 * 
	 * Other Endpoints 
	 * --------------------------------------------- 
	 * 1.EmployeeController "/add" URI -> 2. EmployeeService insertEmployee method ->
	 * 3. EmployeeServiceImpl insertEmployee method -> 4.EmployeeRepository save
	 * method
	 * 
	 * 1. EmployeeController "/getById/{id}" URI -> 2. EmployeeService
	 * getEmployeeById method -> 3. EmployeeServiceImpl getEmployeeById method ->
	 * 4.EmployeeRepository findById method
	 * 
	 * 1. EmployeeController "/getAllEmployees/page/{pageNo}" URI -> 2.
	 * EmployeeService getAllEmployees method -> 3. EmployeeServiceImpl
	 * getAllEmployees method -> 4.EmployeeRepository findAll method
	 * 
	 * 1. EmployeeController "/getByFirstName/{firstName}" URI -> 2. EmployeeService
	 * getEmployeeByFirstName method -> 3. EmployeeServiceImpl
	 * getEmployeeByFirstName method -> 4.EmployeeRepository findByFirstName method
	 * 
	 * 1. EmployeeController "/getByLastName/{lastName}" URI -> 2. EmployeeService
	 * getEmployeeByLastName method -> 3. EmployeeServiceImpl getEmployeeByLastName
	 * method -> 4.EmployeeRepository findByLastName method
	 * 
	 * 1. EmployeeController "/update/{id}" URI -> 2.EmployeeService updateEmployee
	 * method -> 3. EmployeeServiceImpl updateEmployee method ->
	 * 4.EmployeeRepository findById method , save method
	 * 
	 * 1. EmployeeController "/delete/{id}" URI -> 2. EmployeeService deleteEmployee
	 * method -> 3. EmployeeServiceImpl deleteEmployee method ->
	 * 4.EmployeeRepository findById method , deleteById method
	 * 
	 * 1. EmployeeController "/between/{minSal}/{maxSal}" URI -> 2. EmployeeService
	 * getEmployeeBySalaryRange method -> 3. EmployeeServiceImpl
	 * getEmployeeBySalaryRange method -> 4.EmployeeRepository findBySalaryBetween
	 * method
	 * 
	 * 1. EmployeeController "/get/firstNameContaining/{firstName}" URI -> 2.
	 * EmployeeService getEmployeesByFirstNameContaining method -> 3.
	 * EmployeeServiceImpl getEmployeesByFirstNameContaining method ->
	 * 4.EmployeeRepository findByFirstNameContainingOrderByFirstNameAsc method
	 * 
	 * 1. EmployeeController "/getByDesignation/{designation}" URI -> 2.
	 * EmployeeService getEmployeesByDesignation method -> 3. EmployeeServiceImpl
	 * getEmployeesByDesignation method -> 4.EmployeeRepository
	 * getEmployeesBasedOnDesignation method
	 * 
	 */
	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementApplication.class, args);
	}

}
