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


import it.vITA.DTO.InvitoDTO;
import it.vITA.Models.Invito;
import it.vITA.Repositories.InvitiRepository;
import it.vITA.Repositories.UtenteRegistratoRepository;

/**
 * Controller REST per operazioni su inviti
 * 
 * @author Giorgio Pranzetti
 */
@RestController
@RequestMapping("/api/invito")
public class InvitoController {
	@Autowired
	InvitiRepository repoInviti;
	@Autowired
	UtenteRegistratoRepository repoUtenti;
	
private static final Logger logger = LoggerFactory.getLogger(InvitoController.class);
	
	/**
	 * Restituisce tutti gli inviti
	 * 
	 * @return
	 */
	@GetMapping
	public ResponseEntity<Object> getInviti(){
		Iterable<Invito> inviti = repoInviti.findAll();
		List<Invito> in = new ArrayList<>();
		inviti.forEach(x -> in.add(x));
		return new ResponseEntity<>(in,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getInvito(@PathVariable("id") String id){
		if(repoInviti.existsById(id)) {
			return new ResponseEntity<>(repoInviti.findById(id).get(),HttpStatus.OK);
		}
		return new ResponseEntity<>("Invito non trovato",HttpStatus.NOT_FOUND);
	}
	
	/**
	 * Crea un nuovo invito
	 * @param InvitoDTO
	 * @return invito creato
	 */
	@PostMapping
	public ResponseEntity<Object> createInvito(@RequestBody InvitoDTO dtoInvito){
		
		Invito i = null;
		if(repoUtenti.existsById(dtoInvito.getIdUtenteRegistrato())) {
			i = new Invito(repoUtenti.findById(dtoInvito.getIdUtenteRegistrato()).get());
			repoInviti.save(i);
			return new ResponseEntity<>(i,HttpStatus.CREATED);
		}
		return new ResponseEntity<>("Utente non trovato",HttpStatus.NOT_FOUND);
	}
	
	/**
	 * Aggiorna i dati di un invitp
	 * @param id dell'invito già esistente
	 * @param dtoInvito
	 */
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateInvito(@PathVariable("id") String id, @RequestBody InvitoDTO dtoInvito){
		
		if(repoInviti.existsById(id)) {
			Invito i = repoInviti.findById(id).get();
			if(repoUtenti.existsById(dtoInvito.getIdUtenteRegistrato())) {
				i = new Invito(repoUtenti.findById(dtoInvito.getIdUtenteRegistrato()).get());
				repoInviti.save(i);
				return new ResponseEntity<>(i,HttpStatus.CREATED);
			}
			return new ResponseEntity<>("Utente non trovato",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>("Invito non trovato",HttpStatus.NOT_FOUND);
	}
	
	
	
	/**
	 * Elimina un invito dato il suo id
	 * @param id dell'invito
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteInvito(@PathVariable("id") String id){
		if(repoInviti.existsById(id)) {
			repoInviti.deleteById(id);
			return new ResponseEntity<>("Invito eliminato",HttpStatus.OK);
		}
		return new ResponseEntity<>("Invito non trovato",HttpStatus.NOT_FOUND);
	}

}
