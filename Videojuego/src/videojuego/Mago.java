package videojuego;

public class Mago extends Personaje {
	private int inteligencia;

	public Mago(int inteligencia, int vida, Arma arma, String nombre) {
		super(nombre, arma, vida);
		this.inteligencia = inteligencia;
	}

	@Override
	public void atacar(Personaje p) {
		System.out.println(purple + "Toma castaña" + reset);
		if (arma instanceof Hechizos) {
			especial();
			p.setVida(p.getVida() - arma.usar((int) (inteligencia)));
		} else {
			p.setVida(p.getVida() - arma.usar(inteligencia));
		}

	}

	@Override
	public void especial() {
		if (this.getVida() <= 50) {
			inteligencia *= 2;
		}
		
	}
}
