package com.wissen.employeemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wissen.employeemanagement.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByName(String name);

}
