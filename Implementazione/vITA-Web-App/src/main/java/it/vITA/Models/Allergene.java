package it.vITA.Models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="ALLERGENI")
public class Allergene {
	@Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", columnDefinition = "VARCHAR(64)")
	private String id;
	private String denominazione;
	private String descrizione;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "prdotto_id", referencedColumnName = "id")
	private Prodotto prodotto;
	
	public Allergene() {}

	public Allergene(String denominazione, String descrizione, Prodotto prodotto) {
		this.denominazione = denominazione;
		this.descrizione = descrizione;
		this.prodotto = prodotto;
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

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Allergene [id=" + id + ", denominazione=" + denominazione + ", descrizione=" + descrizione + "]";
	}

	public Prodotto getProdotto() {
		return prodotto;
	}

	public void setProdotto(Prodotto prodotto) {
		this.prodotto = prodotto;
	}
	
	
	
	
	
}

