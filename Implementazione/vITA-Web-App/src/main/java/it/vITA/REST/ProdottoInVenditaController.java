package it.vITA.REST;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.vITA.Models.ProdottoInVendita;
import it.vITA.Repositories.ProdottiInVenditaRepository;
import it.vITA.Repositories.ProdottoRepository;

@RestController
@RequestMapping("/api/prodotti-in-vendita")
public class ProdottoInVenditaController {

    @Autowired
    private ProdottiInVenditaRepository ProdottiInVenditaRepository;

    @Autowired
    private ProdottoRepository prodottoRepository;

    /**
     * Restituisce tutti i prodotti in vendita
     * @author Francesco Valentini
     */
    @GetMapping
    public ResponseEntity<Object> getAllProdottiInVendita() {
        List<ProdottoInVendita> prodotti = new ArrayList<>();
        ProdottiInVenditaRepository.findAll().forEach(prodotti::add);
        return new ResponseEntity<>(prodotti, HttpStatus.OK);
    }

    /**
     * Restituisce un singolo prodotto in vendita tramite ID
     * @param id ID del prodotto in vendita
     * @return ResponseEntity con il prodotto o errore 404 se non trovato
     * @author Francesco Valentini
     */
    @GetMapping("/{id}")
    public ResponseEntity<Object> getProdottoInVendita(@PathVariable("id") String id) {
        Optional<ProdottoInVendita> prodotto = ProdottiInVenditaRepository.findById(id);
        if (prodotto.isPresent()) {
            return new ResponseEntity<>(prodotto.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>("Prodotto in vendita non trovato", HttpStatus.NOT_FOUND);
    }

    
}