package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Busqueda;
import com.example.demo.service.implement.ImplementacionServicio;

@Controller
public class BajaController {

	final String htmlBusqueda = "busquedabaja";
	final String htmlBaja = "baja";
	
	@Autowired
	@Qualifier("servicios")
	private ImplementacionServicio servicio;
		
	@GetMapping("/baja")
	public ModelAndView baja() {
		
		ModelAndView mav = new ModelAndView(htmlBusqueda);
		
		mav.addObject("camionero", new Busqueda());
		
		return mav;
		
	}
	
	@PostMapping("/baja")
	public String darbaja(Model model, @Validated Busqueda camionero) {
		
		if(servicio.bajaCamionero(camionero)) {
		
			model.addAttribute("camionero", camionero);
			
			return htmlBaja;
			
		}else {
			
			model.addAttribute("camionero", camionero);
			model.addAttribute("error", "este camionero no existe intentalo otra vez");
			
			return htmlBusqueda;
			
		}
		
	}
	
}
