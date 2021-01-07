package cliente;

import java.util.Scanner;

public class LecturaEscritura {

	private static Scanner sc = new Scanner(System.in);

	public static boolean otraVez() {
		System.out.println("¿quieres hacer otro calculo? y/n");
		String respuesta = sc.nextLine();
		boolean resultado = true;
		boolean valido = true;
		do {
			if (respuesta.toLowerCase().equals("n")) {
				resultado = false;
				valido = false;
			} else if (respuesta.toLowerCase().equals("y")) {
				resultado = true;
				valido = false;
			} else {
				System.out.println("introdudca un valor valido");
				valido = true;
				respuesta = sc.nextLine();
			}
		} while (valido);
		return resultado;

	}

}
