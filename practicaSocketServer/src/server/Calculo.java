package server;

public class Calculo {

	private int n1, n2, operacion;

	public Calculo(int n1, int n2, int operacion) {
		super();
		this.n1 = n1;
		this.n2 = n2;
		this.operacion = operacion;
	}

	public int calcular() {
		int resultado = 0;

		switch (operacion) {
		case 1: {
			resultado = n1 + n2;
			break;
		}
		case 2: {
			resultado = n1 - n2;
			break;
		}
		case 3: {
			resultado = n1 * n2;
			break;
		}
		case 4: {
			resultado = n1 / n2;
			break;
		}
		case 5: {
			resultado = n1 % n2;
			break;
		}
		default:
			break;
		}

		return resultado;
	}
}
