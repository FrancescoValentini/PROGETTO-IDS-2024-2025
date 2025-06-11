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
import it.vITA.DataExporter.CSVExportable;
import it.vITA.DataExporter.CSVExporter;
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
	 * Restituisce tutti gli eventi in formato CSV
	 * 
	 * @return
	 * @author Francesco Valentini
	 */
	@GetMapping("/csv")
	public ResponseEntity<Object> csvExport(){
		CSVExporter exportVisitor = new CSVExporter();
		
		List<CSVExportable> eventi = new ArrayList<>();
		repoEventi.findAll().forEach(e -> eventi.add(e));
		
		return new ResponseEntity<>(exportVisitor.export(eventi),HttpStatus.OK); 
		
	}
	
	/**
	 * Crea un nuovo evento
	 * @param dtoEvento
	 * @return evento creato
	 */
	@PostMapping
	public ResponseEntity<Object> createEvento(@RequestBody EventoDTO dtoEvento){
		
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
	
	/**
	 * Aggiorna i dati di un evento
	 * @param id dell'evento già esistente
	 * @param dtoEvento
	 */
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateEvento(@PathVariable("id") String id, @RequestBody EventoDTO dtoEvento){
		
		Posizione pEvento = null;
		String idPosizione = dtoEvento.getPosizioneGeografica();
		
		if(repoPosizioni.existsById(idPosizione)) {
			pEvento = repoPosizioni.findById(idPosizione).get();
		}else {
			return new ResponseEntity<>("Posizione non trovata",HttpStatus.NOT_FOUND);
		}
		
		
		if(repoEventi.existsById(id)) {
			Evento e = repoEventi.findById(id).get();
			e.setDataEOraEvento(dtoEvento.getDataEOraEvento());
			e.setTitolo(dtoEvento.getTitolo());
			e.setDescrizione(dtoEvento.getDescrizione());
			e.setPrezzoIngresso(dtoEvento.getPrezzoIngresso());
			e.setPosti(dtoEvento.getPosti());
			e.setPosizioneGeografica(pEvento);
			
			repoEventi.save(e);
			return new ResponseEntity<>(e,HttpStatus.OK);
		}
		return new ResponseEntity<>("Evento non trovato",HttpStatus.NOT_FOUND);
	}
	
	
	
	/**
	 * Elimina un evento dato il suo id
	 * @param id dell'evento
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteEvento(@PathVariable("id") String id){
		if(repoEventi.existsById(id)) {
			repoEventi.deleteById(id);
			return new ResponseEntity<>("Evento eliminato",HttpStatus.OK);
		}
		return new ResponseEntity<>("Evento non trovato",HttpStatus.NOT_FOUND);
	}
}
