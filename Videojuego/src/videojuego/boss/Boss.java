package videojuego.boss;

public class Boss extends Personaje{
	
	private int fuerza = 1;

	public Boss(String nombre, Arma arma, int vida) {
		super(nombre, arma, vida);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void especial() {
		fuerza++;
		
	}

	@Override
	public void atacar(Personaje p) {
		System.out.println(red + "MUERE!" + reset);
		if (arma instanceof Espada || arma instanceof Arco) {
			especial();
			p.setVida(p.getVida() - arma.usar((int) (fuerza)));
		} else {
			p.setVida(p.getVida() - arma.usar(fuerza));
		}
		
	}

}
