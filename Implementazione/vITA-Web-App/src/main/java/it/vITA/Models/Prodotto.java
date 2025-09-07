package it.vITA.Models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import it.vITA.RichiesteBuilder.RichiestaProdotto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "PRODOTTI")
public class Prodotto {
	@Id
	@Column(name = "id", columnDefinition = "VARCHAR(64)")
	private String id;
	private String denominazione;
	private String descrizione;
	private LocalDateTime dataEoraProduzione;
	private LocalDateTime dataEoraScadenza;
	private boolean approvato = false;


	@ManyToOne( fetch = FetchType.EAGER)
	@JoinColumn(name = "produttore_id", referencedColumnName = "id")
	private Produttore produttore;

	@OneToMany(mappedBy = "prodotto", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<MetodologiaColtivazione> metodologieColtivazione;

	@OneToMany(mappedBy = "prodotto", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Allergene> allergeni;

	@OneToMany(mappedBy = "prodotto", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Certificazione> certificazioni;

	@OneToMany(mappedBy = "prodotto", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Trasformazione> trasformazione;

	@OneToMany(mappedBy = "prodotto", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<ProdottoInVendita> prodottiInVendita;

	@OneToMany(mappedBy = "prodotto", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<RichiestaProdotto> richiesteProdotto;





	public Prodotto () {
		this.id = UUID.randomUUID().toString();
	}


	public Prodotto(String denominazione, String descrizione, LocalDateTime dataEoraProduzione,
			LocalDateTime dataEoraScadenza, Produttore produttore) {
		this.id = UUID.randomUUID().toString();
		this.denominazione = denominazione;
		this.descrizione = descrizione;
		this.dataEoraProduzione = dataEoraProduzione;
		this.dataEoraScadenza = dataEoraScadenza;
		this.produttore = produttore;
	}

	public Prodotto(String id , String denominazione, String descrizione, LocalDateTime dataEoraProduzione,
			LocalDateTime dataEoraScadenza, Produttore produttore) {
		this.id = id;
		this.denominazione = denominazione;
		this.descrizione = descrizione;
		this.dataEoraProduzione = dataEoraProduzione;
		this.dataEoraScadenza = dataEoraScadenza;
		this.produttore = produttore;
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

	public LocalDateTime getDataEoraProduzione() {
		return dataEoraProduzione;
	}

	public void setDataEoraProduzione(LocalDateTime dataEoraProduzione) {
		this.dataEoraProduzione = dataEoraProduzione;
	}

	public LocalDateTime getDataEoraScadenza() {
		return dataEoraScadenza;
	}

	public void setDataEoraScadenza(LocalDateTime dataEoraScadenza) {
		this.dataEoraScadenza = dataEoraScadenza;
	}

	public boolean isApprovato() {
		return approvato;
	}

	public void setApprovato(boolean approvato) {
		this.approvato = approvato;
	}

	public Produttore getProduttore() {
		return produttore;
	}



	public void setProduttore(Produttore produttore) {
		this.produttore = produttore;
	}

	public String getId() {
		return id;
	}





}
