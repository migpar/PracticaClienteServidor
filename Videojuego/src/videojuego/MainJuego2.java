package videojuego;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainJuego2 {

	static Scanner sc = new Scanner(System.in);
	public static ApplicationContext context = null;

	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("recursos/personajes.xml");

		Personaje p1 = FactoriaPersonajes.randomPersonajeArmaFija();
		Personaje p2 = null;
		do {
			p2 = FactoriaPersonajes.randomPersonajeArmaFija();
		} while (p1 == p2);

		Arena batalla = new Arena(p1, p2);
		Personaje ganador = batalla.pelea();

		System.out.println(ganador.getNombre() + " ha resultado vencedor");

	}

}
