package com.uem.restpersona.modelo.negocio;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uem.restpersona.modelo.entidad.Coche;
import com.uem.restpersona.modelo.persistencia.DaoCoche;

@Service
public class GestorCoche {

	@Autowired
	private DaoCoche daocoche;

	/**
	 * Buscamos un coche en la BBDD mediante la id
	 * 
	 * @param id del coche a buscar
	 * @return el coche buscao o null si no se encuentra
	 */
	public Coche obtener(int id) {
		Optional<Coche> opt = daocoche.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		} else {
			return null;
		}
	}

	/**
	 * Damos de alta un coche en la BBDD
	 * 
	 * @param coche
	 * @return el coche con la id o null en caso de que no se pueda insertar
	 */
	public Coche alta(Coche coche) {
		Coche cocheAlta = daocoche.save(coche);
		return cocheAlta;
	}

	/**
	 * Metodo qe borra una persona a partir de una id de la bbdd
	 * 
	 * @param id del coche a borrar
	 * @return true en caso de que el coche exista en la base de datos, false en
	 *         caso de que no exista
	 */
	public boolean borrar(int id) {
		if (daocoche.findById(id).isPresent()) {
			daocoche.deleteById(id);
			return true;
		} else {
			return false;
		}

	}

	/**
	 * modificamos un coche ya dado de alta
	 * 
	 * @param coche coche a modificar
	 * @return nos devuelve el coche modificado o null si no esta en la BBDD
	 */
	public Coche modificar(Coche coche) {
		if (obtener(coche.getId()) == null) {
			return null;
		} else {
			Coche c = daocoche.save(coche);
			return c;
		}
	}
	/**
	 * Para recuperar la lista de coches de la BBDD
	 * 
	 * @return List<Coche> con los coches en BBDD
	 */
	public List<Coche> listarCoches(){
		List<Coche> lista = daocoche.findAll();
		return lista;
	}

}
