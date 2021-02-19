package TareaInmobiliaria;

public class Habitacion {

	private TipoHabitacion tipo;
	private float metros;

	public Habitacion(TipoHabitacion tipo, float metros) {
		super();
		this.tipo = tipo;
		this.metros = metros;
	}

	public TipoHabitacion getTipo() {
		return tipo;
	}

	public void setTipo(TipoHabitacion tipo) {
		this.tipo = tipo;
	}

	public float getMetros() {
		return metros;
	}

	public void setMetros(float metros) {
		this.metros = metros;
	}

}
