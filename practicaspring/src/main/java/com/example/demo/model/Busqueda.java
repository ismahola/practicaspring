package com.example.demo.model;

public class Busqueda {

	private String nombre;
	private String apellidos;
	
	public Busqueda() {
		
	}

	public Busqueda(String nombre, String apellidos) {
		
		this.nombre = nombre;
		this.apellidos = apellidos;
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	@Override
	public String toString() {
		
		StringBuilder salida = new StringBuilder();
		
		salida.append("Nombre: ").append(nombre);
		salida.append("Apellidos: ").append(apellidos);
		
		return salida.toString();
		
	}
	
}
