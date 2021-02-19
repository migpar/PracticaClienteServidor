package com.uem.restpersona.controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.uem.restpersona.modelo.entidad.Coche;
import com.uem.restpersona.modelo.negocio.GestorCoche;

@RestController
public class ControladorCoche {

	@Autowired
	private GestorCoche gestorCoche;

	@GetMapping("coches")
	public ResponseEntity<List<Coche>> listar() {
		List<Coche> lista = gestorCoche.listarCoches();
		ResponseEntity<List<Coche>> re = new ResponseEntity<List<Coche>>(lista, HttpStatus.OK);
		return re;
	}

	@GetMapping("coches/{id}")
	public ResponseEntity<Coche> obtener(@PathVariable("id") int id) {
		Coche p = gestorCoche.obtener(id);
		HttpStatus codigo_respuesta = null;

		if (p != null) {
			codigo_respuesta = HttpStatus.OK;
		} else {
			codigo_respuesta = HttpStatus.NOT_FOUND;
		}

		ResponseEntity<Coche> re = new ResponseEntity<Coche>(p, codigo_respuesta);
		return re;

	}

	@PostMapping("coches")
	public ResponseEntity<Coche> alta(@RequestBody Coche coche) {
		Coche pAlta = null;
		HttpStatus codigo_respuesta = null;
		if (coche.getPotencia() > 0) {
			pAlta = gestorCoche.alta(coche);
		}
		if (pAlta != null) {
			codigo_respuesta = HttpStatus.CREATED;
		} else {
			codigo_respuesta = HttpStatus.BAD_REQUEST;
		}
		ResponseEntity<Coche> re = new ResponseEntity<Coche>(pAlta, codigo_respuesta);
		return re;
	}

	@PutMapping("coches/{id}")
	public ResponseEntity<Coche> modificar(@RequestBody Coche coche, @PathVariable("id") int id) {
		coche.setId(id);
		Coche pModificar = null;
		if (coche.getPotencia() > 0) {
			pModificar = gestorCoche.alta(coche);
		}
		HttpStatus codigo_respuesta = null;
		if (pModificar != null) {
			codigo_respuesta = HttpStatus.OK;
		} else {
			codigo_respuesta = HttpStatus.BAD_REQUEST;
		}
		ResponseEntity<Coche> re = new ResponseEntity<Coche>(pModificar, codigo_respuesta);
		return re;
	}

	@DeleteMapping("coches/{id}")
	public ResponseEntity<Integer> borrar(@PathVariable("id") int id) {
		boolean borrado = gestorCoche.borrar(id);
		HttpStatus codigo_respuesta = null;
		if (borrado) {
			codigo_respuesta = HttpStatus.OK;
		} else {
			codigo_respuesta = HttpStatus.BAD_REQUEST;
		}

		return new ResponseEntity<Integer>(id, codigo_respuesta);
	}

}
