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
import it.vITA.DataExporter.CSVExportable;
import it.vITA.DataExporter.CSVExporter;
import it.vITA.Models.Evento;
import it.vITA.Models.Invito;
import it.vITA.Models.UtenteRegistrato;
import it.vITA.Repositories.EventiRepository;
import it.vITA.Repositories.InvitiRepository;
import it.vITA.Repositories.UtenteRegistratoRepository;
import jakarta.transaction.Transactional;

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

	@Autowired
	EventiRepository repoEventi;

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
	 * Restituisce tutti gli inviti in formato CSV
	 * 
	 * @return
	 * @author Giulia Balestra
	 */
	@GetMapping("/csv")
	public ResponseEntity<Object> csvExport(){
		CSVExporter exportVisitor = new CSVExporter();

		List<CSVExportable> inviti = new ArrayList<>();
		repoInviti.findAll().forEach(i -> inviti.add(i));

		return new ResponseEntity<>(exportVisitor.export(inviti),HttpStatus.OK); 

	}

	/**
	 * Crea un nuovo invito
	 * @param InvitoDTO
	 * @return invito creato
	 */
	@PostMapping
	public ResponseEntity<Object> createInvito(@RequestBody InvitoDTO dtoInvito){

		Invito i = null;

		boolean utenteExist = repoUtenti.existsById(dtoInvito.getIdUtenteRegistrato());
		boolean eventoExist = repoEventi.existsById(dtoInvito.getIdEvento());

		if(utenteExist && eventoExist ) {
			i = new Invito(
					repoUtenti.findById(dtoInvito.getIdUtenteRegistrato()).get(),
					repoEventi.findById(dtoInvito.getIdEvento()).get()
					);
			repoInviti.save(i);
			return new ResponseEntity<>(i,HttpStatus.CREATED);
		}

		if(!utenteExist) return new ResponseEntity<>("Utente non trovato",HttpStatus.NOT_FOUND);
		else return new ResponseEntity<>("Evento non trovato",HttpStatus.NOT_FOUND);

	}

	/**
	 * Aggiorna i dati di un invitp
	 * @param id dell'invito già esistente
	 * @param dtoInvito
	 */
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateInvito(@PathVariable("id") String id, @RequestBody InvitoDTO dtoInvito){
		// 1) Verifica se l'invito da modificare esiste
		if (!repoInviti.existsById(id)) return new ResponseEntity<>("Invito non trovato", HttpStatus.NOT_FOUND);

		//2) Verifica se esistono gli eventi e l'utente specificati
		boolean utenteExist = repoUtenti.existsById(dtoInvito.getIdUtenteRegistrato());
		boolean eventoExist = repoEventi.existsById(dtoInvito.getIdEvento());

		Invito i = null;
		Evento e = null;
		UtenteRegistrato u = null;
		
		//3) Se evento o utente non esistono da errore altrimenti ottiene i loro oggetti
		if(eventoExist) e = repoEventi.findById(dtoInvito.getIdEvento()).get();
		else return new ResponseEntity<>("Evento non trovato", HttpStatus.NOT_FOUND);

		if(utenteExist) u = repoUtenti.findById(dtoInvito.getIdUtenteRegistrato()).get();
		else return new ResponseEntity<>("Utente non trovato", HttpStatus.NOT_FOUND);

		// Aggiorna l'invito

		i = repoInviti.findById(id).get();
		i.setEvento(e);
		i.setInvitato(u);
		repoInviti.save(i);
		return new ResponseEntity<>(i, HttpStatus.CREATED);

	}



	/**
	 * Elimina un invito dato il suo id
	 * @param id dell'invito
	 */
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<Object> deleteInvito(@PathVariable("id") String id){
		if(repoInviti.existsById(id)) {
			repoInviti.deleteInvitoById(id);
			return new ResponseEntity<>("Invito eliminato",HttpStatus.OK);
		}
		return new ResponseEntity<>("Invito non trovato",HttpStatus.NOT_FOUND);
	}

}
