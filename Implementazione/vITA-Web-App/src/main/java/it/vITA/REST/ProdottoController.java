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

import it.vITA.Models.Prodotto;
import it.vITA.Repositories.ProdottoRepository;
import it.vITA.Repositories.UtenteRegistratoRepository;

/**
 * Rest controller per i prodotti
 * @author Francesco Valentini
 */
@RestController
@RequestMapping("/api/prodotto")
public class ProdottoController {
        
    @Autowired
    private ProdottoRepository repoProdotti;

    @Autowired
    private UtenteRegistratoRepository repoProduttori;

    /**
     * Restituisce tutti i prodotti
     * @author Francesco Valentini
     */
    @GetMapping
    public ResponseEntity<Object> getAllProdotti() {
        List<Prodotto> prodotti = new ArrayList<>();
        repoProdotti.findAll().forEach(prodotti::add);
        return new ResponseEntity<>(prodotti, HttpStatus.OK);
    }

    /**
     * Restituisce un singolo prodotto per ID
     * @author Francesco Valentini
     */
    @GetMapping("/{id}")
    public ResponseEntity<Object> getProdottoById(@PathVariable("id") String id) {
        Optional<Prodotto> prodotto = repoProdotti.findById(id);
        if (prodotto.isPresent()) {
            return new ResponseEntity<>(prodotto.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>("Prodotto non trovato", HttpStatus.NOT_FOUND);
    }


}