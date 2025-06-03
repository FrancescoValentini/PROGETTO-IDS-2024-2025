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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
		c.forEach(x -> c.add(x));
		return new ResponseEntity<>(c ,HttpStatus.OK);
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
	
	
}
