package com.fre18.quannt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fre18.qnt.daoimpl.StudentDaoImpl;
import com.fre18.qnt.entity.Student;

@Controller
public class StudentController {

	@Autowired
	StudentDaoImpl studentDaoImpl;
	 
	@RequestMapping(value="/student", method=RequestMethod.GET)
	@ResponseBody
	public Student getStudent() {
		// TODO Auto-generated method stub
		return studentDaoImpl.findById(2);
	}
	@RequestMapping(value="/students", method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public List<Student> getStudents() {
		// TODO Auto-generated method stub
		List<Student> list = studentDaoImpl.findAll();
		return  list;
	}
	
	@RequestMapping(value="/student", method=RequestMethod.POST,produces={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public Student addStudent(@RequestBody Student student) {
		// TODO Auto-generated method stub
		return studentDaoImpl.addStudent(student);
	}
	
	@RequestMapping(value="/student", method=RequestMethod.PUT,produces={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public void updateStudent(@RequestBody Student student) {
		// TODO Auto-generated method stub
		studentDaoImpl.updateStudent(student);
	}
	
	@RequestMapping(value="/student", method=RequestMethod.DELETE,produces={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public void deleteStudent(@PathVariable("stuNo") int no){
		System.out.println("Delete" + no);
		studentDaoImpl.deleteStudent(no); 
	}
}
