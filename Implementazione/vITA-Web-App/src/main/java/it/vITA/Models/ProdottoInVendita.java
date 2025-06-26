package it.vITA.Models;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="PRODOTTI_IN_VENDITA")
public class ProdottoInVendita {
	@Id
    @Column(name = "id", columnDefinition = "VARCHAR(64)")
	private String id;
	private int qta = 1;
	private double prezzo = 0;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "prodotto_id", referencedColumnName = "id")
	public Prodotto prodotto;
	
	private String descrizione;
	
	public ProdottoInVendita() {this.id = UUID.randomUUID().toString();}

	/**
	 * @param qta
	 * @param prezzo
	 * @param prodotto
	 */
	public ProdottoInVendita(int qta, double prezzo, String descrizione, Prodotto prodotto) {
		this.id = UUID.randomUUID().toString();
		this.qta = qta;
		this.prezzo = prezzo;
		this.prodotto = prodotto;
		this.descrizione = descrizione;
	}
	public ProdottoInVendita(String id ,int qta, double prezzo, String descrizione, Prodotto prodotto) {
		this.id = id;
		this.qta = qta;
		this.prezzo = prezzo;
		this.prodotto = prodotto;
		this.descrizione = descrizione;
	}

	public String getId() {
		return this.id;
	}

	public void setQta(int qta) {
		this.qta = qta;
	}

	public int getQta() {
		return this.qta;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public double getPrezzo() {
		return this.prezzo;
	}

	public void setProdotto(Prodotto prodotto) {
		this.prodotto = prodotto;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Prodotto getProdotto() {
		return prodotto;
	}
	
	


}
