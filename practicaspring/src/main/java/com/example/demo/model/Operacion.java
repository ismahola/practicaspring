package com.example.demo.model;

public class Operacion {

	private String fechaYHora;
	private String operacion;
	private String descripcion;
	
	public Operacion() {
		
	}

	public Operacion(String fechaYHora, String operacion, String descripcion) {
		
		this.fechaYHora = fechaYHora;
		this.operacion = operacion;
		this.descripcion = descripcion;
		
	}

	public String getFechaYHora() {
		return fechaYHora;
	}

	public void setFechaYHora(String fechaYHora) {
		this.fechaYHora = fechaYHora;
	}

	public String getOperacion() {
		return operacion;
	}

	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@Override
	public String toString() {
		
		StringBuilder salida = new StringBuilder();
		
		salida.append(fechaYHora).append("#");
		salida.append(operacion).append("#");
		salida.append(descripcion).append("#");
		
		return salida.toString();
		
	}
	
}
