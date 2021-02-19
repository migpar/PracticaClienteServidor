package videojuego.boss;

import java.util.Random;

public class Rezos extends Arma {

	public Rezos(int daño, String tipo) {
		super(daño, tipo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int usar(int bonus) {
		System.out.println(green + "AAAAAAAAVEEEE MARIIIIIIIIAAAAAAA" + reset);
		Random rm = new Random();
		int dañoVariable = rm.nextInt(10) + 1;
		int dañoTotal = daño + dañoVariable;
		System.out.println("Tipo: " + cyan + tipo + reset + " daño:" + red + dañoTotal + reset);
		return dañoTotal;

	}

}
