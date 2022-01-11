package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Camionero;
import com.example.demo.service.implement.ImplementacionServicio;

@Controller
public class ListaController {

	final String html = "lista";
	
	@Autowired
	@Qualifier("servicios")
	private ImplementacionServicio servicio;
	
	@GetMapping("/lista")
	public ModelAndView listado() {
		
		ModelAndView mav = new ModelAndView(html);
		List<Camionero> lista = servicio.listaCamionero();
		String texto = "esta es la lista mostrada: ";
		
		mav.addObject("camioneros", lista);
		
		for(Camionero i : lista) {
			
			texto = texto + "Nombre: " +i.getNombre() + " Apellidos: " + i.getApellidos() +", ";
			
		}
		
		servicio.guardarOperacion("Lista", texto);
		
		return mav;
		
	}
	
}
