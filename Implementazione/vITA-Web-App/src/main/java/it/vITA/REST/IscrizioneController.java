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

import it.vITA.DTO.IscrizioneDTO;
import it.vITA.Models.Iscrizione;
import it.vITA.Repositories.IscrizioneRepository;
import it.vITA.Repositories.UtenteRegistratoRepository;
/**
 * Rest controller che gestisce le iscrizioni
 */
@RestController
@RequestMapping("/api/iscrizione")
public class IscrizioneController {
	
	private static final Logger logger = LoggerFactory.getLogger(IscrizioneController.class);
	
	@Autowired
	IscrizioneRepository repoIscrizioni;
	@Autowired
	UtenteRegistratoRepository repoUtenti;	
	/**
	 * Restituisce tutte le iscrizioni memorizzate nel db
	 * 
	 * @author Giorgio Pranzetti
	 */
	@GetMapping
	public ResponseEntity<Object> getIscrizioni() {
		Iterable<Iscrizione> iscrizioni = repoIscrizioni.findAll();
		List<Iscrizione> pos = new ArrayList<>();
		iscrizioni.forEach(x -> pos.add(x));
		return new ResponseEntity<>(iscrizioni,HttpStatus.OK);
	}
	
	/**
	 * Restituisce una singola iscrizione dato il suo id
	 * 
	 * @param id iscrizione
	 * @author Giorgio Pranzetti
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Object> getIscrizioni(@PathVariable("id") String id) {
		if(repoIscrizioni.existsById(id)) {
			return new ResponseEntity<>(repoIscrizioni.findById(id).get(),HttpStatus.OK);
		}
		return new ResponseEntity<>("Posizione non trovata",HttpStatus.NOT_FOUND);
	}
	
	/**
	 * Aggiunge una nuova iscrizione
	 * @param DTOiscrizione
	 * @author Giorgio Pranzetti
	 */
	@PostMapping
	public ResponseEntity<Object> createIscrizione(@RequestBody IscrizioneDTO iscrizione){
		Iscrizione is = new Iscrizione();
		if(repoUtenti.existsById(iscrizione.getIdUtenteRegistrato())) {
			is.setIscritto(repoUtenti.findById(iscrizione.getIdUtenteRegistrato()).get());
			repoIscrizioni.save(is);
			return new ResponseEntity<>(is,HttpStatus.CREATED);
		}
		return new ResponseEntity<>("Utente non trovato",HttpStatus.NOT_FOUND);
	}
	
	/**
	 * Elimina un iscrizione
	 * @param id iscrizione
	 * @author Giorgio Pranzetti
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteIscrizione(@PathVariable("id") String id) {
		if(repoIscrizioni.existsById(id)) {
			repoIscrizioni.deleteById(id);
			return new ResponseEntity<>("Iscrizione eliminata",HttpStatus.OK);
		}
		return new ResponseEntity<>("Iscrizione non trovata",HttpStatus.NOT_FOUND);
	}
	
	/**
	 * Aggiorna un iscrizione
	 * @param iscrizioneDTO
	 * @param id
	 * @author Giorgio Pranzetti
	 */
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateIscrizione(@PathVariable("id") String id, @RequestBody IscrizioneDTO iscrizione){
		if(repoIscrizioni.existsById(id)) {
			Iscrizione i = repoIscrizioni.findById(id).get();
			if(repoUtenti.existsById(iscrizione.getIdUtenteRegistrato())) {
				i.setIscritto(repoUtenti.findById(iscrizione.getIdUtenteRegistrato()).get());
				repoIscrizioni.save(i);
				return new ResponseEntity<>(i,HttpStatus.CREATED);
			}
			return new ResponseEntity<>("Utente non trovato",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>("Iscrizione non trovata",HttpStatus.NOT_FOUND);
	}
	
	
	

}
