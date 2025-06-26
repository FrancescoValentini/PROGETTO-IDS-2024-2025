package it.vITA.Models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
	  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	  @JoinColumn(name = "metodologia_id")
	  private List<MetodologiaColtivazione> metodologieColtivazione;
	  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	  @JoinColumn(name = "allergene_id")
	  private List<Allergene> allergeni;
	  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	  @JoinColumn(name = "certificazione_id")
	  private List<Certificazione> certificazioni;
	  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	  @JoinColumn(name = "trasformazione_id")
	  private List<Trasformazione> trasformazione;
	  @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	  @JoinColumn(name = "produttore_id", referencedColumnName = "id")
	  private Produttore produttore;
	  
	  public Prodotto () {
			this.certificazioni = new ArrayList<>();
			this.trasformazione = new ArrayList<>();
	  }

	
	public Prodotto(String denominazione, String descrizione, LocalDateTime dataEoraProduzione,
			LocalDateTime dataEoraScadenza, Produttore produttore) {
		this.id = UUID.randomUUID().toString();
		this.denominazione = denominazione;
		this.descrizione = descrizione;
		this.dataEoraProduzione = dataEoraProduzione;
		this.dataEoraScadenza = dataEoraScadenza;
		this.certificazioni = new ArrayList<>();
		this.trasformazione = new ArrayList<>();
		this.produttore = produttore;
	}
	
	public Prodotto(String id , String denominazione, String descrizione, LocalDateTime dataEoraProduzione,
			LocalDateTime dataEoraScadenza, Produttore produttore) {
		this.id = id;
		this.denominazione = denominazione;
		this.descrizione = descrizione;
		this.dataEoraProduzione = dataEoraProduzione;
		this.dataEoraScadenza = dataEoraScadenza;
		this.certificazioni = new ArrayList<>();
		this.trasformazione = new ArrayList<>();
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

	public List<MetodologiaColtivazione> getMetodologieColtivazione() {
		return metodologieColtivazione;
	}

	public void setMetodologieColtivazione(ArrayList<MetodologiaColtivazione> metodologieColtivazione) {
		this.metodologieColtivazione = metodologieColtivazione;
	}

	public List<Allergene> getAllergeni() {
		return allergeni;
	}

	public void setAllergeni(ArrayList<Allergene> allergeni) {
		this.allergeni = allergeni;
	}

	public List<Certificazione> getCertificazioni() {
		return certificazioni;
	}

	public void setCertificazioni(ArrayList<Certificazione> certificazioni) {
		this.certificazioni = certificazioni;
	}

	public List<Trasformazione> getTrasformazione() {
		return trasformazione;
	}

	public void setTrasformazione(ArrayList<Trasformazione> trasformazione) {
		this.trasformazione = trasformazione;
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
