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

import com.example.demo.model.Busqueda;
import com.example.demo.model.Camionero;
import com.example.demo.model.Transporte;
import com.example.demo.service.implement.ImplementacionServicio;

@Controller
public class ModificacionController {

	final String htmlBusqueda = "busquedamod";
	final String htmlModificacion = "modificacion";
	final String htmlModOk = "modificacion_ok";
	
	Busqueda bus = new Busqueda();
	
	@Autowired
	@Qualifier("servicios")
	private ImplementacionServicio servicio;
	
	@GetMapping("/modificacion")
	public ModelAndView modificacion() {
		
		ModelAndView mav = new ModelAndView(htmlBusqueda);
		
		mav.addObject("camionero", new Busqueda());
		
		return mav;
		
	}
	
	@PostMapping("/modificacion")
	public String modificar(Model model, @Validated Busqueda camionero) {
		
		if(servicio.busquedaCamionero(camionero)) {
			
			bus = camionero;
			
			model.addAttribute("camionero", camionero);
			model.addAttribute("modificacion", servicio.sacarCamionero(camionero));
			model.addAttribute("transporte", Transporte.values());
			
			return htmlModificacion;
			
		}else {
			
			servicio.guardarOperacion("Modificacion", "se ha intentado modificar al camionero Nombre: "+camionero.getNombre()+" Apellidos: "+camionero.getApellidos()+" pero no se a encontrado");
			
			model.addAttribute("camionero", camionero);
			model.addAttribute("error", "este camionero no existe intentalo otra vez");
			
			return htmlBusqueda;
			
		}
		
	}
	
	@PostMapping("/modificado")
	public String modificado(Model model, @Validated Camionero modificado, BindingResult resultado) {
		
		if(resultado.hasErrors()) {
			
			servicio.guardarOperacion("Modidicacion", "se ha intentado modificar al camionero Nombre: "+modificado.getNombre()+" Apellidos: "+modificado.getApellidos()+" pero los parametros no cumplian las especificaciones necesarias");
			
			model.addAttribute("modificacion", modificado);
			model.addAttribute("transporte", Transporte.values());
			
			return htmlModificacion;
			
		}else {
			
			
			servicio.modificarCamionero(modificado, bus);
			
			model.addAttribute("camionero", modificado);
			
			return htmlModOk;
			
		}
		
	}
	
}
