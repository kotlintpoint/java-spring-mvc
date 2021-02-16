package spring.orm.crud.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import spring.orm.crud.dao.CustomerDaoSupport;
import spring.orm.crud.entity.Customer;

@Controller
@RequestMapping("customer")
public class CustomerController {

	@Autowired
	private CustomerDaoSupport dao;
	
	public CustomerDaoSupport getDao() {
		return dao;
	}

	public void setDao(CustomerDaoSupport dao) {
		this.dao = dao;
	}

	@RequestMapping("simple-form")
	public String simpleForm(Model model) {
		Customer theCustomer=new Customer();
		model.addAttribute("customer", theCustomer);
		return "customer-form";
	}
	
	@RequestMapping("process-form")
	public String processForm(@Valid @ModelAttribute("customer") Customer theCustomer,
			BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "customer-form";
		}
		
		dao.saveCustomer(theCustomer);
		
		//return "process-customer";
		return "redirect:/customer/all-customer";
	}
	
	@RequestMapping("all-customer")
	public String allCustomer(Model model) {
		List<Customer> customers = dao.allCustomer();
		System.out.println(customers);
		model.addAttribute("customers", customers);
		return "customer-list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId")int theId, 
			Model theModel) {
		Customer theCustomer=dao.getCustomer(theId);
		
		theModel.addAttribute("customer",theCustomer);
		
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId")int theId) {
		
		dao.deleteCustomer(theId);
		
		return "redirect:/customer/all-customer";
	}
}
