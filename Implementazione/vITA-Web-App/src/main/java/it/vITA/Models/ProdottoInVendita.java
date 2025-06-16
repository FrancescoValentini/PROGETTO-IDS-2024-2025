package it.vITA.Models;

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
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", columnDefinition = "VARCHAR(64)")
	private String id;
	private int qta = 1;
	private double prezzo = 0;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "prodotto_id", referencedColumnName = "id")
	public Prodotto prodotto;
	
	

	/**
	 * @param qta
	 * @param prezzo
	 * @param prodotto
	 */
	public ProdottoInVendita(int qta, double prezzo, Prodotto prodotto) {
		this.qta = qta;
		this.prezzo = prezzo;
		this.prodotto = prodotto;
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


}
