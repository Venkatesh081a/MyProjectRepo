package com.wissen.employeemanagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wissen.employeemanagement.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	public Employee findByFirstName(String firstName);

	public Optional<Employee> findByLastName(String lastName);

	public List<Employee> findBySalaryBetween(double minSal, double maxSal);

	public List<Employee> findByFirstNameContainingOrderByFirstNameAsc(String firstName);

	@Query(value = "SELECT * FROM Employee e WHERE e.designation = :designation", nativeQuery = true)
	public List<Employee> getEmployeesBasedOnDesignation(@Param("designation") String designation);
}
