package it.vITA.REST;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.vITA.Models.MetodologiaColtivazione;
import it.vITA.Models.Posizione;
import it.vITA.Repositories.MetodologieColtivazioneRepository;
/**
 * Rest controller che gestisce le metodologie di coltivazione
 */
@RestController
@RequestMapping("/api/metodologie")
public class MetodologiaColtivazioneController {
	
	private static final Logger logger = LoggerFactory.getLogger(MetodologiaColtivazioneController.class);
	
	@Autowired
	MetodologieColtivazioneRepository repoMetodologie;
	
	/**
	 * Restituisce tutte le metodologie memorizzate nel db
	 * 
	 * @author Giulia Balestra
	 */
	@GetMapping
	public ResponseEntity<Object> getMetodologie() {
		Iterable<MetodologiaColtivazione> metodologie = repoMetodologie.findAll();
		List<MetodologiaColtivazione> met = new ArrayList<>();
		metodologie.forEach(x -> met.add(x));
		return new ResponseEntity<>(metodologie,HttpStatus.OK);
	}
	
}
