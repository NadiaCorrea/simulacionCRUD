package com.jacaranda.primerSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jacaranda.primerSpring.Service.StudentService;
import com.jacaranda.primerSpring.model.Student;

@Controller
public class StudentController {
	
	@Autowired
	StudentService repositorio;
	
	
	@GetMapping("/listStudent")
	public String listStudent(Model model) {
		
		model.addAttribute("lista", repositorio.getStudents());
		
		//lo que devuelve es el cod html correspondiente a renderizar la plantilla
		return "listStudents";
	}
	
	@GetMapping("/addStudent")
	public String addStudent(Model model) {
		
		Student student = new Student();
		
		model.addAttribute("estudiante", student);
		
		//lo que devuelve es el cod html correspondiente a renderizar la plantilla
		return "addStudentForm";
	}
	
	
	@PostMapping("/addStudent/submit")
	public String addSubmitStudent(@ModelAttribute("estudiante") Student estudiante) {
		
		repositorio.addStudent(estudiante);
		
		//para redireccionar
		return "redirect:/listStudent";
	}
	
	
	@GetMapping("/deleteStudent")
	public String deleteStudent(Model model, 
			@RequestParam(name ="name", required = false, defaultValue = "") String name,
			@RequestParam(name ="surname", required = false, defaultValue = "") String surname) {
		
		Student estudiante = repositorio.getStudent(name, surname);
		
		if(estudiante != null) {
			model.addAttribute("estudiante", estudiante);
		}
		
		return "deleteStudent";
	}
	
	@PostMapping("/deleteStudent/submit")
	public String deleteSubmitStudent(@ModelAttribute("estudiante") Student estudiante) {
		
		repositorio.removeStudent(estudiante);
		
		//para redireccionar
		return "redirect:/listStudent";
	}
	
	@GetMapping("/updateStudent")
	public String updateStudent(Model model, 
			@RequestParam(name ="name", required = false, defaultValue = "") String name,
			@RequestParam(name ="surname", required = false, defaultValue = "") String surname) {
		
		Student estudiante = repositorio.getStudent(name, surname);
		
		if(estudiante != null) {
			model.addAttribute("estudiante", estudiante);
		}
		
		return "updateStudent";
	}
	
	
	@PostMapping("/updateStudent/submit")
	public String updateStudent(@ModelAttribute("estudiante") Student estudiante) {
		
		repositorio.updateStudent(estudiante);
		
		return "redirect:/listStudent";
	}
	
//	/updateStudent/submit
	
	
}
