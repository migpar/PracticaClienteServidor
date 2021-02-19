package TareaInmobiliaria;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PruebaInmobiliaria {

	public static ApplicationContext context = null;

	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("recursos/objetos.xml");

		Casa casa = context.getBean("casa", Casa.class);

		System.out.println("La casa en " + casa.getDireccion().getTipoVia() + "-" + casa.getDireccion().getNombreVia()
				+ " con codigo postal " + casa.getDireccion().getCp() + " es propiedad de "
				+ casa.getPropietario().getNombre() + " que vive en "
				+ casa.getPropietario().getDireccion().getTipoVia() + "-" + casa.getDireccion().getNombreVia()
				+ " y cuyos datos son: Telefono " + casa.getPropietario().getTelefono());

		System.out.println("Fecha de nacimiento " + casa.getPropietario().getFechaNacimiento() + " tiene "
				+ casa.getMetros() + " metros cuadrados , y tiene " + casa.numeroInquilinos() + " inquilinos ");

	}

}
