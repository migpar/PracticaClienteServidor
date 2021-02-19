package videojuego;

import java.util.Random;

public class FactoriaArmas {
	
	public static Arma randomArma() {

		Arma arma = null;
		Random rm = new Random();
		int elegirArma = rm.nextInt(4);
		switch (elegirArma) {
		case 0:
			arma = (Arma) MainVidejuego.context.getBean("espada");
			break;
		case 1:
			arma = (Arma) MainVidejuego.context.getBean("arco");
			break;
		case 2:
			arma = (Arma) MainVidejuego.context.getBean("salmo");
			break;
		case 3:
			arma = (Arma) MainVidejuego.context.getBean("magia");
			break;

		default:
			arma = (Arma) MainVidejuego.context.getBean("espada");
			break;
		}

		return arma;

	}

}
