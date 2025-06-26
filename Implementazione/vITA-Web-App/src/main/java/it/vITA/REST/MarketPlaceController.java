package it.vITA.REST;

import it.vITA.Models.ProdottoInVendita;
import it.vITA.Repositories.ProdottiInVenditaRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    @GetMapping
    public ResponseEntity<List<ProdottoInVendita>> getProdottiInVenditaApprovati() {
        List<ProdottoInVendita> prodottiApprovati = ((List<ProdottoInVendita>) prodottiInVenditaRepository.findAll())
                .stream()
                .collect(Collectors.toList());

        return ResponseEntity.ok(prodottiApprovati);
    }
}
