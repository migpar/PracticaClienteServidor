package videojuego.boss;

import java.util.Random;

public class FactoriaPersonajes {

	public static Personaje randomPersonajeArmaFija() {

		Personaje p1 = null;
		Random rm = new Random();
		int elegirPersonaje = rm.nextInt(4);
		switch (elegirPersonaje) {
		case 0:
			p1 = (Personaje) MainJuego2.context.getBean("guerreroEspada");
			break;
		case 1:
			p1 = (Personaje) MainJuego2.context.getBean("guerreroArco");
			break;
		case 2:
			p1 = (Personaje) MainJuego2.context.getBean("curandero");
			break;
		case 3:
			p1 = (Personaje) MainJuego2.context.getBean("mago");
			break;
		default:
			p1 = (Personaje) MainJuego2.context.getBean("guerreroEspada");
			break;
		}

		return p1;

	}

}
