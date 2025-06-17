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

import it.vITA.DTO.TrasformazioneDTO;
import it.vITA.Models.Certificazione;
import it.vITA.Models.Trasformatore;
import it.vITA.Models.Trasformazione;
import it.vITA.Repositories.CertificazioniRepository;
import it.vITA.Repositories.TrasformatoreRepository;
import it.vITA.Repositories.TrasformazioniRepository;

/**
 * Controller REST per operazioni CRUD su trasformazioni
 * 
 * @author Giulia Balestra
 */
@RestController
@RequestMapping("/api/trasformazione")
public class TrasformazioneController {
	
	@Autowired
	TrasformazioniRepository repoTrasformazioni;
	
	@Autowired
	TrasformatoreRepository repoTrasformatori;
	
	@Autowired
	CertificazioniRepository repoCertificazioni;
	
	private static final Logger logger = LoggerFactory.getLogger(TrasformazioneController.class);

	/**
	 * Restituisce tutte le trasformazioni
	 */
	@GetMapping
	public ResponseEntity<Object> getTrasformazioni() {
		Iterable<Trasformazione> trasformazioni = repoTrasformazioni.findAll();
		List<Trasformazione> t = new ArrayList<>();
		trasformazioni.forEach(x -> t.add(x));
		return new ResponseEntity<>(t, HttpStatus.OK);
	}

	/**
	 * Restituisce una trasformazione dato il suo id
	 * @param id
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Object> getTrasformazione(@PathVariable("id") String id) {
		if (repoTrasformazioni.existsById(id)) {
			return new ResponseEntity<>(repoTrasformazioni.findById(id).get(), HttpStatus.OK);
		}
		return new ResponseEntity<>("Trasformazione non trovata", HttpStatus.NOT_FOUND);
	}

	/**
	 * Crea una nuova trasformazione
	 * @param dtoTrasformazione
	 * @return trasformazione creata
	 */
	@PostMapping
	public ResponseEntity<Object> createTrasformazione(@RequestBody TrasformazioneDTO dto) {

	    if (dto.getIdTrasformatore() == null || !repoTrasformatori.existsById(dto.getIdTrasformatore())) {
	        return new ResponseEntity<>("Trasformatore non valido", HttpStatus.BAD_REQUEST);
	    }

	    Trasformatore trasformatore = repoTrasformatori.findById(dto.getIdTrasformatore()).get();

	    Trasformazione trasformazione = new Trasformazione();
	    trasformazione.setDenominazione(dto.getDenominazione());
	    trasformazione.setDescrizione(dto.getDescrizione());
	    trasformazione.setDataInizioFase(LocalDateTime.now());
	    trasformazione.setDataFineFase(dto.getDataFineFase());
	    trasformazione.setTrasformatore(trasformatore);
	    
	    List<Certificazione> certificazioni = new ArrayList<>();

	    if (dto.getIdCertificazione() != null) {
	        for (String id : dto.getIdCertificazione()) {
	            if (repoCertificazioni.existsById(id)) {
	                Certificazione cert = repoCertificazioni.findById(id).get();
	                certificazioni.add(cert);
	            }
	        }
	    }
	    trasformazione.setCertificazioni(certificazioni);

	    repoTrasformazioni.save(trasformazione);

	    return new ResponseEntity<>(trasformazione, HttpStatus.CREATED);
	}

	/**
	 * Aggiorna alcuni dati di una trasformazione
	 * @param id della trasformazione già esistente
	 * @param dtoTrasformazione
	 */
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateTrasformazione(@PathVariable("id") String id, @RequestBody TrasformazioneDTO dto) {
		if (!repoTrasformazioni.existsById(id)) {
			return new ResponseEntity<>("Trasformazione non trovata", HttpStatus.NOT_FOUND);
		}

		if (!repoTrasformatori.existsById(dto.getIdTrasformatore())) {
			return new ResponseEntity<>("Trasformatore non trovato", HttpStatus.NOT_FOUND);
		}

		Trasformazione t = repoTrasformazioni.findById(id).get();
		t.setDenominazione(dto.getDenominazione());
		t.setDescrizione(dto.getDescrizione());
		t.setDataFineFase(dto.getDataFineFase());
		t.setTrasformatore(repoTrasformatori.findById(dto.getIdTrasformatore()).get());

		List<Certificazione> certificazioni = new ArrayList<>();
		if (dto.getIdCertificazione() != null) {
			for (String idCert : dto.getIdCertificazione()) {
				if (repoCertificazioni.existsById(idCert)) {
					certificazioni.add(repoCertificazioni.findById(idCert).get());
				}
			}
		}
		t.setCertificazioni(certificazioni);

		repoTrasformazioni.save(t);
		return new ResponseEntity<>(t, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteTrasformazione(@PathVariable("id") String id) {
		if (repoTrasformazioni.existsById(id)) {
			repoTrasformazioni.deleteById(id);
			return new ResponseEntity<>("Trasformazione eliminata", HttpStatus.OK);
		}
		return new ResponseEntity<>("Trasformazione non trovata", HttpStatus.NOT_FOUND);
	}
}