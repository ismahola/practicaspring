package com.example.demo.service.implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Busqueda;
import com.example.demo.model.Camionero;
import com.example.demo.model.Operacion;
import com.example.demo.service.DatosService;

@Service("servicios")
public class ImplementacionServicio implements DatosService{
	
	File bbddCamioneros = new File("src\\main\\resources\\templates\\camioneros.txt");
	File bbddOperaciones = new File("src\\main\\resources\\templates\\operaciones.txt");

	@Override
	public List<Camionero> listaCamionero() {
		
		List<Camionero> camionero = new ArrayList<Camionero>();
		String contenido;
		
		try {
			
			FileReader fr = new FileReader(bbddCamioneros);
			BufferedReader br = new BufferedReader(fr);
			
			while((contenido = br.readLine()) != null) {
				
				String[] camioneros = contenido.split("#");
				Camionero leer = new Camionero(Integer.parseInt(camioneros[0]), camioneros[1], camioneros[2], camioneros[3],camioneros[4], camioneros[5], camioneros[6], camioneros[7], camioneros[8], camioneros[9]);
				
				camionero.add(leer);
				
			}
			
			fr.close();
			br.close();
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
		return camionero;
		
	}

	@Override
	public void altaCamionero(Camionero alta) {
		
		int ultimoId;
		int nuevoId;
		List<Camionero> lista = listaCamionero();
		
		if(listaCamionero().size() != 0) {
			
			ultimoId = listaCamionero().get(listaCamionero().size() - 1).getId();
			nuevoId = ultimoId + 1;
			
		}else {
			
			nuevoId = 1;
			
		}
		
		alta.setId(nuevoId);
		
		lista.add(alta);
		
		try {
			
			FileWriter fw = new FileWriter(bbddCamioneros);
			BufferedWriter bw = new BufferedWriter(fw);
			
			for(int i = 0; i < lista.size(); i++) {
				
				bw.write(lista.get(i).toString() + "\n");
				
			}
			
			bw.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
		
	}

	@Override
	public boolean bajaCamionero(Busqueda baja) {
		
		List<Camionero> lista = listaCamionero();
		String texto = "se a intentado dar de baja al camionero "+baja.toString()+" pero no se le a encontrado";
		boolean borrado = false;
		
		for(int i = 0; i < lista.size(); i++) {
			
			if(lista.get(i).getNombre().equals(baja.getNombre()) && lista.get(i).getApellidos().equals(baja.getApellidos())) {
				
				texto = "se a dado de baja al camionero "+lista.get(i).descripcion();
				
				lista.remove(i);
				
				borrado = true;
				
			}
			
		}
		
		guardarOperacion("Baja", texto);
		
		try {
			
			FileWriter fw = new FileWriter(bbddCamioneros);
			BufferedWriter bw = new BufferedWriter(fw);
			
			for(int i = 0; i < lista.size(); i++) {
				
				bw.write(lista.get(i).toString() + "\n");
				
			}
			
			bw.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
		return borrado;
		
	}

	@Override
	public boolean busquedaCamionero(Busqueda bus) {
		
		List<Camionero> lista = listaCamionero();
		boolean salida = false;
		
		for(int i = 0; i < lista.size(); i++) {
			
			if(lista.get(i).getNombre().equals(bus.getNombre()) && lista.get(i).getApellidos().equals(bus.getApellidos())) {
				
				salida = true;
				
			}
			
		}
		
		return salida;
		
	}

	@Override
	public Camionero sacarCamionero(Busqueda bus) {
		
		List<Camionero> lista = listaCamionero();
		Camionero salida = new Camionero();
		
		for(int i = 0; i < lista.size(); i++) {
			
			if(lista.get(i).getNombre().equals(bus.getNombre()) && lista.get(i).getApellidos().equals(bus.getApellidos())) {
				
				salida = lista.get(i);
				
			}
			
		}
		
		return salida;
		
	}

	@Override
	public void modificarCamionero(Camionero modificado, Busqueda camionero) {
		
		List<Camionero> lista = listaCamionero();
		String texto = "se ha modificado al camionero "+modificado.getNombre()+" "+modificado.getApellidos()+" y se le a modificado";
		//String texto = modificado.toString() + camionero.toString();
		
		for(int i = 0; i < lista.size(); i++) {
			
			if(lista.get(i).getNombre().equals(camionero.getNombre()) && lista.get(i).getApellidos().equals(camionero.getApellidos())) {
				
				if(!lista.get(i).getNombre().equals(modificado.getNombre())) {
					
					texto = texto + "Nombre: " + lista.get(i).getNombre() + "/" + modificado.getNombre();
					
				}
				lista.get(i).setNombre(modificado.getNombre());
				if(!lista.get(i).getApellidos().equals(modificado.getApellidos())) {
					
					texto = texto + " Apellidos: " + lista.get(i).getApellidos() + "/" + modificado.getApellidos();
					
				}
				lista.get(i).setApellidos(modificado.getApellidos());
				if(!lista.get(i).getCorreo().equals(modificado.getCorreo())) {
					
					texto = texto + " Correo electronico: " + lista.get(i).getCorreo() + "/" + modificado.getCorreo();
					
				}
				lista.get(i).setCorreo(modificado.getCorreo());
				if(!lista.get(i).getTelefono().equals(modificado.getTelefono())) {
					
					texto = texto + " Telefono contracto: " + lista.get(i).getTelefono() + "/" + modificado.getTelefono();
					
				}
				lista.get(i).setTelefono(modificado.getTelefono());
				if(!lista.get(i).getFecha().equals(modificado.getFecha())) {
					
					texto = texto + " Fecha nacimiento: " + lista.get(i).getFecha() + "/" + modificado.getFecha();
					
				}
				lista.get(i).setFecha(modificado.getFecha());
				if(!lista.get(i).getGenero().equals(modificado.getGenero())) {
					
					texto = texto + " Genero: " + lista.get(i).getGenero() + "/" + modificado.getGenero();
					
				}
				lista.get(i).setGenero(modificado.getGenero());
				if(!lista.get(i).getTransporte().equals(modificado.getTransporte())) {
					
					texto = texto + " Transporte mercancias: " + lista.get(i).getTransporte() + "/" + modificado.getTransporte();
					
				}
				lista.get(i).setTransporte(modificado.getTransporte());
				if(!lista.get(i).getComentario().equals(modificado.getTransporte())) {
					
					texto = texto + " Comentarios: " + lista.get(i).getComentario() + "/" + modificado.getComentario();
					
				}
				lista.get(i).setComentario(modificado.getComentario());
				if(!lista.get(i).getContrato().equals(modificado.getContrato())) {
					
					texto = texto + " Contratado: " + lista.get(i).getContrato() + "/" + modificado.getContrato();
					
				}
				lista.get(i).setContrato(modificado.getContrato());
				
			}
			
		}
		
		guardarOperacion("Modificacion", texto);
		
		try {
			
			FileWriter fw = new FileWriter(bbddCamioneros);
			BufferedWriter bw = new BufferedWriter(fw);
			
			for(int i = 0; i < lista.size(); i++) {
				
				bw.write(lista.get(i).toString() + "\n");
				
			}
			
			bw.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
	}

	@Override
	public void guardarOperacion(String operacion, String descripcion) {
		
		List<Operacion> lista = listaOperaciones();
		String fecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
		Operacion ope = new Operacion(fecha, operacion, descripcion);
		
		lista.add(ope);
		
		try {
			
			FileWriter fw = new FileWriter(bbddOperaciones);
			BufferedWriter bw = new BufferedWriter(fw);
			
			for(int i = 0; i < lista.size(); i++) {
				
				bw.write(lista.get(i).toString() + "\n");
				
			}
			
			bw.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
	}

	@Override
	public List<Operacion> listaOperaciones() {
		
		List<Operacion> operacion = new ArrayList<Operacion>();
		String contenido;
		
		try {
			
			FileReader fr = new FileReader(bbddOperaciones);
			BufferedReader br = new BufferedReader(fr);
			
			while((contenido = br.readLine()) != null) {
				
				String[] operaciones = contenido.split("#");
				Operacion leer = new Operacion(operaciones[0], operaciones[1], operaciones[2]);
				
				operacion.add(leer);
				
			}
			
			fr.close();
			br.close();
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
		return operacion;
		
	}
	
}
