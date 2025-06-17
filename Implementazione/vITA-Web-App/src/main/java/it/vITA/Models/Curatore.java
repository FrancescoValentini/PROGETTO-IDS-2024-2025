package it.vITA.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "CURATORI")

public class Curatore extends UtenteRegistrato {
	public Curatore(){
		
	}

	public Curatore(String username, String password, String email, String nome, String cognome, String telefono,
			String biografia) {
		super(username, password, email, nome, cognome, telefono, biografia);
		// TODO Auto-generated constructor stub
	}
	

}
