package it.vITA.REST;

import java.util.ArrayList;
import java.util.List;

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

import it.vITA.DTO.RichiestaProdottoDTO;
import it.vITA.Models.Prodotto;
import it.vITA.Models.UtenteRegistrato;
import it.vITA.Repositories.ProdottoRepository;
import it.vITA.Repositories.RichiestaProdottoRepository;
import it.vITA.Repositories.UtenteRegistratoRepository;
import it.vITA.RichiesteBuilder.RichiestaProdotto;
import it.vITA.RichiesteBuilder.RichiestaProdottoBuilder;


/**
 * Rest controller che gestisce le richieste prodotti
 * @author Giulia Balestra
 */
@RestController
@RequestMapping("/api/richiestaProdotto")
public class RichiestaProdottoController {
	 @Autowired
	    private RichiestaProdottoRepository repoRichiestaP;

	    @Autowired
	    private UtenteRegistratoRepository repoUtente;

	    @Autowired
	    private ProdottoRepository repoProdotto;
	    
	    /**
		 * Restituisce tutte le richieste prodotti memorizzate nel db
		 */
	    @GetMapping
		public ResponseEntity<Object> getRichiestaProdotti() {
			Iterable<RichiestaProdotto> richiestap = repoRichiestaP.findAll();
			List<RichiestaProdotto> r = new ArrayList<>();
			richiestap.forEach(x -> r.add(x));
			return new ResponseEntity<>(richiestap,HttpStatus.OK);
		}
	    
	    @GetMapping("/{id}")
	    public ResponseEntity<Object> getRichiestaProdotto(@PathVariable String id) {
	        if (repoRichiestaP.existsById(id)) {
	            return new ResponseEntity<>(repoRichiestaP.findById(id).get(), HttpStatus.OK);
	        }
	        return new ResponseEntity<>("Richiesta prodotto non trovata", HttpStatus.NOT_FOUND);
	    }
	    
	    /**
	     * Crea una nuova richiesta prodotto
	     * @param dto
	     * @return nuova richiesta prodotto
	     */
	    @PostMapping
	    public ResponseEntity<Object> createRichiestaProdotto(@RequestBody RichiestaProdottoDTO dto) {

	        if (!repoUtente.existsById(dto.getIdCreatore())) {
	            return new ResponseEntity<>("Creatore non trovato", HttpStatus.NOT_FOUND);
	        }
	        if (!repoProdotto.existsById(dto.getIdProdotto())) {
	            return new ResponseEntity<>("Prodotto non trovato", HttpStatus.NOT_FOUND);
	        }
	        
	        UtenteRegistrato creatore = repoUtente.findById(dto.getIdCreatore()).get();
	        Prodotto prodotto = repoProdotto.findById(dto.getIdProdotto()).get();

	        RichiestaProdottoBuilder builder = new RichiestaProdottoBuilder();
	        builder.setApprovato(false);
	        builder.setCreatore(creatore);
	        builder.setElemento(prodotto);

	        RichiestaProdotto richiesta = builder.build();
	        richiesta.setTipoRichiesta(dto.getTipoRichiesta());

	        repoRichiestaP.save(richiesta);
	        return new ResponseEntity<>(richiesta, HttpStatus.CREATED);
	    }
	    
	    /**
	     * Aggiorna una richiesta prodotto esistente
	     * @param id
	     * @param dti
	     * @return richiesta prodotto aggiornata
	     */
	    @PutMapping("/{id}")
	    public ResponseEntity<Object> updateRichiestaProdotto(@PathVariable String id, @RequestBody RichiestaProdottoDTO dto) {
	        if (!repoRichiestaP.existsById(id)) {
	            return new ResponseEntity<>("Richiesta prodotto non trovata", HttpStatus.NOT_FOUND);
	        }

	        RichiestaProdotto richiesta = repoRichiestaP.findById(id).get();

	        if (dto.getIdCreatore() != null) {
	            if (!repoUtente.existsById(dto.getIdCreatore())) {
	                return new ResponseEntity<>("Creatore non trovato", HttpStatus.NOT_FOUND);
	            }
	            UtenteRegistrato creatore = repoUtente.findById(dto.getIdCreatore()).get();
	            richiesta.setCreatore(creatore);
	        }

	        if (dto.getIdProdotto() != null) {
	            if (!repoProdotto.existsById(dto.getIdProdotto())) {
	                return new ResponseEntity<>("Prodotto non trovato", HttpStatus.NOT_FOUND);
	            }
	            Prodotto prodotto = repoProdotto.findById(dto.getIdProdotto()).get();
	            richiesta.setProdotto(prodotto);
	        }

	        if (dto.getCommentoCuratore() != null) {
	            richiesta.setCommentoCuratore(dto.getCommentoCuratore());
	        }

	        richiesta.setApprovato(dto.isApprovato());

	        if (dto.getTipoRichiesta() != null) {
	            richiesta.setTipoRichiesta(dto.getTipoRichiesta());
	        }

	        repoRichiestaP.save(richiesta);

	        return new ResponseEntity<>(richiesta, HttpStatus.OK);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Object> deleteRichiestaProdotto(@PathVariable String id) {
	        if (!repoRichiestaP.existsById(id)) {
	            return new ResponseEntity<>("Richiesta prodotto non trovata", HttpStatus.NOT_FOUND);
	        }
	        repoRichiestaP.deleteById(id);
	        return new ResponseEntity<>("Richiesta prodotto eliminata", HttpStatus.OK);
	    }

	    
	    
}
