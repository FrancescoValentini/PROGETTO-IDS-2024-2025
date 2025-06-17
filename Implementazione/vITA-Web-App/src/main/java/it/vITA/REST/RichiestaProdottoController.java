package it.vITA.REST;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.vITA.Models.Prodotto;
import it.vITA.Repositories.ProdottoRepository;
import it.vITA.Repositories.RichiestaProdottoRepository;
import it.vITA.Repositories.UtenteRegistratoRepository;
import it.vITA.RichiesteBuilder.RichiestaProdotto;


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
	    
}
