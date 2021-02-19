package videojuego.boss;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainJuego2 {

	static Scanner sc = new Scanner(System.in);
	public static ApplicationContext context = null;

	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("recursos/personajesVsBoss.xml");
		
		Boss boss = context.getBean("boss", Boss.class);
		Dungeon cueva = new Dungeon(boss);

		Personaje p1 = FactoriaPersonajes.randomPersonajeArmaFija();
		Personaje p2 = null;
		Personaje p3 = null;
		do {
			p2 = FactoriaPersonajes.randomPersonajeArmaFija();
		} while (p1 == p2);
		
		do {
			p3 = FactoriaPersonajes.randomPersonajeArmaFija();
		} while (p3 == p1 || p3 == p2);
		System.out.println(p1.getNombre() + " - " + p2.getNombre() + " - " + p3.getNombre());
		
		p1.setDungeon(cueva);
		p2.setDungeon(cueva);
		p3.setDungeon(cueva);
		
		Thread t1 = new Thread(p1);
		Thread t2 = new Thread(p2);
		Thread t3 = new Thread(p3);		
		
		t1.start();
		t2.start();
		t3.start();
	}

}
