package com.kotlintpoint.springboot.cruddemo.dao;

import java.util.List;

import com.kotlintpoint.springboot.cruddemo.entity.Employee;

public interface EmployeeDAO {
	
	List<Employee> findAll();
	
	Employee findById(int theId);
	
	void save(Employee theEmployee);
	
	void deleteById(int theId);
	

}
