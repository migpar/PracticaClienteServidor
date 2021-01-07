package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static final int PUERTO = 2017;
	public static final String IP_SERVER = "localhost";

	public static void main(String[] args) {
		System.out.println("      APLICACION DE SERVIDOR      ");
		System.out.println("----------------------------------");

		ServerSocket servidorSocket = null;
		Socket socketConexion = null;
		PrintStream salida = null;
		InputStreamReader entrada = null;

		try {
			servidorSocket = new ServerSocket();
			InetSocketAddress direccion = new InetSocketAddress(IP_SERVER, PUERTO);
			servidorSocket.bind(direccion);

			while (true) {
				System.out.println("SERVIDOR: Esperando peticion...");
				socketConexion = servidorSocket.accept();
				entrada = new InputStreamReader(socketConexion.getInputStream());
				BufferedReader bf = new BufferedReader(entrada);

				String stringRecibido = bf.readLine();
				System.out.println("SERVIDOR: Me ha llegado del cliente: " + stringRecibido);
				String[] operadores = stringRecibido.split("-");
				Calculo calculo = new Calculo(Integer.parseInt(operadores[0]), Integer.parseInt(operadores[1]),
						Integer.parseInt(operadores[2]));
				int resultado = calculo.calcular();
				salida = new PrintStream(socketConexion.getOutputStream());
				salida.println(resultado);

			}
		} catch (IOException excepcion) {
			System.out.println(excepcion);
		} finally {
			try {
				if (salida != null && entrada != null) {
					salida.close();
					entrada.close();
					socketConexion.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
