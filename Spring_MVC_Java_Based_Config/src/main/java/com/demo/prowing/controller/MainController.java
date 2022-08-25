package com.demo.prowing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.prowing.model.Student;
import com.demo.prowing.service.StudentService;

@Controller
public class MainController {

	@Autowired
	StudentService studentService;
	
	@Autowired
	Student student;
	
	@RequestMapping(value = "/student", method = RequestMethod.POST)
	public ModelAndView addStudent(@RequestParam("name") String name, @RequestParam("address") String address) {
		
		student = new Student();
		student.setStudentName(name);
		student.setStudentAddress(address);

		Student std1 = studentService.addStudent(student);
		
		ModelAndView mv = new ModelAndView();
		
		String message = null;
		if(std1!=null) {
			
			message = "Student Object Saved Successfully...";
			mv.addObject("msg", message);
			
		}else {
			
			message = "Student Object Unable to Save...";
			mv.addObject("msg", message);
		}
		mv.setViewName("stdAdded");
		return mv;
	}
	
}
