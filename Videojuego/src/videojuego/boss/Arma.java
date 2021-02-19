package videojuego.boss;

public abstract class Arma {
	protected int daño;
	protected String tipo;
	protected static String black = "\033[30m";
	protected static String red = "\033[31m";
	protected static String green = "\033[32m";
	protected static String yellow = "\033[33m";
	protected static String blue = "\033[34m";
	protected static String purple = "\033[35m";
	protected static String cyan = "\033[36m";
	protected static String white = "\033[37m";
	protected static String reset = "\u001B[0m";

	public Arma(int daño, String tipo) {

		this.daño = daño;
		this.tipo = tipo;
	}
	
	

	public abstract int usar(int bonus);

	public int getDaño() {
		return daño;
	}

	public void setDaño(int daño) {
		this.daño = daño;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
