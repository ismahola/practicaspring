package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.implement.ImplementacionServicio;

@Controller
public class RegistroController {

	final String html = "registro";
	
	@Autowired
	@Qualifier("servicios")
	private ImplementacionServicio servicio;
	
	@GetMapping("/registro")
	public ModelAndView registro() {
		
		ModelAndView mav = new ModelAndView(html);
		
		mav.addObject("registro", servicio.listaOperaciones());
		
		return mav;
		
	}
	
}
