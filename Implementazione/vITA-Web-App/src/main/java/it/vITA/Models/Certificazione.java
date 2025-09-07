package it.vITA.Models;


import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="CERTIFICAZIONI")
public class Certificazione {
	@Id
    @Column(name = "id", columnDefinition = "VARCHAR(64)")
	private String id;
	private String denominazione;
	private String descrizione;
	private String denominazioneEnteCertificatore;
	private LocalDateTime dataConseguimento;
	private LocalDateTime dataScadenza;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "prodotto_id", referencedColumnName = "id")
	private Prodotto prodotto;
	// private ArrayList<File> allegati;
	
	public Certificazione() {this.id = UUID.randomUUID().toString();}
	public Certificazione(String denominazione, String descrizione, String denominazioneEnteCertificatore,
			LocalDateTime dataConseguimento, LocalDateTime dataScadenza, Prodotto prodotto) {
		this.denominazione = denominazione;
		this.descrizione = descrizione;
		this.denominazioneEnteCertificatore = denominazioneEnteCertificatore;
		this.dataConseguimento = dataConseguimento;
		this.dataScadenza = dataScadenza;
		this.prodotto = prodotto;
		this.id = UUID.randomUUID().toString();
	}
	
	public Certificazione(String id, String denominazione, String descrizione, String denominazioneEnteCertificatore,
			LocalDateTime dataConseguimento, LocalDateTime dataScadenza) {
		this.denominazione = denominazione;
		this.descrizione = descrizione;
		this.denominazioneEnteCertificatore = denominazioneEnteCertificatore;
		this.dataConseguimento = dataConseguimento;
		this.dataScadenza = dataScadenza;
		this.id = id;
	}
	public String getDenominazione() {
		return denominazione;
	}
	public void setDenominazione(String denominazione) {
		this.denominazione = denominazione;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getDenominazioneEnteCertificatore() {
		return denominazioneEnteCertificatore;
	}
	public void setDenominazioneEnteCertificatore(String denominazioneEnteCertificatore) {
		this.denominazioneEnteCertificatore = denominazioneEnteCertificatore;
	}
	public LocalDateTime getDataConseguimento() {
		return dataConseguimento;
	}
	public void setDataConseguimento(LocalDateTime dataConseguimento) {
		this.dataConseguimento = dataConseguimento;
	}
	public LocalDateTime getDataScadenza() {
		return dataScadenza;
	}
	public void setDataScadenza(LocalDateTime dataScadenza) {
		this.dataScadenza = dataScadenza;
	}
	public String getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Certificazione [id=" + id + ", denominazione=" + denominazione + ", descrizione=" + descrizione
				+ ", denominazioneEnteCertificatore=" + denominazioneEnteCertificatore + ", dataConseguimento="
				+ dataConseguimento + ", dataScadenza=" + dataScadenza + "]";
	}
	public Prodotto getProdotto() {
		return prodotto;
	}
	public void setProdotto(Prodotto prodotto) {
		this.prodotto = prodotto;
	}
	
	
	
	
}
