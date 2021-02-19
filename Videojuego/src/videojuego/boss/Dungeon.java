package videojuego.boss;


public class Dungeon {

	private Boss boss;

	public Dungeon( Boss boss) {
		super();
		this.boss = boss;
	}
	
	public synchronized void entrar(Personaje p) {
		Arena arena = new Arena(p, boss);
		Personaje ganador = arena.pelea();
		
		if(ganador.getNombre().equals(boss.getNombre())) {
			System.err.println(p.getNombre() + " Ha fracasado");
		} else {
			System.out.println(ganador.getNombre() + "LO HA CONSEGUDO!!!!!!!");
		}
		
	}
	
	public Boss getBoss() {
		return boss;
	}

	public void setBoss(Boss boss) {
		this.boss = boss;
	}

}
