package com.kotlintpoint.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kotlintpoint.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	// define field for entityManager
	private EntityManager entityManager;
	
	// set up constructor injection
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager=theEntityManager;
	}
	
	/*
	 * @Transaction
	 *  handles transaction management, 
	 *  so we don't need to manually start and commit transaction
	 */
	
	@Override		
	public List<Employee> findAll() {
		
		// get the current hibernate session
		Session currentSession=entityManager.unwrap(Session.class);
		
		// create a query
		Query<Employee> theQuery
					=currentSession.createQuery("from Employee",Employee.class);
		
		// execute query and get result list
		List<Employee> employees=theQuery.getResultList();
		
		// return the results
		return employees;
	}

	@Override
	public Employee findById(int theId) {
		
		// get the current hibernate session
		Session session=entityManager.unwrap(Session.class);
		
		// get the employee
		Employee employee=session.get(Employee.class, theId);
		
		// return the employee
		return employee;
	}

	@Override
	public void save(Employee theEmployee) {
		
		// get the current hibernate session
		Session session=entityManager.unwrap(Session.class);
		
		// save employee..... if id=0 then save/insert else update
		session.saveOrUpdate(theEmployee);
		
	}

	@Override
	public void deleteById(int theId) {
		
		//get the current hibernate session
		Session session=entityManager.unwrap(Session.class);
		
		Query theQuery = session.createQuery(
				"delete from Employee where id=:employeeId");
		theQuery.setParameter("employeeId", theId);
		
		theQuery.executeUpdate();
				
	}

}
