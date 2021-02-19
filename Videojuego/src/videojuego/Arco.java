package videojuego;

import java.util.Random;

public class Arco extends Arma {

	public Arco(int daño, String tipo) {
		super(daño, tipo);

	}

	@Override
	public int usar(int bonus) {
		System.out.println(yellow + "chiuuuuuuuuuuu" + reset);
		Random rm = new Random();
		int dañoVariable = rm.nextInt(10) + 1;
		int dañoTotal = getDaño() + dañoVariable;
		System.out.println("Tipo: " + cyan + tipo + reset + " daño:" + red + dañoTotal + reset);
		return dañoTotal;

	}

}
