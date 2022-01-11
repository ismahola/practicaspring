package com.example.demo.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Camionero {

	private int id;
	@NotBlank(message = "El nombre no puede estar en blanco")
	@Size(max = 20, message = "El nombre no puede tener mas de 20 caracteres")
	private String nombre;
	@NotBlank(message = "Los apellidos no puede estar en blanco")
	@Size(max = 40, message = "Los apellidos no puede tener mas de 40 caracteres")
	private String apellidos;
	@NotNull(message = "El correo electronico no puede ser nulo")
	private String correo;
	@NotNull(message = "El teléfono no puede ser nulo")
	private String telefono;
	@NotNull(message = "La fecha de nacimiento  no puede ser nula")
	private String fecha;
	@NotNull(message = "El género no puede ser nulo")
	private String genero;
	@NotNull(message = "El transporte mercancías no puede ser nulo")
	private String transporte;
	@Size(max = 250, message = "El comentario no puede superar los 250 caracteres")
	private String comentario;
	@NotNull(message = "El contrato actualmente no puede ser nulo")
	private String contrato;
	
	public Camionero() {
		
	}
	
	public Camionero(int id, String nombre, String apellidos, String correo, String telefono, String fecha, String genero,String transporte, String comentario, String contrato) {
		
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.correo = correo;
		this.telefono = telefono;
		this.fecha = fecha;
		this.genero = genero;
		this.transporte = transporte;
		this.comentario = comentario;
		this.contrato = contrato;
		
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getTransporte() {
		return transporte;
	}

	public void setTransporte(String transporte) {
		this.transporte = transporte;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getContrato() {
		return contrato;
	}

	public void setContrato(String contrato) {
		this.contrato = contrato;
	}
	
	public String descripcion() {
		
		StringBuilder salida = new StringBuilder();
		
        salida.append("Nombre: ").append(nombre);
        salida.append(" Apellidos: ").append(apellidos);
        salida.append(" Correo electronico: ").append(correo);
        salida.append(" Numero de telefono: ").append(telefono);
        salida.append(" Fecha de nacimiento: ").append(fecha);
        salida.append(" Genero: ").append(genero);
        salida.append(" Transporte de mercancias: ").append(transporte);
        salida.append(" Comentarios: ").append(comentario);
        salida.append(" Contratado: ").append(contrato);
        
        return salida.toString();
		
	}
	
	@Override
	public String toString() {
		
		StringBuilder salida = new StringBuilder();
		
		salida.append(id).append("#");
        salida.append(nombre).append("#");
        salida.append(apellidos).append("#");
        salida.append(correo).append("#");
        salida.append(telefono).append("#");
        salida.append(fecha).append("#");
        salida.append(genero).append("#");
        salida.append(transporte).append("#");
        salida.append(comentario).append("#");
        salida.append(contrato).append("#");
        
        return salida.toString();
		
	}
	
}
