package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.component.Componentes;
import com.example.demo.model.Camionero;
import com.example.demo.model.Transporte;
import com.example.demo.service.implement.ImplementacionServicio;

@Controller
public class AltaController {

	final String html = "alta";
	final String htmlok = "alta_ok";
	
	@Autowired
	@Qualifier("servicios")
	private ImplementacionServicio servicio;
	
	@Autowired
	@Qualifier("Componentes")
	private Componentes componente;

	@GetMapping("/alta")
	public ModelAndView alta() {
		
		ModelAndView mav = new ModelAndView(html);
		
		componente.info("usuario entro en el alta");
		
		mav.addObject("camionero", new Camionero());
		
		mav.addObject("transporte", Transporte.values());
		
		return mav;
		
	}
	
	@PostMapping("/alta")
	public String registrado(Model model, @Validated Camionero camionero, BindingResult resultado) {
		
		if(resultado.hasErrors()) {
			
			servicio.guardarOperacion("Alta", "se intento dar de alta al camionero "+camionero.descripcion()+" pero no se a podido por un error");
			
			model.addAttribute("transporte", Transporte.values());
			
			return html;
			
		}else {
			
			servicio.altaCamionero(camionero);
			servicio.guardarOperacion("Alta", "se a dado de alta al camionero "+camionero.descripcion());
			
			model.addAttribute("camionero", camionero);
			
			return htmlok;
			
		}
		
	}
	
}
