package it.vITA.REST;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.vITA.Models.Allergene;
import it.vITA.Repositories.AllergeniRepository;

/**
 * Rest controller che gestisce gli allergeni
 * @author Giulia Balestra
 */
@RestController
@RequestMapping("/api/allergene")
public class AllergeneController {
	
	private static final Logger logger = LoggerFactory.getLogger(AllergeneController.class);
	
	@Autowired
	AllergeniRepository repoAllergeni;
	
	/**
	 * Restituisce tutti gli allergeni memorizzati nel db
	 */
	@GetMapping
	public ResponseEntity<Object> getAllergeni() {
		Iterable<Allergene> allergeni = repoAllergeni.findAll();
		List<Allergene> a = new ArrayList<>();
		allergeni.forEach(x -> a.add(x));
		return new ResponseEntity<>(allergeni,HttpStatus.OK);
	}
}
