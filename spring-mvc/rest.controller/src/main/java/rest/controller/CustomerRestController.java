package rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rest.controller.dao.CustomerDaoSupport;
import rest.controller.entity.Customer;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
	@Autowired
	private CustomerDaoSupport dao;
	
	public CustomerDaoSupport getDao() {
		return dao;
	}

	public void setDao(CustomerDaoSupport dao) {
		this.dao = dao;
	}
	
	// add mapping for GET /customers - get all customers 
	
	@GetMapping("/customers")
	public List<Customer> getCustomers(){
		return dao.allCustomer();
	}
	
	// add mapping for GET /customers - fetch customer by Id
	
	@GetMapping("/customers/{customerId}")
	public Customer getCustomersById(@PathVariable int customerId){
		return dao.getCustomer(customerId);
	}
	
	// add mapping for POST /customers - insert new customer
	
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer theCustomer){
		
		// to force a save of new customer instead of update operation
		theCustomer.setId(0);
		
		dao.saveCustomer(theCustomer);
		 
		return theCustomer;
	}
	
	
	// add mapping for PUT /customers - update existing customer
	
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer theCustomer) {
		dao.saveCustomer(theCustomer);
		return theCustomer;
	}
	
	
	// add mapping for PUT /customers - update existing customer
	
	@DeleteMapping("/customers/{customerId}")
	public Customer deleteCustomer(@PathVariable int customerId) {
		Customer theCustomer=dao.deleteCustomer(customerId);
		return theCustomer;
	}
}
