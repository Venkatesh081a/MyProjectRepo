package com.wissen.employeemanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wissen.employeemanagement.dto.AuthRequest;
import com.wissen.employeemanagement.entity.User;
import com.wissen.employeemanagement.exception.EmployeeManagementAppException;
import com.wissen.employeemanagement.exception.service.custom.UnAuthorizedException;
import com.wissen.employeemanagement.service.UserService;
import com.wissen.employeemanagement.util.JwtUtil;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private AuthenticationManager authenticationManager;

	@GetMapping("/")
	public String welcome() {
		return "Welcome to Wissen Technology !!";
	}

	/**
	 * This method is used to register a new user to DB
	 * 
	 * @param user
	 * @return
	 * @throws EmployeeManagementAppException
	 */
	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody User user) throws EmployeeManagementAppException {
		String registrationStatus = userService.register(user);
		return ResponseEntity.status(HttpStatus.OK).body(registrationStatus);
	}

	/**
	 * This Method is used to validate the user details during Login process and if
	 * the details are authenticated successfully , then we will generate a JWT
	 * Token for accessing other end points
	 * 
	 * @param authRequest
	 * @return
	 * @throws EmployeeManagementAppException
	 */
	@PostMapping("/login")
	public String generateToken(@RequestBody AuthRequest authRequest) throws EmployeeManagementAppException {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getName(), authRequest.getPassword()));
		} catch (Exception e) {
			throw new UnAuthorizedException("invalid username/password");
		}
		userService.updateLogInStatus(authRequest.getName());
		return jwtUtil.generateToken(authRequest.getName());
	}
}
