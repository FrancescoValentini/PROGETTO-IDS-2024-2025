package it.vITA.REST;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.vITA.Repositories.ProduttoriRepository;

/**
 * Rest controller che gestisce i produttori
 */
@RestController
@RequestMapping("/api/produttore")
public class ProduttoreController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProduttoreController.class);
	
	@Autowired
	
	ProduttoriRepository repoProduttori;
}
