package cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

	public static final int PUERTO = 2017;
	public static final String IP_SERVER = "localhost";

	public static void main(String[] args) {

		System.out.println("        APLICACION CLIENTE		   ");
		System.out.println("-----------------------------------");

		Socket socketCliente = null;
		InputStreamReader entrada = null;
		PrintStream salida = null;

		InetSocketAddress direccionServidor = new InetSocketAddress(IP_SERVER, PUERTO);

		Scanner sc = new Scanner(System.in);

		try {
			boolean continuar = true;
			do {
				socketCliente = new Socket();
				socketCliente.connect(direccionServidor);
				System.out.println("Conexion establecida... a " + IP_SERVER + " por el puerto " + PUERTO);

				entrada = new InputStreamReader(socketCliente.getInputStream());
				salida = new PrintStream(socketCliente.getOutputStream());

				System.out.println("CLIENTE: Introduzca los numeros");
				String numero1 = sc.nextLine();
				String numero2 = sc.nextLine();
				System.out.println("Introdudca operacion a realizar");
				System.out.println("SUMAR-1\nRESTAR-2\nMULTIPLICAR-3\nDIVIDIR-4\nMODULO-5\n");
				String operacion = sc.nextLine();
				String operandos = numero1 + "-" + numero2 + "-" + operacion;
				salida.println(operandos);

				BufferedReader bf = new BufferedReader(entrada);
				String resultado = bf.readLine();

				System.out.println("CLIENTE: " + resultado);
				continuar = LecturaEscritura.otraVez();
			} while (continuar);
		} catch (Exception e) {
			System.err.println("Error: " + e);
			e.printStackTrace();
		} finally {
			try {
				salida.close();
				entrada.close();
				socketCliente.close();
				sc.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
