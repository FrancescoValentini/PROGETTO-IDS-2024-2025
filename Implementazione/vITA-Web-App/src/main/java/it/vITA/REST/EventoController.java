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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.vITA.DTO.EventoDTO;
import it.vITA.DTO.PosizioneDTO;
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
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getEvento(@PathVariable("id") String id){
		if(repoEventi.existsById(id)) {
			return new ResponseEntity<>(repoEventi.findById(id).get(),HttpStatus.OK);
		}
		return new ResponseEntity<>("Evento non trovato",HttpStatus.NOT_FOUND);
	}
	
	/**
	 * Crea un nuovo evento
	 * @param dtoEvento
	 * @return evento creato
	 */
	@PostMapping
	public ResponseEntity<Object> createPosizione(@RequestBody EventoDTO dtoEvento){
		
		Posizione pEvento = null;
		String idPosizione = dtoEvento.getPosizioneGeografica();
		
		if(repoPosizioni.existsById(idPosizione)) {
			pEvento = repoPosizioni.findById(idPosizione).get();
		}else {
			return new ResponseEntity<>("Posizione non trovata",HttpStatus.NOT_FOUND);
		}
		
		Evento e = new Evento(
					dtoEvento.getDataEOraEvento(),
					dtoEvento.getTitolo(),
					dtoEvento.getDescrizione(),
					dtoEvento.getPrezzoIngresso(),
					dtoEvento.getPosti(),
					dtoEvento.getTipologiaEvento(),
					pEvento
				);
		
		repoEventi.save(e);
		return new ResponseEntity<>(e,HttpStatus.CREATED);
	}
}
