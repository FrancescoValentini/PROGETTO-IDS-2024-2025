package it.vITA.REST;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import it.vITA.DTO.CuratoreDTO;
import it.vITA.DTO.RichiestaProdottoDTO;
import it.vITA.DTO.RichiestaTrasformazioneDTO;
import it.vITA.DTO.UtenteRegistratoDTO;
import it.vITA.Models.Curatore;
import it.vITA.Models.UtenteRegistrato;
import it.vITA.Repositories.CuratoreRepository;
import it.vITA.Repositories.RichiestaProdottoRepository;
import it.vITA.Repositories.RichiestaTrasformazioneRepository;
import it.vITA.Repositories.UtenteRegistratoRepository;
import it.vITA.RichiesteBuilder.RichiestaProdotto;
import it.vITA.RichiesteBuilder.RichiestaTrasformazione;

public class CuratoreController {
	private static final Logger logger = LoggerFactory.getLogger(CuratoreController.class);
	@Autowired
	CuratoreRepository curatori; //verificare bisogno nuova repository
	
	@Autowired
	RichiestaProdottoRepository richiestaProdottoRepo;
	
	@Autowired
	RichiestaTrasformazioneRepository richiestaTrasformazioneRepo;

	/**
	 * Restituisce tutti i curatori
	 * @author Giorgio Pranzetti
	 */
	@GetMapping
	public ResponseEntity<Object> getUtenteRegistrato(){
		Iterable<Curatore> inviti = curatori.findAll();
		List<Curatore> in = new ArrayList<>();
		inviti.forEach(x -> in.add(x));
		return new ResponseEntity<>(in,HttpStatus.OK);
	}
	
	/**
	 * Restituisce un singolo curatore
	 * @author Giorgio Pranzetti
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Object> getCuratore(@PathVariable("id") String id){
		if(curatori.existsById(id)) {
			return new ResponseEntity<>(curatori.findById(id).get(),HttpStatus.OK);
		}
		return new ResponseEntity<>("Curatore non trovato",HttpStatus.NOT_FOUND);
	}
	
	/**
	 * Crea un nuovo curatore
	 * @author Giorgio Pranzetti
	 */
	@PostMapping
	public ResponseEntity<Object> createCuratore(@RequestBody CuratoreDTO dtoCuratore){
		Curatore cur = new Curatore();
		
		cur.setNome(dtoCuratore.getNome());
		cur.setCognome(dtoCuratore.getCognome());
		cur.setEmail(dtoCuratore.getEmail());
		cur.setTelefono(dtoCuratore.getTelefono());
		cur.setBiografia(dtoCuratore.getBiografia());
		cur.setUsername(dtoCuratore.getUsername());
		cur.setPassword(dtoCuratore.getPassword());
		
		curatori.save(cur);
		
		return new ResponseEntity<>(cur,HttpStatus.CREATED);
	}
	
	/**
	 * Aggiorna un curatore
	 * @author Giorgio Pranzetti
	 */
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateCuratore(@PathVariable("id") String id, @RequestBody CuratoreDTO dtoCuratore){
		if(curatori.existsById(id)) {
			Curatore cur = curatori.findById(id).get();
			
			cur.setNome(dtoCuratore.getNome());
			cur.setCognome(dtoCuratore.getCognome());
			cur.setEmail(dtoCuratore.getEmail());
			cur.setTelefono(dtoCuratore.getTelefono());
			cur.setBiografia(dtoCuratore.getBiografia());
			cur.setUsername(dtoCuratore.getUsername());
			cur.setPassword(dtoCuratore.getPassword());
			
			curatori.save(cur);
			return new ResponseEntity<>(cur ,HttpStatus.OK);
		}
		return new ResponseEntity<>("Curatore non trovato",HttpStatus.NOT_FOUND);
	}
	
	/**
	 * Elimina un curatore
	 * @author Giorgio Pranzetti
	 * 
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteCuratore(@PathVariable("id") String id) {
		if(curatori.existsById(id)) {
			curatori.deleteById(id);
			return new ResponseEntity<>("Curatore Eliminato",HttpStatus.OK);
		}
		return new ResponseEntity<>("Curatore non trovato",HttpStatus.NOT_FOUND);
	}
	
	/***
	 * Metodo per valutare se approvare o rifiutare una richiestaProdotto
	 * @param idRichiesta
	 * @param dto
	 * @return stato richiesta
	 */
	@PutMapping("/valutaProdotto/{id}")
	public ResponseEntity<Object> valutaProdotto(@PathVariable("id") String id,
	                                             @RequestBody RichiestaProdottoDTO dto) {
		if (richiestaProdottoRepo.existsById(id)) {
			RichiestaProdotto richiesta = richiestaProdottoRepo.findById(id).get();
			richiesta.setApprovato(dto.isApprovato());
			richiesta.setCommentoCuratore(dto.getCommentoCuratore());
			richiestaProdottoRepo.save(richiesta);

			String stato = dto.isApprovato() ? "approvata" : "rifiutata";
			return new ResponseEntity<>("Richiesta prodotto " + stato , HttpStatus.OK);
		}
		return new ResponseEntity<>("Richiesta prodotto non trovata", HttpStatus.NOT_FOUND);
	}
	/***
	 * Metodo per valutare se approvare o rifiutare una richiestaTrasformazione
	 * @param id
	 * @param dto
	 * @return stato richiesta
	 */
	@PutMapping("/valutaTrasformazione/{id}")
	public ResponseEntity<Object> valutaRichiestaTrasformazione(@PathVariable("idRichiesta") String idRichiesta,
	                                                             @RequestBody RichiestaTrasformazioneDTO dto) {
		if (richiestaTrasformazioneRepo.existsById(idRichiesta)) {
			RichiestaTrasformazione richiesta = richiestaTrasformazioneRepo.findById(idRichiesta).get();
			richiesta.setApprovato(dto.isApprovato());
			richiesta.setCommentoCuratore(dto.getCommentoCuratore());
			richiestaTrasformazioneRepo.save(richiesta);

			String stato = dto.isApprovato() ? "approvata" : "rifiutata";
			return new ResponseEntity<>("Richiesta trasformazione " + stato , HttpStatus.OK);
		}
		return new ResponseEntity<>("Richiesta trasformazione non trovata", HttpStatus.NOT_FOUND);
	}

}
