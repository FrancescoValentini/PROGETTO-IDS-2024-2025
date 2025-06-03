package it.vITA.REST;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.vITA.Models.Evento;
import it.vITA.Models.Posizione;
import it.vITA.Repositories.EventiRepository;
import it.vITA.Repositories.PosizioniRepository;

/**
 * Controller REST per operazioni CRUD su eventi
 * 
 * @author Francesco Valentini
 */
@RestController
@RequestMapping("/api/evento")
public class EventoController {
	@Autowired
	EventiRepository repoEventi;
	
	@Autowired
	PosizioniRepository repoPosizioni;
	
	private static final Logger logger = LoggerFactory.getLogger(EventoController.class);
	
	/**
	 * Restituisce tutti gli eventi
	 * 
	 * @return
	 */
	@GetMapping
	public ResponseEntity<Object> getEventi(){
		Iterable<Evento> eventi = repoEventi.findAll();
		List<Evento> ev = new ArrayList<>();
		eventi.forEach(x -> ev.add(x));
		return new ResponseEntity<>(ev,HttpStatus.OK);
	}
	
	
	
	
}
