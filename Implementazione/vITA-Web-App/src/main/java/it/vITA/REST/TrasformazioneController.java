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
import it.vITA.Models.Trasformazione;
import it.vITA.Repositories.CertificazioniRepository;
import it.vITA.Repositories.TrasformatoreRepository;
import it.vITA.Repositories.TrasformazioniRepository;



/**
 * Controller REST per operazioni su trasformazioni
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
	 * Restituisce tutte le trasformazioni memorizzati nel db
	 */
	@GetMapping
	public ResponseEntity<Object> getTrasformazioni() {
		Iterable<Trasformazione> trasformazioni = repoTrasformazioni.findAll();
		List<Trasformazione> t = new ArrayList<>();
		trasformazioni.forEach(x -> t.add(x));
		return new ResponseEntity<>(trasformazioni,HttpStatus.OK);
	}
	/**
	 * Restituisce una singola trasformazione dato il suo id
	 * @param id allergene
	 * @param id trasformazione
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Object> getTrasformazione(@PathVariable("id") String id) {
		if(repoTrasformazioni.existsById(id)) {
			return new ResponseEntity<>(repoTrasformazioni.findById(id).get(),HttpStatus.OK);
		}
		return new ResponseEntity<>("Trasformazione non trovata",HttpStatus.NOT_FOUND);
	}
	
	/**
	 * Crea una nuova trasformazione
	 * @param TrasformazioneDTO
	 * @return trasformazione aggiunta
	 */
	
	@PostMapping
	public ResponseEntity<Object> createTrasformazione(@RequestBody TrasformazioneDTO dto) {

	    Trasformazione t = null;

	    boolean trasformatoreExist = repoTrasformatori.existsById(dto.getIdTrasformatore());

	    if (trasformatoreExist) {
	        t = new Trasformazione();
	        t.setDenominazione(dto.getDenominazione());
	        t.setDescrizione(dto.getDescrizione());
	        t.setDataInizioFase(LocalDateTime.now());
	        t.setDataFineFase(dto.getDataFineFase());
	        t.setTrasformatore(repoTrasformatori.findById(dto.getIdTrasformatore()).get());
	        t.setCertificazioni(dto.getCertificazioni());

	        repoTrasformazioni.save(t);
	        return new ResponseEntity<>(t, HttpStatus.CREATED);
	    if (!trasformatoreExist) {
	        return new ResponseEntity<>("Trasformatore non trovato", HttpStatus.NOT_FOUND);
	    }

	    t = new Trasformazione();
	    t.setDenominazione(dto.getDenominazione());
	    t.setDescrizione(dto.getDescrizione());
	    t.setDataInizioFase(LocalDateTime.now());
	    t.setDataFineFase(dto.getDataFineFase());
	    t.setTrasformatore(repoTrasformatori.findById(dto.getIdTrasformatore()).get());

	    ArrayList<Certificazione> certificazioni = new ArrayList<>();
	    for (String idCert : dto.getIdCertificazioni()) {
	        if (repoCertificazioni.existsById(idCert)) {
	            certificazioni.add(repoCertificazioni.findById(idCert).get());
	        }
	    }
	    t.setCertificazioni(certificazioni);

	    repoTrasformazioni.save(t);
	    return new ResponseEntity<>(t, HttpStatus.CREATED);
	}
	

	/**
	 * Aggiorna i dati di una trasformazione
	 * @param id trasformazione
    @Autowired
    TrasformazioniRepository repoTrasformazioni;
    @Autowired
    TrasformatoreRepository repoTrasformatori;
    @Autowired
    CertificazioniRepository repoCertificazioni;
    
    private static final Logger logger = LoggerFactory.getLogger(InvitoController.class);


    @GetMapping
    public ResponseEntity<Object> getTrasformazioni() {
        Iterable<Trasformazione> trasformazioni = repoTrasformazioni.findAll();
        ArrayList<Trasformazione> t = new ArrayList<>();
        trasformazioni.forEach(x -> t.add(x));
        return new ResponseEntity<>(t, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getTrasformazione(@PathVariable("id") String id) {
        if (repoTrasformazioni.existsById(id)) {
            return new ResponseEntity<>(repoTrasformazioni.findById(id).get(), HttpStatus.OK);
        }
        return new ResponseEntity<>("Trasformazione non trovata", HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Object> createTrasformazione(@RequestBody TrasformazioneDTO dto) {
    	//1) se il trasformatore non esiste --> NotFound
        if (!repoTrasformatori.existsById(dto.getIdTrasformatore())) {
            return new ResponseEntity<>("Trasformatore non trovato", HttpStatus.NOT_FOUND);
        }
        //2) crea una nuova trasformazione
        Trasformazione t = new Trasformazione();
        t.setDenominazione(dto.getDenominazione());
        t.setDescrizione(dto.getDescrizione());
        t.setDataInizioFase(LocalDateTime.now());
        t.setDataFineFase(dto.getDataFineFase());
        t.setTrasformatore(repoTrasformatori.findById(dto.getIdTrasformatore()).get());
        
        ArrayList<Certificazione> certificazioni = new ArrayList<>();
        if (dto.getIdCertificazioni() != null) {
            for (String idCert : dto.getIdCertificazioni()) {
                if (repoCertificazioni.existsById(idCert)) {
                    certificazioni.add(repoCertificazioni.findById(idCert).get());
                }
            }
        }
        t.setCertificazioni(certificazioni);

        repoTrasformazioni.save(t);
        return new ResponseEntity<>(t, HttpStatus.CREATED);
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

	    return new ResponseEntity<>("Trasformatore non trovato", HttpStatus.NOT_FOUND);
	    Trasformazione t = repoTrasformazioni.findById(id).get();

	    t.setDenominazione(dto.getDenominazione());
	    t.setDescrizione(dto.getDescrizione());
	    t.setDataFineFase(dto.getDataFineFase());
	    t.setTrasformatore(repoTrasformatori.findById(dto.getIdTrasformatore()).get());

	    // NON modifico certificazioni!

	    repoTrasformazioni.save(t);
	    return new ResponseEntity<>(t, HttpStatus.OK);
	}

	/**
	 * Elimina una trasformazione
	 * @param id della trasformazione già esistente
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateTrasformazione(@PathVariable("id") String id, @RequestBody TrasformazioneDTO dto) {
    	
    	//1) Se la trasformazione non esiste --> NotFound
        if (!repoTrasformazioni.existsById(id)) {
            return new ResponseEntity<>("Trasformazione non trovata", HttpStatus.NOT_FOUND);
        }
        
        //2) Se il trasformatore non esiste --> NotFound
        if (!repoTrasformatori.existsById(dto.getIdTrasformatore())) {
            return new ResponseEntity<>("Trasformatore non trovato", HttpStatus.NOT_FOUND);
        }

        Trasformazione t = repoTrasformazioni.findById(id).get();

        t.setDenominazione(dto.getDenominazione());
        t.setDescrizione(dto.getDescrizione());
        t.setDataFineFase(dto.getDataFineFase());
        t.setTrasformatore(repoTrasformatori.findById(dto.getIdTrasformatore()).get());

        // Non modifico certificazioni!

        repoTrasformazioni.save(t);
        return new ResponseEntity<>(t, HttpStatus.OK);
    }
    /**
	 * Elimina trasformazione
	 * @param id della trasformazione da eliminare
	 * @param dtoTrasformazione
	 */
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteTrasformazione(@PathVariable("id") String id) {
	    if (!repoTrasformazioni.existsById(id)) {
	        return new ResponseEntity<>("Trasformazione non trovata", HttpStatus.NOT_FOUND);
	    }
	    repoTrasformazioni.deleteById(id);
	    return new ResponseEntity<>("Trasformazione eliminata", HttpStatus.OK);
	}

	
	
	
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTrasformazione(@PathVariable("id") String id) {
        if (!repoTrasformazioni.existsById(id)) {
            return new ResponseEntity<>("Trasformazione non trovata", HttpStatus.NOT_FOUND);
        }
        repoTrasformazioni.deleteById(id);
        return new ResponseEntity<>("Trasformazione eliminata", HttpStatus.OK);
    }
}
