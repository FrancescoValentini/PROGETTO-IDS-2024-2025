package it.vITA.REST;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

import it.vITA.DTO.ProdottoDTO;
import it.vITA.Models.Prodotto;
import it.vITA.Models.Produttore;
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
    
    
    /**
     * Crea un nuovo prodotto
     */
    @PostMapping
    public ResponseEntity<Object> createProdotto(@RequestBody ProdottoDTO dto) {
        if (dto.getProduttore() == null || !repoProduttori.existsById(dto.getProduttore())) {
            return new ResponseEntity<>("Produttore non valido", HttpStatus.BAD_REQUEST);
        }

        Produttore produttore = (Produttore) repoProduttori.findById(dto.getProduttore()).get();

        Prodotto prodotto = new Prodotto(
            dto.getDenominazione(),
            dto.getDescrizione(),
            dto.getDataEoraProduzione(),
            dto.getDataEoraScadenza(),
            produttore
        );

        repoProdotti.save(prodotto);
        return new ResponseEntity<>(prodotto, HttpStatus.CREATED);
    }
    
    /**
     * Aggiorna un prodotto esistente
     */
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateProdotto(@PathVariable("id") String id, @RequestBody ProdottoDTO dto) {
        Optional<Prodotto> optionalProdotto = repoProdotti.findById(id);

        if (!optionalProdotto.isPresent()) {
            return new ResponseEntity<>("Prodotto non trovato", HttpStatus.NOT_FOUND);
        }

        Prodotto prodotto = optionalProdotto.get();

        prodotto.setDenominazione(dto.getDenominazione());
        prodotto.setDescrizione(dto.getDescrizione());
        prodotto.setDataEoraProduzione(dto.getDataEoraProduzione());
        prodotto.setDataEoraScadenza(dto.getDataEoraScadenza());

        if (dto.getProduttore() != null && repoProduttori.existsById(dto.getProduttore())) {
            prodotto.setProduttore((Produttore) repoProduttori.findById(dto.getProduttore()).get());
        }

        repoProdotti.save(prodotto);
        return new ResponseEntity<>(prodotto, HttpStatus.OK);
    }

    /**
     * Elimina un prodotto per ID
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProdotto(@PathVariable("id") String id) {
        if (!repoProdotti.existsById(id)) {
            return new ResponseEntity<>("Prodotto non trovato", HttpStatus.NOT_FOUND);
        }
        repoProdotti.deleteById(id);
        return new ResponseEntity<>("Prodotto eliminato", HttpStatus.OK);
    }
    


}