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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import it.vITA.DTO.ProduttoreDTO;
import it.vITA.Models.Posizione;
import it.vITA.Models.Produttore;
import it.vITA.Repositories.PosizioniRepository;
import it.vITA.Repositories.ProduttoriRepository;

/**
 * Rest controller che gestisce i produttori
 */
@RestController
@RequestMapping("/api/produttore")
public class ProduttoreController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProduttoreController.class);
	
	@Autowired
	ProduttoriRepository repoProduttori;
	
	@Autowired
	PosizioniRepository repoPosizioni;
	
	
	/**
	 * Restituisce tutti i produttori memorizzati nel db
	 */
	@GetMapping
	public ResponseEntity<Object> getProduttori() {
		Iterable<Produttore> produttori = repoProduttori.findAll();
		List<Produttore> p = new ArrayList<>();
		produttori.forEach(x -> p.add(x));
		return new ResponseEntity<>(produttori,HttpStatus.OK);
	}
	
	/**
	 * Restituisce un singolo produttore dato il suo id
	 * @param id produttore
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Object> getProduttore(@PathVariable("id") String id) {
		if(repoProduttori.existsById(id)) {
			return new ResponseEntity<>(repoProduttori.findById(id).get(),HttpStatus.OK);
		}
		return new ResponseEntity<>("Produttore non trovato",HttpStatus.NOT_FOUND);
	}
	
	/**
	 * Aggiunge un nuovo produttore
	 * @param DTOProduttore
	 * @author Giulia Balestra
	 */
	@PostMapping
	public ResponseEntity<Object> createProduttore(@RequestBody ProduttoreDTO dtoProduttore) {
	    
	    Posizione posizione = null;
	    String idPosizione = dtoProduttore.getPosizioneGeografica();

	    // Controlla se la posizione esiste
	    if (repoPosizioni.existsById(idPosizione)) {
	        posizione = repoPosizioni.findById(idPosizione).get();
	    } else {
	        return new ResponseEntity<>("Posizione non trovata", HttpStatus.NOT_FOUND);
	    }

	    // Crea il produttore usando il DTO e la posizione trovata
	    Produttore produttore = new Produttore(
	    	dtoProduttore.getUsername(),
	    	dtoProduttore.getPassword(),
	    	dtoProduttore.getEmail(),
	    	dtoProduttore.getNome(),
	    	dtoProduttore.getCognome(),
	    	dtoProduttore.getTelefono(),
	    	dtoProduttore.getBiografia(),
	        dtoProduttore.getPartitaIva(),
	        dtoProduttore.getDenominazioneAzienda(),
	        dtoProduttore.getTelefonoAziendale(),
	        posizione
	    );

	    repoProduttori.save(produttore);
	    return new ResponseEntity<>(produttore, HttpStatus.CREATED);
	}
	
	/**
	 * Aggiorna i dati del produttore
	 * @param id
	 * @param dtoProduttore
	 * @return
	 */
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateProduttore(@PathVariable("id") String id, @RequestBody ProduttoreDTO dtoProduttore) {

	    Posizione posizione = null;
	    String idPosizione = dtoProduttore.getPosizioneGeografica();

	    // Controlla se la posizione esiste
	    if (repoPosizioni.existsById(idPosizione)) {
	        posizione = repoPosizioni.findById(idPosizione).get();
	    } else {
	        return new ResponseEntity<>("Posizione non trovata", HttpStatus.NOT_FOUND);
	    }

	    // Controlla se il produttore esiste
	    if (repoProduttori.existsById(id)) {
	        Produttore p = repoProduttori.findById(id).get();

	    // Aggiorna i campi
	    p.setPartitaIva(dtoProduttore.getPartitaIva());
	    p.setDenominazioneAzienda(dtoProduttore.getDenominazioneAzienda());
	    p.setTelefonoAziendale(dtoProduttore.getTelefonoAziendale());
	    p.setPosizioneGeografica(posizione);

	    // Salva il produttore aggiornato
	    repoProduttori.save(p);

	        return new ResponseEntity<>(p, HttpStatus.OK);
	    }

	    return new ResponseEntity<>("Produttore non trovato", HttpStatus.NOT_FOUND);
	}
	
}
