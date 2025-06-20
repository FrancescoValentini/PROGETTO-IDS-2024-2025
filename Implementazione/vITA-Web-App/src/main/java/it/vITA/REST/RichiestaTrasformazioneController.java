package it.vITA.REST;

import it.vITA.RichiesteBuilder.RichiestaTrasformazione;
import it.vITA.RichiesteBuilder.RichiestaTrasformazioneBuilder;
import it.vITA.DTO.RichiestaTrasformazioneDTO;
import it.vITA.Models.Trasformazione;
import it.vITA.Models.UtenteRegistrato;
import it.vITA.Repositories.RichiestaTrasformazioneRepository;
import it.vITA.Repositories.TrasformazioniRepository;
import it.vITA.Repositories.UtenteRegistratoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/richieste-trasformazione")
public class RichiestaTrasformazioneController {

	@Autowired
	RichiestaTrasformazioneRepository repoRichiesta;
	@Autowired
	UtenteRegistratoRepository repoUtente;
	@Autowired
	TrasformazioniRepository repoTrasformazione;

	/**
	 * Restituisce tutti gli allergeni memorizzati nel db
	 */
	@GetMapping
	public ResponseEntity<Object> getRichieste() {
		Iterable<RichiestaTrasformazione> richieste = repoRichiesta.findAll();
		List<RichiestaTrasformazione> a = new ArrayList<>();
		richieste.forEach(x -> a.add(x));
		return new ResponseEntity<>(richieste,HttpStatus.OK);
	}

    @GetMapping("/{id}")
    public ResponseEntity<RichiestaTrasformazione> getRichiestaById(@PathVariable String id) {
        Optional<RichiestaTrasformazione> richiesta = repoRichiesta.findById(id);
        return richiesta.map(ResponseEntity::ok)
                        .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Object> createRichiesta(@RequestBody RichiestaTrasformazioneDTO dtoTrasformazione) {
    	
    	if (!repoUtente.existsById(dtoTrasformazione.getCreatoreId())) {
            return new ResponseEntity<>("Creatore non trovato", HttpStatus.NOT_FOUND);
        }
        if (!repoRichiesta.existsById(dtoTrasformazione.getTrasformazioneId())) {
            return new ResponseEntity<>("Prodotto non trovato", HttpStatus.NOT_FOUND);
        }
        
        UtenteRegistrato creatore = repoUtente.findById(dtoTrasformazione.getCreatoreId()).get();
        Trasformazione trasformazione = repoTrasformazione.findById(dtoTrasformazione.getTrasformazioneId()).get();

        RichiestaTrasformazioneBuilder builder = new RichiestaTrasformazioneBuilder();
        builder.setApprovato(false);
        builder.setCreatore(creatore);
        builder.setElemento(trasformazione);
        builder.setCommento(dtoTrasformazione.getCommentoCuratore());

        RichiestaTrasformazione richiesta = builder.build();

        repoRichiesta.save(richiesta);
        return new ResponseEntity<>(richiesta, HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
	public ResponseEntity<Object> updateRichiesta(@PathVariable("id") String id, @RequestBody RichiestaTrasformazioneDTO dtoTrasformazione){
		if(repoRichiesta.existsById(id)) {
			RichiestaTrasformazione ric = repoRichiesta.findById(id).get();
			
			ric.setCommentoCuratore(dtoCuratore.getCommentoCuratore());
			ric.setApprovato(dtoCuratore.isApprovato());
			ric.setTipoRichiesta(dtoCuratore.getTipoRichiesta());
			
			repoRichiesta.save(ric);
			return new ResponseEntity<>(ric ,HttpStatus.OK);
		}
		return new ResponseEntity<>("Curatore non trovato",HttpStatus.NOT_FOUND);
	}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRichiesta(@PathVariable String id) {
        if (repoRichiesta.existsById(id)) {
        	repoRichiesta.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

