package videojuego;

public class Curanderos extends Personaje {
	private int sabiduria;

	public Curanderos(String nombre, Arma arma, int vida, int sabiduria) {
		super(nombre, arma, vida);
		this.sabiduria = sabiduria;
	}

	@Override
	public void atacar(Personaje p) {
		System.out.println(blue + "Toma ostia consagrada" + reset);
		if (arma instanceof Rezos) {
			p.setVida(p.getVida() - arma.usar(0));
			especial();
		} else {
			arma.usar(0);
		}

	}

	public void especial() {
		if (this.getVida() <= this.getVida()/2) {
			setVida(this.getVida() + sabiduria * 2);
			System.out.println(purple + "Curacion Critica" + reset);
		} else {
			setVida(this.getVida() + sabiduria);
			System.out.println(purple + "Curacion" + reset);
		}
	}

}
