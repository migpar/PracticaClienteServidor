package videojuego.boss;

import java.util.Random;

public class Hechizos extends Arma {

	public Hechizos(int daño, String tipo) {
		super(daño, tipo);

	}

	@Override
	public int usar(int bonus) {
		System.out.println(black + "Adakadabra pasta la cabra" + reset);
		Random rm = new Random();
		int dañoVariable = rm.nextInt(10) + 1;
		int dañoTotal = daño + bonus + dañoVariable;
		System.out.println("Tipo: " + cyan + tipo + reset + " daño:" + red + dañoTotal + reset);
		return dañoTotal;

	}

}
