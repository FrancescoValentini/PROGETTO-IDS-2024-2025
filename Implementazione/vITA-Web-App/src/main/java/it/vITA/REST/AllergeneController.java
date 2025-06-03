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

import it.vITA.DTO.AllergeneDTO;
import it.vITA.DTO.PosizioneDTO;
import it.vITA.Models.Allergene;
import it.vITA.Models.Posizione;
import it.vITA.Repositories.AllergeniRepository;

/**
 * Rest controller che gestisce gli allergeni
 * @author Giulia Balestra
 */
@RestController
@RequestMapping("/api/allergene")
public class AllergeneController {
	
	private static final Logger logger = LoggerFactory.getLogger(AllergeneController.class);
	
	@Autowired
	AllergeniRepository repoAllergeni;
	
	/**
	 * Restituisce tutti gli allergeni memorizzati nel db
	 */
	@GetMapping
	public ResponseEntity<Object> getAllergeni() {
		Iterable<Allergene> allergeni = repoAllergeni.findAll();
		List<Allergene> a = new ArrayList<>();
		allergeni.forEach(x -> a.add(x));
		return new ResponseEntity<>(allergeni,HttpStatus.OK);
	}
	/**
	 * Restituisce un singolo allergene dato il suo id
	 * @param id allergene
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Object> getAllergene(@PathVariable("id") String id) {
		if(repoAllergeni.existsById(id)) {
			return new ResponseEntity<>(repoAllergeni.findById(id).get(),HttpStatus.OK);
		}
		return new ResponseEntity<>("Allergene non trovato",HttpStatus.NOT_FOUND);
	}
	
	/**
	 * Aggiunge un nuovo allergene
	 * @param DTOallergene
	 */
	@PostMapping
	public ResponseEntity<Object> createAllergene(@RequestBody AllergeneDTO DTOallergene){
		Allergene aller = new Allergene(DTOallergene.getDenominazione(), DTOallergene.getDescrizione());
		repoAllergeni.save(aller);
		return new ResponseEntity<>(aller,HttpStatus.CREATED);
	}
	
	/**
	 * Aggiorna un allergene
	 * @param DTOallergene
	 * @param id
	 */
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateAllergene(@PathVariable("id") String id, @RequestBody AllergeneDTO DTOallergene){
		if(repoAllergeni.existsById(id)) {
			Allergene a = repoAllergeni.findById(id).get();
			a.setDenominazione(DTOallergene.getDenominazione());
			a.setDescrizione(DTOallergene.getDescrizione());
			repoAllergeni.save(a);
			return new ResponseEntity<>(a ,HttpStatus.OK);
		}
		return new ResponseEntity<>("Allergene non trovato",HttpStatus.NOT_FOUND);
	}
	/**
	 * Elimina un allergene
	 * @param id allergene
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteAllergene(@PathVariable("id") String id) {
		if(repoAllergeni.existsById(id)) {
			repoAllergeni.deleteById(id);
			return new ResponseEntity<>("Allergene eliminato",HttpStatus.OK);
		}
		return new ResponseEntity<>("Allergene non trovato",HttpStatus.NOT_FOUND);
	}
	
}
