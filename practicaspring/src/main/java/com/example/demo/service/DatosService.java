package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Busqueda;
import com.example.demo.model.Camionero;
import com.example.demo.model.Operacion;

public interface DatosService {

	public abstract List<Camionero> listaCamionero();
	public abstract void altaCamionero(Camionero alta);
	public abstract boolean bajaCamionero(Busqueda baja);
	public abstract boolean busquedaCamionero(Busqueda bus);
	public abstract Camionero sacarCamionero(Busqueda bus);
	public abstract void modificarCamionero(Camionero modificado, Busqueda camionero);
	public abstract void guardarOperacion(String operacion, String descripcion);
	public abstract List<Operacion> listaOperaciones();
	
}
