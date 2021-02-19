package videojuego.boss;

import java.util.Scanner;

public class Arena {

	private Personaje p;
	private Boss boss;
	static Scanner sc = new Scanner(System.in);

	public Arena(Personaje p, Boss boss) {
		this.p = p;
		this.boss = boss;
	}

	/**
	 * 
	 * @return persoanje ganador
	 */
	public Personaje pelea() {

		do {
			p.atacar(boss);
			System.out.println();
			boss.atacar(p);
			System.out.println("------------------------------------------------");
			String salto = sc.nextLine();
		} while (p.getVida() >= 0 && boss.getVida() >= 0);

		if (p.getVida() >= 0) {
			return p;
		} else {
			return boss;
		}

	}

}
