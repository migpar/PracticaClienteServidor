package TareaInmobiliaria;

import java.util.ArrayList;

public class Casa {

	private float metros;
	private ArrayList<Habitacion> habitaciones;
	private Persona propietario;
	private Direccion direccion;
	private ArrayList<Persona> inquilino;

	public Casa(ArrayList<Habitacion> habitaciones, Persona propietario, Direccion direccion,
			ArrayList<Persona> inquilino) {
		super();
		this.metros = metros;
		this.habitaciones = habitaciones;
		this.propietario = propietario;
		this.direccion = direccion;
		this.inquilino = inquilino;
	}

	public float getMetros() {
		float metrostotales = 0;
		for (int i = 0; i < habitaciones.size(); i++) {
			metrostotales += habitaciones.get(i).getMetros();

		}

		return metrostotales;
	}

	public void setMetros(float metros) {
		this.metros = metros;
	}

	public ArrayList<Habitacion> getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(ArrayList<Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}

	public Persona getPropietario() {
		return propietario;
	}

	public void setPropietario(Persona propietario) {
		this.propietario = propietario;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public ArrayList<Persona> getInquilino() {
		return inquilino;
	}

	public void setInquilino(ArrayList<Persona> inquilino) {
		this.inquilino = inquilino;
	}
	
	public int numeroInquilinos() {
		int n = 0;
		if(inquilino != null) {
			n = inquilino.size();
		}
		return n;
	}

}
