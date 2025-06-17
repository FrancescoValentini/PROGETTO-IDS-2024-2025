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

import it.vITA.DTO.TrasformatoreDTO;
import it.vITA.Models.Posizione;
import it.vITA.Models.Trasformatore;
import it.vITA.Repositories.PosizioniRepository;
import it.vITA.Repositories.TrasformatoreRepository;
import jakarta.transaction.Transactional;

/**
 * Controller REST per operazioni su trasformatore
 * 
 * @author Giulia Balestra
 */
@RestController
@RequestMapping("/api/trasformatore")
public class TrasformatoreController {
	
	@Autowired
	TrasformatoreRepository repoTrasformatori;
	
	@Autowired
	PosizioniRepository repoPosizioni;
	
	private static final Logger logger = LoggerFactory.getLogger(TrasformatoreController.class);
	
	/**
	 * Restituisce tutti i trasformatori
	 */
	@GetMapping
	public ResponseEntity<Object> getTrasformatori(){
		Iterable<Trasformatore> trasformatori = repoTrasformatori.findAll();
		List<Trasformatore> t = new ArrayList<>();
		trasformatori.forEach(x -> t.add(x));
		return new ResponseEntity<>(t ,HttpStatus.OK);
	}
	
	/**
	 * Restituisce un singolo trasformatore dato il suo id
	 * @param id trasformatore
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Object> getTrasformatore(@PathVariable("id") String id) {
		if(repoTrasformatori.existsById(id)) {
			return new ResponseEntity<>(repoTrasformatori.findById(id).get(),HttpStatus.OK);
		}
		return new ResponseEntity<>("Trasformatore non trovato",HttpStatus.NOT_FOUND);
	}
	
	/**
	 * Aggiunge un nuovo trasformatore
	 * @param DTOTrasformatore
	 * @author Giulia Balestra
	 */
	@PostMapping
	public ResponseEntity<Object> createTrasformatore(@RequestBody TrasformatoreDTO dtoTrasformatore) {
	    
	    Posizione posizione = null;
	    String idPosizione = dtoTrasformatore.getPosizioneGeografica();

	    // Controlla se la posizione esiste
	    if (repoPosizioni.existsById(idPosizione)) {
	        posizione = repoPosizioni.findById(idPosizione).get();
	    } else {
	        return new ResponseEntity<>("Posizione non trovata", HttpStatus.NOT_FOUND);
	    }

	    // Crea il trasformatore usando il DTO e la posizione trovata
	    Trasformatore trasformatore = new Trasformatore(
	    	dtoTrasformatore.getUsername(),
	    	dtoTrasformatore.getPassword(),
	    	dtoTrasformatore.getEmail(),
	    	dtoTrasformatore.getNome(),
	    	dtoTrasformatore.getCognome(),
	    	dtoTrasformatore.getTelefono(),
	    	dtoTrasformatore.getBiografia(),
	        dtoTrasformatore.getPartitaIva(),
	        dtoTrasformatore.getDenominazioneAzienda(),
	        dtoTrasformatore.getTelefonoAziendale(),
	        posizione
	    );

	    repoTrasformatori.save(trasformatore);
	    return new ResponseEntity<>(trasformatore, HttpStatus.CREATED);
	}
	
	/**
	 * Aggiorna i dati del trasformatore
	 * @param id
	 * @param dtoTrasformatore
	 * @return
	 */
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateTrasformatore(@PathVariable("id") String id, @RequestBody TrasformatoreDTO dtoTrasformatore) {

	    Posizione posizione = null;
	    String idPosizione = dtoTrasformatore.getPosizioneGeografica();

	    // Controlla se la posizione esiste
	    if (repoPosizioni.existsById(idPosizione)) {
	        posizione = repoPosizioni.findById(idPosizione).get();
	    } else {
	        return new ResponseEntity<>("Posizione non trovata", HttpStatus.NOT_FOUND);
	    }

	    // Controlla se il trasformatore esiste
	    if (repoTrasformatori.existsById(id)) {
	        Trasformatore t = repoTrasformatori.findById(id).get();

	        // Aggiorna i campi
	        t.setPartitaIva(dtoTrasformatore.getPartitaIva());
	        t.setDenominazioneAzienda(dtoTrasformatore.getDenominazioneAzienda());
	        t.setTelefonoAziendale(dtoTrasformatore.getTelefonoAziendale());
	        t.setPosizioneGeografica(posizione);

	        // Salva il trasformatore aggiornato
	        repoTrasformatori.save(t);

	        return new ResponseEntity<>(t, HttpStatus.OK);
	    }

	    return new ResponseEntity<>("Trasformatore non trovato", HttpStatus.NOT_FOUND);
	}
	
	/**
	 * Elimina un trasformatore dal DB
	 * @param id
	 * @return
	 */
	@DeleteMapping("/{id}")
	@Transactional  
	public ResponseEntity<Object> deleteTrasformatore(@PathVariable("id") String id) {
	    if (!repoTrasformatori.existsById(id)) {
	        return new ResponseEntity<>("Trasformatore non trovato", HttpStatus.NOT_FOUND);
	    }
	    repoTrasformatori.deleteById(id);
	    return new ResponseEntity<>("Trasformatore eliminato", HttpStatus.OK);
	}



}
	
