package com.wissen.employeemanagement.service.serviceImpl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.wissen.employeemanagement.entity.User;
import com.wissen.employeemanagement.exception.service.EmployeeManagementServiceException;
import com.wissen.employeemanagement.exception.service.custom.PasswordMisMatchException;
import com.wissen.employeemanagement.repository.UserRepository;
import com.wissen.employeemanagement.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public String register(User user) throws EmployeeManagementServiceException {
		if (StringUtils.equals(user.getPassword(), user.getConfirmPassword())) {
			User u = new User();
			u.setName(user.getName());
			u.setPassword(passwordEncoder.encode(user.getPassword()));
			u.setConfirmPassword(passwordEncoder.encode(user.getPassword()));
			u.setEmail(user.getEmail());
			u.setIsLoggedIn("No");
			userRepository.save(u);
			return "Registered Successfully !";
		}
		throw new PasswordMisMatchException("Passwords didn't match , please verify");
	}

	@Override
	public void updateLogInStatus(String name) {
		User existingUser = userRepository.findByName(name);
		if (existingUser != null) {
			existingUser.setIsLoggedIn("Yes");
			userRepository.save(existingUser);
		}
	}

}
