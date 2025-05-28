package it.vITA.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "UTENTI")
public class UtenteRegistrato {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", columnDefinition = "VARCHAR(64)")
	private String id;
	private String username;
	private String password;
	private String email;
	private String nome;
	private String cognome;
	private String telefono;
	private String biografia;
	
	public UtenteRegistrato() {}
	/**
	 * Costruttore per un utente registrato nella piattaforma
	 * 
	 * @param username
	 * @param password
	 * @param email
	 * @param nome
	 * @param cognome
	 * @param telefono
	 * @param biografia
	 */
	public UtenteRegistrato(String username, String password, String email, String nome, String cognome,
			String telefono, String biografia) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.nome = nome;
		this.cognome = cognome;
		this.telefono = telefono;
		this.biografia = biografia;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getBiografia() {
		return biografia;
	}
	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}
	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return "UtenteRegistrato [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", nome=" + nome + ", cognome=" + cognome + ", telefono=" + telefono + ", biografia=" + biografia
				+ "]";
	}
	
	
}
