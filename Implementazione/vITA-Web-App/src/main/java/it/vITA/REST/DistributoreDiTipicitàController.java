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

import it.vITA.DTO.DistributoreDiTipicitàDTO;
import it.vITA.Models.DistributoreDiTipicità;
import it.vITA.Models.Posizione;
import it.vITA.Repositories.DistributoreDiTipicitàRepository;
import it.vITA.Repositories.PosizioniRepository;
import jakarta.transaction.Transactional;


/**
 * Controller REST per operazioni su distributore di tipicità
 * 
 * @author Giulia Balestra
 */
@RestController
@RequestMapping("/api/distributore")
public class DistributoreDiTipicitàController {
	
	@Autowired 
	DistributoreDiTipicitàRepository repoDistributori;
	
	@Autowired
	PosizioniRepository repoPosizioni;
	
	private static final Logger logger = LoggerFactory.getLogger(DistributoreDiTipicitàController.class);
	

	/**
	 * Restituisce tutti i distributori di tipicità
	 */
	@GetMapping
	public ResponseEntity<Object> getDistributori(){
		Iterable<DistributoreDiTipicità> distributori = repoDistributori.findAll();
		List<DistributoreDiTipicità> d = new ArrayList<>();
		distributori.forEach(x -> d.add(x));
		return new ResponseEntity<>(d ,HttpStatus.OK);
	}
	/**
	 * Restituisce un singolo distributore dato il suo id
	 * @param id distributore
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Object> getDistributore(@PathVariable("id") String id) {
		if(repoDistributori.existsById(id)) {
			return new ResponseEntity<>(repoDistributori.findById(id).get(),HttpStatus.OK);
		}
		return new ResponseEntity<>("Distributore di tipicità non trovato",HttpStatus.NOT_FOUND);
	}
	/**
	 * Aggiunge un nuovo distributore
	 * @param DTODistributore
	 * @author Giulia Balestra
	 */
	@PostMapping
	public ResponseEntity<Object> createDistributore(@RequestBody DistributoreDiTipicitàDTO dtoDistributore) {
	    
	    Posizione posizione = null;
	    String idPosizione = dtoDistributore.getPosizioneGeografica();

	    // Controlla se la posizione esiste
	    if (repoPosizioni.existsById(idPosizione)) {
	        posizione = repoPosizioni.findById(idPosizione).get();
	    } else {
	        return new ResponseEntity<>("Posizione non trovata", HttpStatus.NOT_FOUND);
	    }

	    DistributoreDiTipicità distributore = new DistributoreDiTipicità(
	    		dtoDistributore.getUsername(),
	    		dtoDistributore.getPassword(),
	    		dtoDistributore.getEmail(),
	    		dtoDistributore.getNome(),
	    		dtoDistributore.getCognome(),
	    		dtoDistributore.getTelefono(),
	    		dtoDistributore.getBiografia(),
	    		dtoDistributore.getPartitaIva(),
	    		dtoDistributore.getDenominazioneAzienda(),
	    		dtoDistributore.getTelefonoAziendale(),
	    		posizione
	    );

	    repoDistributori.save(distributore);
	    return new ResponseEntity<>(distributore, HttpStatus.CREATED);
	}
	/**
	 * Aggiorna i dati del distributore di tipicità
	 * @param id
	 * @param dtoDistributore
	 * @return
	 */
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateDistributore(@PathVariable("id") String id, @RequestBody DistributoreDiTipicitàDTO dtoDistributore) {

	    Posizione posizione = null;
	    String idPosizione = dtoDistributore.getPosizioneGeografica();

	    // Controlla se la posizione esiste
	    if (repoPosizioni.existsById(idPosizione)) {
	        posizione = repoPosizioni.findById(idPosizione).get();
	    } else {
	        return new ResponseEntity<>("Posizione non trovata", HttpStatus.NOT_FOUND);
	    }

	    // Controlla se il distributore esiste
	    if (repoDistributori.existsById(id)) {
	        DistributoreDiTipicità d = repoDistributori.findById(id).get();

	        // Aggiorna i campi
	        d.setPartitaIva(dtoDistributore.getPartitaIva());
	        d.setDenominazioneAzienda(dtoDistributore.getDenominazioneAzienda());
	        d.setTelefonoAziendale(dtoDistributore.getTelefonoAziendale());
	        d.setPosizioneGeografica(posizione);

	        // Salva il trasformatore aggiornato
	        repoDistributori.save(d);

	        return new ResponseEntity<>(d, HttpStatus.OK);
	    }

	    return new ResponseEntity<>("Trasformatore non trovato", HttpStatus.NOT_FOUND);
	}
	
	/**
	 * Elimina un distributore di tipicità dal DB
	 * @param id
	 * @return
	 */
	@DeleteMapping("/{id}")
	@Transactional  
	public ResponseEntity<Object> deleteDistributore(@PathVariable("id") String id) {
	    if (!repoDistributori.existsById(id)) {
	        return new ResponseEntity<>("Distributore non trovato", HttpStatus.NOT_FOUND);
	    }
	    repoDistributori.deleteById(id);
	    return new ResponseEntity<>("Distributore eliminato", HttpStatus.OK);
	}
}
