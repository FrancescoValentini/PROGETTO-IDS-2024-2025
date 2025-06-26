package it.vITA.REST;

import it.vITA.DTO.AcquistoDTO;
import it.vITA.Models.ProdottoInVendita;
import it.vITA.Repositories.ProdottiInVenditaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Controller per il marketplace: restituisce solo i prodotti in vendita approvati
 */
@RestController
@RequestMapping("/api/marketplace")
public class MarketplaceController {

    @Autowired
    private ProdottiInVenditaRepository prodottiInVenditaRepository;

    /**
     * Restituisce tutti i prodotti in vendita il cui prodotto è approvato
     */
    
    @PostMapping("/compra/{id}")
	public ResponseEntity<Object> compraProdotto(@PathVariable String id, @RequestBody AcquistoDTO acquisto) {
	    int qtaRichiesta = acquisto.getQta();
	    
	    // Controllo quantità negativa
	    if (qtaRichiesta < 1) {
	        return new ResponseEntity<>("Quantità negativa non consentita", HttpStatus.BAD_REQUEST);
	    }

	    if (!prodottiInVenditaRepository.existsById(id)) {
	        return new ResponseEntity<>("Prodotto non trovato", HttpStatus.NOT_FOUND);
	    }

	    ProdottoInVendita prodotto = prodottiInVenditaRepository.findById(id).get();

	    if (qtaRichiesta <= 0) {
	        return new ResponseEntity<>("Quantità richiesta non valida", HttpStatus.BAD_REQUEST);
	    }

	    if (prodotto.getQta() < qtaRichiesta) {
	        return new ResponseEntity<>("Quantità non disponibile", HttpStatus.BAD_REQUEST);
	    }

	    prodotto.setQta(prodotto.getQta() - qtaRichiesta);
	    prodottiInVenditaRepository.save(prodotto);

	    double prezzoTotale = qtaRichiesta * prodotto.getPrezzo();

	    return new ResponseEntity<>("Acquisto completato. Prezzo totale: €" + prezzoTotale, HttpStatus.OK);
	}
    
    @GetMapping
    public ResponseEntity<List<ProdottoInVendita>> getProdottiInVenditaApprovati() {
        List<ProdottoInVendita> prodottiApprovati = ((List<ProdottoInVendita>) prodottiInVenditaRepository.findAll())
                .stream()
                .collect(Collectors.toList());

        return ResponseEntity.ok(prodottiApprovati);
    }
}
