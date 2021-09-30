package rest.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rest.controller.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	private List<Student> students;
	
	@PostConstruct
	public void loadData() {
		students=new ArrayList<Student>();
		
		students.add(new Student("Ankit","Sodha"));
		students.add(new Student("Devang","Sodha"));
		students.add(new Student("Mayuri","Sodha"));
		
	}
	
	// define end points for "/students"
	
	@GetMapping("/students")
	public List<Student> getStudents(){	
		return students;
	} 
	
	// define end points for "/students/{studentId}" - return student at index 
	
	@GetMapping("/students/{theStudentId}")
	public Student getStudent(@PathVariable int theStudentId) {
		return students.get(theStudentId);
	}
	
	/*
	
	// handle exception student not found 
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {
		
		StudentErrorResponse error = new StudentErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	 }

	// more generic exception handling which handle String request also
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception exc) {
		
		StudentErrorResponse error = new StudentErrorResponse();
		
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	*/
}
