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

import it.vITA.DTO.EventoDTO;
import it.vITA.DTO.MetodologiaColtivazioneDTO;
import it.vITA.DTO.PosizioneDTO;
import it.vITA.Models.Evento;
import it.vITA.Models.MetodologiaColtivazione;
import it.vITA.Models.Posizione;
import it.vITA.Repositories.MetodologieColtivazioneRepository;
/**
 * Rest controller REST per operazioni CRUD su metodologie di coltivazione
 * 
 * @author Giulia Balestra
 */

@RestController
@RequestMapping("/api/metodologia")
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
	
	/**
	 * Restituisce una singola metodologia dato il suo id
	 * @param id della metodologia
	 * @author Giulia Balestra
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Object> getMetodologia(@PathVariable("id") String id) {
		if(repoMetodologie.existsById(id)) {
			return new ResponseEntity<>(repoMetodologie.findById(id).get(),HttpStatus.OK);
		}
		return new ResponseEntity<>("Metodologia non trovata",HttpStatus.NOT_FOUND);
	}
	
	/**
	 * Aggiunge una nuova metodologia
	 * @param DTOMetodologiaColtivazioneDTO
	 * @author Giulia Balestra
	 */
	@PostMapping
	public ResponseEntity<Object> createMetodologia(@RequestBody MetodologiaColtivazioneDTO dtometodologia){
		MetodologiaColtivazione met = new MetodologiaColtivazione(dtometodologia.getDenominazione(), 
				dtometodologia.getDescrizione());
		repoMetodologie.save(met);
		return new ResponseEntity<>(met,HttpStatus.CREATED);
	}
	
	/**
	 * Aggiorna i dati di una metodologia
	 * @param id della metodologia di coltivazione già esistente
	 * @param dtoMetodologia
	 */
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateMetodologia(@PathVariable("id") String id, @RequestBody MetodologiaColtivazioneDTO dtoMetodologia){
		
		if(repoMetodologie.existsById(id)) {
			MetodologiaColtivazione metCol = repoMetodologie.findById(id).get();
			metCol.setDenominazione(dtoMetodologia.getDenominazione());
			metCol.setDescrizione(dtoMetodologia.getDescrizione());
			
			repoMetodologie.save(metCol);
			
			return new ResponseEntity<>(metCol ,HttpStatus.OK);
		}
		return new ResponseEntity<>("Metodologia non trovata",HttpStatus.NOT_FOUND);
	}
	
	/**
	 * Elimina una metodologia
	 * @param id della metodologia
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteMetodologia(@PathVariable("id") String id) {
		if(repoMetodologie.existsById(id)) {
			repoMetodologie.deleteById(id);
			return new ResponseEntity<>("Metodologia eliminata",HttpStatus.OK);
		}
		return new ResponseEntity<>("Metodologia non trovata",HttpStatus.NOT_FOUND);
	}
}
