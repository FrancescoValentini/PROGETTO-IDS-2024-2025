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

import it.vITA.DTO.UtenteRegistratoDTO;
import it.vITA.Models.UtenteRegistrato;
import it.vITA.Repositories.UtenteRegistratoRepository;

/**
 * Controller REST per la gestione dell'attore UtenteRegistrato
 * 
 * @author Francesco Valentini
 */
@RestController
@RequestMapping("/api/utente")
public class UtenteRegistratoController {
	private static final Logger logger = LoggerFactory.getLogger(UtenteRegistratoController.class);
	@Autowired
	UtenteRegistratoRepository utentiRegistrati;

	/**
	 * Restituisce tutti gli utenti registrati
	 * @author Francesco Valentini 
	 */
	@GetMapping
	public ResponseEntity<Object> getUtenteRegistrato(){
		Iterable<UtenteRegistrato> inviti = utentiRegistrati.findAll();
		List<UtenteRegistrato> in = new ArrayList<>();
		inviti.forEach(x -> in.add(x));
		return new ResponseEntity<>(in,HttpStatus.OK);
	}
	
	/**
	 * Restituisce un singolo utente registrato
	 * @author Francesco Valentini 
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Object> getUtenteRegistrato(@PathVariable("id") String id){
		if(utentiRegistrati.existsById(id)) {
			return new ResponseEntity<>(utentiRegistrati.findById(id).get(),HttpStatus.OK);
		}
		return new ResponseEntity<>("Utente non trovato",HttpStatus.NOT_FOUND);
	}
	
	/**
	 * Crea un nuovo utente
	 * @author Francesco Valentini 
	 */
	@PostMapping
	public ResponseEntity<Object> createUtenteRegistrato(@RequestBody UtenteRegistratoDTO dtoUtenteRegistrato){
		UtenteRegistrato utente = new UtenteRegistrato();
		
		utente.setNome(dtoUtenteRegistrato.getNome());
		utente.setCognome(dtoUtenteRegistrato.getCognome());
		utente.setEmail(dtoUtenteRegistrato.getEmail());
		utente.setTelefono(dtoUtenteRegistrato.getTelefono());
		utente.setBiografia(dtoUtenteRegistrato.getBiografia());
		utente.setUsername(dtoUtenteRegistrato.getUsername());
		utente.setPassword(dtoUtenteRegistrato.getPassword());
		
		utentiRegistrati.save(utente);
		
		return new ResponseEntity<>(utente,HttpStatus.CREATED);
	}
	
	/**
	 * Aggiorna un utente registrato
	 * @author Francesco Valentini 
	 */
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateUtenteRegistrato(@PathVariable("id") String id, @RequestBody UtenteRegistratoDTO dtoUtenteRegistrato){
		if(utentiRegistrati.existsById(id)) {
			UtenteRegistrato utente = utentiRegistrati.findById(id).get();
			
			utente.setNome(dtoUtenteRegistrato.getNome());
			utente.setCognome(dtoUtenteRegistrato.getCognome());
			utente.setEmail(dtoUtenteRegistrato.getEmail());
			utente.setTelefono(dtoUtenteRegistrato.getTelefono());
			utente.setBiografia(dtoUtenteRegistrato.getBiografia());
			utente.setUsername(dtoUtenteRegistrato.getUsername());
			utente.setPassword(dtoUtenteRegistrato.getPassword());
			
			utentiRegistrati.save(utente);
			return new ResponseEntity<>(utente ,HttpStatus.OK);
		}
		return new ResponseEntity<>("Utente non trovato",HttpStatus.NOT_FOUND);
	}
	
	/**
	 * Elimina un utente registrato
	 * @author Francesco Valentini 
	 * 
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteUtenteRegistrato(@PathVariable("id") String id) {
		if(utentiRegistrati.existsById(id)) {
			utentiRegistrati.deleteById(id);
			return new ResponseEntity<>("Utente Eliminato",HttpStatus.OK);
		}
		return new ResponseEntity<>("Utente non trovato",HttpStatus.NOT_FOUND);
	}
	
}
