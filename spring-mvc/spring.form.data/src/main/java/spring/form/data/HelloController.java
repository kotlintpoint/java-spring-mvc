package spring.form.data;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
	
	@RequestMapping(path = {"/","index"})
	public String index() {
		return "index";
	}
	@RequestMapping("user-form-one")
	public String userFormOne() {
		return "user-form-one";
	}
	@RequestMapping("process-form-version-one")
	public String processFormVersionOne() {
		return "form-one-process";
	}
	
	@RequestMapping("process-form-version-two")
	public String processFormVersionTwo(HttpServletRequest request, Model model) {
		String studentName=request.getParameter("studentName");
		studentName=studentName.toUpperCase();
		String message="Hi! "+studentName;
		model.addAttribute("message", message);		
		return "form-one-process";
	}
	
	@RequestMapping("process-form-version-three")
	public String processFormVersionThree(
			@RequestParam("studentName")String studentName, 
			Model model) {
		
		studentName=studentName.toUpperCase();
		String message="Hello Friend ! "+studentName;
		model.addAttribute("message", message);		
		return "form-one-process";
	}
	
}
