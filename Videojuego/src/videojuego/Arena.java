package videojuego;

import java.util.Scanner;

public class Arena {

	private Personaje p1;
	private Personaje p2;
	static Scanner sc = new Scanner(System.in);

	public Arena(Personaje p1, Personaje p2) {
		this.p1 = p1;
		this.p2 = p2;
	}

	/**
	 * 
	 * @return persoanje ganador
	 */
	public Personaje pelea() {

		do {
			p1.atacar(p2);
			System.out.println();
			p2.atacar(p1);
			System.out.println("------------------------------------------------");
			String salto = sc.nextLine();
		} while (p1.getVida() >= 0 && p2.getVida() >= 0);

		if (p1.getVida() >= 0) {
			return p1;
		} else {
			return p2;
		}

	}

}
