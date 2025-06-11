package it.vITA.REST;

import java.time.LocalDateTime;
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

import it.vITA.DTO.CertificazioneDTO;
import it.vITA.Models.Certificazione;
import it.vITA.Repositories.CertificazioniRepository;


/**
 * Controller REST per operazioni CRUD su certificazioni
 * 
 * @author Giulia Balestra
 */
@RestController
@RequestMapping("/api/certificazione")
public class CertificazioneController {
	
	@Autowired
	CertificazioniRepository repoCertificazioni;
	
	
	private static final Logger logger = LoggerFactory.getLogger(CertificazioneController.class);
	

	/**
	 * Restituisce tutte le certificazioni
	 */
	@GetMapping
	public ResponseEntity<Object> getCertificazioni(){
		Iterable<Certificazione> certificazioni = repoCertificazioni.findAll();
		List<Certificazione> c = new ArrayList<>();
		certificazioni.forEach(x -> c.add(x));
		return new ResponseEntity<>(certificazioni ,HttpStatus.OK);
	}
	/**
	 * Restituisce una certificazione dato il suo id
	 * @param id
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Object> getCertificazione(@PathVariable("id") String id){
		if(repoCertificazioni.existsById(id)) {
			return new ResponseEntity<>(repoCertificazioni.findById(id).get(),HttpStatus.OK);
		}
		return new ResponseEntity<>("Certificazione non trovata",HttpStatus.NOT_FOUND);
	}
	/**
	 * Crea una nuova certificazione
	 * @param dtoCertificazione
	 * @return certificazione creata
	 */
	@PostMapping
	public ResponseEntity<Object> createCertificazione(@RequestBody CertificazioneDTO dtoCertificazione){
		Certificazione cert = new Certificazione(
				dtoCertificazione.getDenominazione(),
				dtoCertificazione.getDescrizione(),
				dtoCertificazione.getDenominazioneEnteCertificatore(),
				LocalDateTime.now(),
				dtoCertificazione.getDataScadenza()
				);
		
		repoCertificazioni.save(cert);
		return new ResponseEntity<>(cert,HttpStatus.CREATED);
	}
	/**
	 * Aggiorna alcuni dati di una certificazione
	 * @param id della certificazione già esistente
	 * @param dtoCertificazione
	 */
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateCertificazione(@PathVariable("id") String id,
			@RequestBody CertificazioneDTO dtoCertificazione){
		
		
		
		if(repoCertificazioni.existsById(id)) {
			Certificazione c = repoCertificazioni.findById(id).get();
			c.setDescrizione(dtoCertificazione.getDescrizione());
			c.setDenominazioneEnteCertificatore(dtoCertificazione.getDenominazioneEnteCertificatore());
			c.setDataScadenza(dtoCertificazione.getDataScadenza());
			
			repoCertificazioni.save(c);
			return new ResponseEntity<>(c,HttpStatus.OK);
		}
		return new ResponseEntity<>("Certificazione non trovata",HttpStatus.NOT_FOUND);
	}
	/**
	 * Elimina una certificazione
	 * @param id della certificazione
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteCertificazione(@PathVariable("id") String id) {
		if(repoCertificazioni.existsById(id)) {
			repoCertificazioni.deleteById(id);
			return new ResponseEntity<>("Certificazione eliminata",HttpStatus.OK);
		}
		return new ResponseEntity<>("Certificazione non trovata",HttpStatus.NOT_FOUND);
	}
	
		
	
	
}
