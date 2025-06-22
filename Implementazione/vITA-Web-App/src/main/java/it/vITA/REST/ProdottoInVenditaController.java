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

import it.vITA.DTO.ProdottoInVenditaDTO;
import it.vITA.Models.Prodotto;
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
    
    /**
     * Crea un nuovo prodotto in vendita a partire dal DTO
     * @param dto DTO contenente i dati del prodotto in vendita
     * @return ResponseEntity con il prodotto creato o errore se il prodotto base non esiste
     * @author Francesco Valentini
     */
    @PostMapping
    public ResponseEntity<Object> createProdottoInVendita(@RequestBody ProdottoInVenditaDTO dto) {
        Optional<Prodotto> prodottoOpt = prodottoRepository.findById(dto.getIdProdotto());
        if (prodottoOpt.isEmpty()) {
            return new ResponseEntity<>("Prodotto base non trovato", HttpStatus.BAD_REQUEST);
        }

        ProdottoInVendita piv = new ProdottoInVendita(
        		dto.getQta(), 
        		dto.getPrezzo(), 
        		dto.getDescrizione(),
        		prodottoOpt.get()
        );
        
        ProdottiInVenditaRepository.save(piv);

        return new ResponseEntity<>(piv, HttpStatus.CREATED);
    }

    /**
     * Aggiorna un prodotto in vendita esistente
     * @param id ID del prodotto in vendita da aggiornare
     * @param dto DTO contenente i nuovi dati
     * @return ResponseEntity con il prodotto aggiornato o errore se non trovato o prodotto base assente
     * @author Francesco Valentini
     */
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateProdottoInVendita(@PathVariable("id") String id, @RequestBody ProdottoInVenditaDTO dto) {
        Optional<ProdottoInVendita> esistenteOpt = ProdottiInVenditaRepository.findById(id);
        if (esistenteOpt.isEmpty()) {
            return new ResponseEntity<>("Prodotto in vendita non trovato", HttpStatus.NOT_FOUND);
        }

        Optional<Prodotto> prodottoOpt = prodottoRepository.findById(dto.getIdProdotto());
        if (prodottoOpt.isEmpty()) {
            return new ResponseEntity<>("Prodotto base non trovato", HttpStatus.BAD_REQUEST);
        }

        ProdottoInVendita esistente = esistenteOpt.get();
        esistente.setQta(dto.getQta());
        esistente.setPrezzo(dto.getPrezzo());
        esistente.setProdotto(prodottoOpt.get());
        esistente.setDescrizione(dto.getDescrizione());

        ProdottiInVenditaRepository.save(esistente);
        return new ResponseEntity<>(esistente, HttpStatus.OK);
    }

    /**
     * Elimina un prodotto in vendita dato il suo ID
     * @param id ID del prodotto da eliminare
     * @return Messaggio di conferma o errore 404 se non trovato
     * @author Francesco Valentini
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProdottoInVendita(@PathVariable("id") String id) {
        if (!ProdottiInVenditaRepository.existsById(id)) {
            return new ResponseEntity<>("Prodotto in vendita non trovato", HttpStatus.NOT_FOUND);
        }

        ProdottiInVenditaRepository.deleteById(id);
        return new ResponseEntity<>("Prodotto in vendita eliminato", HttpStatus.OK);
    }
}