package concesionarioRest.modelo.proxy;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import concesionarioRest.modelo.entidad.Coche;

@Service
public class CocheProxy {

	public static final String URL_COCHES = "http://localhost:8095/coches/";

	public List<Coche> listar() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Coche[]> response = restTemplate.getForEntity(URL_COCHES, Coche[].class);

		Coche[] arrayPersonas = response.getBody();

		List<Coche> lista = Arrays.asList(arrayPersonas);

		return lista;
	}
	
	public Coche obtener(int id) {
		RestTemplate restTemplate = new RestTemplate();

		String personaResourceUrl = URL_COCHES + id;

		ResponseEntity<Coche> response = restTemplate.getForEntity(personaResourceUrl, Coche.class);
		
		return response.getBody();
	}
	
	public Coche alta(Coche coche) {
		RestTemplate restTemplate = new RestTemplate();

		HttpEntity<Coche> requestBody = new HttpEntity<>(coche);

		Coche pCreada = restTemplate.postForObject(URL_COCHES, requestBody, Coche.class);

		return pCreada;
	}
	
	public Coche modificar(Coche coche) {
		RestTemplate restTemplate = new RestTemplate();

		HttpEntity<Coche> requestBody = new HttpEntity<>(coche);

		ResponseEntity<Coche> response = 
				restTemplate.exchange(URL_COCHES + coche.getId(), 
						HttpMethod.PUT, 
						requestBody, 
						Coche.class);
 
		return response.getBody();
	}
	
	public void borrar(int id) {
		RestTemplate restTemplate = new RestTemplate();
		 
        restTemplate.delete(URL_COCHES + id);
	}


}
