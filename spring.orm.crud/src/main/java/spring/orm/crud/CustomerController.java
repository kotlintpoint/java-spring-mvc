package spring.orm.crud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String processForm(@ModelAttribute("customer") Customer theCustomer,
			BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "customer-form";
		}
		
		dao.saveCustomer(theCustomer);
		
		return "process-customer";
	}
	
	@RequestMapping("all-customer")
	public String allCustomer(Model model) {
		List<Customer> customers = dao.allCustomer();
		System.out.println(customers);
		model.addAttribute("customers", customers);
		return "customer-list";
	}
}
