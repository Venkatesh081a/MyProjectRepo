package com.wissen.employeemanagement.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wissen.employeemanagement.entity.Employee;
import com.wissen.employeemanagement.exception.service.EmployeeManagementServiceException;
import com.wissen.employeemanagement.exception.service.custom.EmployeeNotFoundException;
import com.wissen.employeemanagement.repository.EmployeeRepository;
import com.wissen.employeemanagement.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public String insertEmployee(Employee employee) throws EmployeeManagementServiceException {
		employeeRepository.save(employee);
		return "Details Saved Successfully";

	}

	@Override
	public Employee getEmployeeById(int id) throws EmployeeManagementServiceException {
		Optional<Employee> emp = employeeRepository.findById(id);
		if (emp.isPresent()) {
			return emp.get();
		} else {
			throw new EmployeeNotFoundException("No Employee Found for the given data");
		}
	}

	@Override
	public Page<Employee> getAllEmployees(int pageNo, int pageSize) throws EmployeeManagementServiceException {
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		return employeeRepository.findAll(pageable);
	}

	@Override
	public Employee getEmployeeByFirstName(String firstName) throws EmployeeManagementServiceException {
		Employee employee = employeeRepository.findByFirstName(firstName);
		if (employee != null) {
			return employee;
		}
		throw new EmployeeNotFoundException("No Employee found for the given data");
	}

	@Override
	public Employee getEmployeeByLastName(String lastName) throws EmployeeManagementServiceException {
		Optional<Employee> employee = employeeRepository.findByLastName(lastName);
		if (employee.isPresent()) {
			return employee.get();
		}
		throw new EmployeeNotFoundException("No Employee found for the given data");
	}

	@Override
	public String updateEmployee(Employee employee, int id) throws EmployeeManagementServiceException {

		Optional<Employee> emp = employeeRepository.findById(id);
		if (emp.isPresent()) {
			Employee existingEmployee = emp.get();
			if (!StringUtils.isBlank(employee.getFirstName())) {
				existingEmployee.setFirstName(employee.getFirstName());
			}
			if (!StringUtils.isBlank(employee.getLastName())) {
				existingEmployee.setLastName(employee.getLastName());
			}
			if (!StringUtils.isBlank(employee.getEmail())) {
				existingEmployee.setEmail(employee.getEmail());
			}
			if (!StringUtils.isBlank(employee.getDesignation())) {
				existingEmployee.setDesignation(employee.getDesignation());
			}
			if (employee.getSalary() > 0) {
				existingEmployee.setSalary(employee.getSalary());
			}
			employeeRepository.save(existingEmployee);
			return "Details Updated Successfully";
		} else {
			throw new EmployeeNotFoundException("No Employee Found for the given data");
		}
	}

	@Override
	public String deleteEmployee(int id) throws EmployeeManagementServiceException {
		Optional<Employee> emp = employeeRepository.findById(id);
		if (emp.isPresent()) {
			employeeRepository.deleteById(id);
			return "Deleted Successfully";
		}
		throw new EmployeeNotFoundException("No Employee Found for the given data");
	}

	@Override
	public List<Employee> getEmployeeBySalaryRange(double minSal, double maxSal)
			throws EmployeeManagementServiceException {
		List<Employee> employees = employeeRepository.findBySalaryBetween(minSal, maxSal);
		if (null != employees && !employees.isEmpty()) {
			return employees;
		}
		throw new EmployeeNotFoundException("No Employees Found for the given data");
	}

	@Override
	public List<Employee> getEmployeesByFirstNameContaining(String firstName)
			throws EmployeeManagementServiceException {
		List<Employee> employees = employeeRepository.findByFirstNameContainingOrderByFirstNameAsc(firstName);
		if (null != employees && !employees.isEmpty()) {
			return employees;
		}
		throw new EmployeeNotFoundException("No Employees Found for the given data");
	}

	@Override
	public List<Employee> getEmployeesByDesignation(String designation) throws EmployeeManagementServiceException {
		List<Employee> employees = employeeRepository.getEmployeesBasedOnDesignation(designation);
		if (null != employees && !employees.isEmpty()) {
			return employees;
		}
		throw new EmployeeNotFoundException("No Employees Found for the given data");
	}

}