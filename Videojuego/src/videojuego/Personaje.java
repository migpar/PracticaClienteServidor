package videojuego;

public abstract class Personaje {
	protected String nombre;
	protected Arma arma;
	protected int vida;
	protected static String black = "\033[30m";
	protected static String red = "\033[31m";
	protected static String green = "\033[32m";
	protected static String yellow = "\033[33m";
	protected static String blue = "\033[34m";
	protected static String purple = "\033[35m";
	protected static String cyan = "\033[36m";
	protected static String white = "\033[37m";
	protected static String reset = "\u001B[0m";

	public Personaje(String nombre, Arma arma, int vida) {
		super();
		this.nombre = nombre;
		this.arma = arma;
		this.vida = vida;
	}

	public abstract void especial();

	public abstract void atacar(Personaje p);

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Arma getArma() {
		return arma;
	}

	public void setArma(Arma arma) {
		this.arma = arma;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

}
