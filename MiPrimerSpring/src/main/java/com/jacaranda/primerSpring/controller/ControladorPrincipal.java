package com.jacaranda.primerSpring.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jacaranda.primerSpring.model.Calculadora;
import com.jacaranda.primerSpring.model.CalculadoraException;

@Controller
public class ControladorPrincipal {

	 //por si me hacen una petición por get 
	@GetMapping({"/","index.html"}) // -/- a qué va responder 
	public String principal() {
		return "index";//el nombre sin extensión de una plantilla 
	}
	
	@GetMapping("/bienvenido")
	public String welcome(Model model, @RequestParam(name= "nombre", required=false, defaultValue ="John") String nombreSaludo, @RequestParam(required=false, defaultValue ="Nieve") String apellido) {
		model.addAttribute("nombre", nombreSaludo);
		model.addAttribute("apellido", apellido);
		return "index";
	}
	
	@GetMapping("/bienvenido2")
	public String welcome(Model model, @RequestParam(name= "nombre") Optional<String> nombreSaludo, @RequestParam(required=false, defaultValue ="Nieve") String apellido) {
		model.addAttribute("nombre", nombreSaludo.orElse("John"));
		model.addAttribute("apellido", apellido);
		return "index";
	}
	
	@GetMapping("/calcular")
	public String calcular(Model model) {
		Calculadora calculadora = new Calculadora();
		
		model.addAttribute("calculadora", calculadora);
		return ("form1");
	}
	
	@PostMapping("/resultado")
	public String operationSubmit(Model model, @ModelAttribute("calculadora") Calculadora calculadora) {
		
		try {
			
			model.addAttribute("resultado", calculadora.getResult());
			
		} catch (CalculadoraException e) {
			model.addAttribute("error", e.getMessage());
		}
		
		return "result";
	}
	
	
	
}
