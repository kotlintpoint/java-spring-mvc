package com.kotlintpoint.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.kotlintpoint.springboot.cruddemo.entity.Employee;

//change actual end point /employees to /members
//@RepositoryRestResource(path="members")   
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	// that's it ... no need to write any code !!!
	
}
