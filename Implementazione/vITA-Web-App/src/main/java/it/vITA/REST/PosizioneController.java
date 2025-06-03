package it.vITA.REST;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.vITA.Models.Posizione;
import it.vITA.Repositories.PosizioniRepository;

/**
 * Rest controller che gestisce le posizioni geografiche
 */
@RestController
@RequestMapping("/api/posizione")
public class PosizioneController {
	
	private static final Logger logger = LoggerFactory.getLogger(PosizioneController.class);
	
	@Autowired
	PosizioniRepository repoPosizioni;
	
	/**
	 * Restituisce tutte le posizioni memorizzate nel db
	 * 
	 * @author Francesco Valentini
	 */
	@GetMapping
	public ResponseEntity<Object> getPosizioni() {
		Iterable<Posizione> posizioni = repoPosizioni.findAll();
		List<Posizione> pos = new ArrayList<>();
		posizioni.forEach(x -> pos.add(x));
		return new ResponseEntity<>(posizioni,HttpStatus.OK);
	}
	
	/**
	 * Restituisce una singola posizione dato il suo id
	 * 
	 * @param id della posizione
	 * @author Francesco Valentini
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Object> getPosizione(@PathVariable("id") String id) {
		if(repoPosizioni.existsById(id)) {
			return new ResponseEntity<>(repoPosizioni.findById(id).get(),HttpStatus.OK);
		}
		return new ResponseEntity<>("Posizione non trovata",HttpStatus.NOT_FOUND);
	}
	
	
	
}
