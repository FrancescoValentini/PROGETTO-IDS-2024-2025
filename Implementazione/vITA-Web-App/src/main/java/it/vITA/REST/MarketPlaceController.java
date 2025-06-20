package it.vITA.REST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.vITA.DTO.AcquistoDTO;
import it.vITA.Models.ProdottoInVendita;
import it.vITA.Repositories.ProdottiInVenditaRepository;

@RestController
@RequestMapping("api/marketplace")
public class MarketPlaceController {
	
	@Autowired
    ProdottiInVenditaRepository prodottoRepo;
	
	@PostMapping("/compra/{id}")
	public ResponseEntity<Object> compraProdotto(@PathVariable String id, @RequestBody AcquistoDTO acquisto) {
	    int qtaRichiesta = acquisto.getQta();

	    if (!prodottoRepo.existsById(id)) {
	        return new ResponseEntity<>("Prodotto non trovato", HttpStatus.NOT_FOUND);
	    }

	    ProdottoInVendita prodotto = prodottoRepo.findById(id).get();

	    if (qtaRichiesta <= 0) {
	        return new ResponseEntity<>("Quantità richiesta non valida", HttpStatus.BAD_REQUEST);
	    }

	    if (prodotto.getQta() < qtaRichiesta) {
	        return new ResponseEntity<>("Quantità non disponibile", HttpStatus.BAD_REQUEST);
	    }

	    prodotto.setQta(prodotto.getQta() - qtaRichiesta);
	    prodottoRepo.save(prodotto);

	    double prezzoTotale = qtaRichiesta * prodotto.getPrezzo();

	    return new ResponseEntity<>("Acquisto completato. Prezzo totale: €" + prezzoTotale, HttpStatus.OK);
	}
}
