package spring.orm.crud.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {

	@RequestMapping("/")
	public String index() {
		//return "index";
		return "redirect:/customer/all-customer";
	}
	
	@RequestMapping("simple-form")
	public String simpleForm() {
		return "simple-form";
	}
	
	@RequestMapping("process-form")
	public String processForm(HttpServletRequest request, Model model) {
		String studentName=request.getParameter("studentName");
		
		String theName=studentName.toUpperCase();
		
		model.addAttribute("theName", theName);
		
		return "process-form";
	}
}
