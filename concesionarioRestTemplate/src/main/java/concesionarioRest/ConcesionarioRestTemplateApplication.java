package concesionarioRest;

import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import concesionarioRest.modelo.entidad.Coche;
import concesionarioRest.modelo.proxy.CocheProxy;

@SpringBootApplication
public class ConcesionarioRestTemplateApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ConcesionarioRestTemplateApplication.class, args);

		CocheProxy cProxy = context.getBean("cocheProxy", CocheProxy.class);

		System.out.println("LISTAR");
		List<Coche> listacoche = cProxy.listar();
		System.out.println(listacoche);

		System.out.println("OBTENER");
		Coche c2 = cProxy.obtener(1);
		System.out.println(c2);

		Coche c1 = new Coche();
		// no le ponemos el id, porque el servicio rest me asignara el id
		c1.setMarca("opel");
		c1.setModelo("astra");
		c1.setPotencia(120);

		System.out.println("ALTA");
		c1 = cProxy.alta(c1);

		System.out.println(c1);

		c2 = new Coche();
		c2.setMarca("Nissan");
		c2.setModelo("terao");
		c2.setPotencia(140);

		System.out.println("MODIFICAR");

		Coche c3 = cProxy.modificar(c2);

		System.out.println(c3);

		System.out.println("BORRAR");
		cProxy.borrar(1);
		System.out.println("coche borrado");

		System.out.println("LISTAR");
		listacoche = cProxy.listar();
		System.out.println(listacoche);

	}

}
