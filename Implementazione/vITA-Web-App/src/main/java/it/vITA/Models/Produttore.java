package it.vITA.Models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "PRODUTTORI")
public class Produttore extends UtenteRegistrato {
	private String partitaIva;
	private String denominazioneAzienda;
	private String telefonoAziendale;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name = "posizione_id", referencedColumnName = "id")
	private Posizione posizioneGeografica;
	
	public Produttore () {}

	public Produttore(String username, String password, String email, String nome, String cognome, String telefono,
			String biografia, String partitaIva, String denominazioneAzienda, String telefonoAziendale,
			Posizione posizioneGeografica) {
		super(username, password, email, nome, cognome, telefono, biografia);
		this.partitaIva = partitaIva;
		this.denominazioneAzienda = denominazioneAzienda;
		this.telefonoAziendale = telefonoAziendale;
		this.posizioneGeografica = posizioneGeografica;
	}
	
	public Produttore(String id, String username, String password, String email, String nome, String cognome, String telefono,
			String biografia, String partitaIva, String denominazioneAzienda, String telefonoAziendale,
			Posizione posizioneGeografica) {
		super(id, username, password, email, nome, cognome, telefono, biografia);
		this.partitaIva = partitaIva;
		this.denominazioneAzienda = denominazioneAzienda;
		this.telefonoAziendale = telefonoAziendale;
		this.posizioneGeografica = posizioneGeografica;
	}

	public String getPartitaIva() {
		return partitaIva;
	}

	public void setPartitaIva(String partitaIva) {
		this.partitaIva = partitaIva;
	}

	public String getDenominazioneAzienda() {
		return denominazioneAzienda;
	}

	public void setDenominazioneAzienda(String denominazioneAzienda) {
		this.denominazioneAzienda = denominazioneAzienda;
	}

	public String getTelefonoAziendale() {
		return telefonoAziendale;
	}

	public void setTelefonoAziendale(String telefonoAziendale) {
		this.telefonoAziendale = telefonoAziendale;
	}

	public Posizione getPosizioneGeografica() {
		return posizioneGeografica;
	}

	public void setPosizioneGeografica(Posizione posizioneGeografica) {
		this.posizioneGeografica = posizioneGeografica;
	}

	@Override
	public String toString() {
		return "Produttore [partitaIva=" + partitaIva + ", denominazioneAzienda=" + denominazioneAzienda
				+ ", telefonoAziendale=" + telefonoAziendale + ", posizioneGeografica=" + posizioneGeografica + "]";
	}
	
	
	

}
