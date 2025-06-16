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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.vITA.Models.Trasformazione;
import it.vITA.Repositories.TrasformazioniRepository;



/**
 * Rest controller che gestisce le trasformazioni
 * @author Giulia Balestra
 */


@RestController
@RequestMapping("/api/trasformazione")
public class TrasformazioneController {
private static final Logger logger = LoggerFactory.getLogger(TrasformazioneController.class);
	
	@Autowired
	TrasformazioniRepository repoTrasformazioni;
	
	
	/**
	 * Restituisce tutte le trasformazioni memorizzati nel db
	 */
	@GetMapping
	public ResponseEntity<Object> getTrasformazioni() {
		Iterable<Trasformazione> trasformazioni = repoTrasformazioni.findAll();
		List<Trasformazione> t = new ArrayList<>();
		trasformazioni.forEach(x -> t.add(x));
		return new ResponseEntity<>(trasformazioni,HttpStatus.OK);
	}
	/**
	 * Restituisce una singola trasformazione dato il suo id
	 * @param id allergene
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Object> getTrasformazione(@PathVariable("id") String id) {
		if(repoTrasformazioni.existsById(id)) {
			return new ResponseEntity<>(repoTrasformazioni.findById(id).get(),HttpStatus.OK);
		}
		return new ResponseEntity<>("Trasformazione non trovata",HttpStatus.NOT_FOUND);
	}
	
	
}
