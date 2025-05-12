package it.vITA.REST;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {
	
	@GetMapping
	public ResponseEntity<Object> index(){
		return new ResponseEntity<>("HELLO WORLD!", HttpStatus.OK);
	}
	
	@GetMapping("/{string}")
	public ResponseEntity<Object> reverseString(@PathVariable("string") String string) {
		String inversa = new StringBuilder(string).reverse().toString();
		
		return new ResponseEntity<>(inversa, HttpStatus.OK);

	}
}
