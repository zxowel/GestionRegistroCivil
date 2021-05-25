package cl.inacap.GestionModel.dto;

import java.util.concurrent.atomic.AtomicInteger;

public class cliente {
	private AtomicInteger NumSolicitud;
	private String Rut;
	private String Nombre;
	private String solicitud;
	
	

	public String getRut() {
		return Rut;
	}
	public void setRut(String rut) {
		Rut = rut;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getSolicitud() {
		return solicitud;
	}
	public void setSolicitud(String solicitud) {
		this.solicitud = solicitud;
	}
	public AtomicInteger getNumSolicitud() {
		return NumSolicitud;
	}
	public void setNumSolicitud(AtomicInteger numSolicitud) {
		NumSolicitud = numSolicitud;
	}



	
}
