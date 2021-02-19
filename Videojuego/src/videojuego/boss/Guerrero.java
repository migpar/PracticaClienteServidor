package videojuego.boss;


public class Guerrero extends Personaje {

	private int fuerza;

	public Guerrero(String nombre, Arma arma, int vida, int fuerza) {
		super(nombre, arma, vida);
		this.fuerza = fuerza;
	}

	@Override
	public void atacar(Personaje p) {
		System.out.println(black + "DISCUUUULPEEEEE" + reset);
		if (arma instanceof Espada || arma instanceof Arco) {
			especial();
			p.setVida(p.getVida() - arma.usar((int) (fuerza)));
		} else {
			p.setVida(p.getVida() - arma.usar(fuerza));
		}

	}

	@Override
	public void especial() {
		if (this.getVida() <= 50) {
			fuerza *= 2;
		}
	}

	
}
