package it.vITA.Models;

import java.time.LocalDateTime;
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
@Table(name = "TRASFORMAZIONI")
public class Trasformazione {
	  @Id
      @Column(name = "id", columnDefinition = "VARCHAR(64)")
	  private String id;
	  private String denominazione;
	  private String descrizione;
	  private LocalDateTime dataInizioFase;
	  private LocalDateTime dataFineFase;
	  
	  @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	  @JoinColumn(name = "trasformatore_id", referencedColumnName = "id")
	  private Trasformatore trasformatore;
	  
	  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	  @JoinColumn(name = "certificazione_id")
	  private List<Certificazione> certificazioni;
	  
	  public Trasformazione() {this.id = UUID.randomUUID().toString();}
	  

	  public Trasformazione(String denominazione, String descrizione, LocalDateTime dataInizioFase,
			LocalDateTime dataFineFase, Trasformatore trasformatore, List<Certificazione> certificazioni) {
		this.id = UUID.randomUUID().toString();
		this.denominazione = denominazione;
		this.descrizione = descrizione;
		this.dataInizioFase = dataInizioFase;
		this.dataFineFase = dataFineFase;
		this.trasformatore = trasformatore;
		this.certificazioni = certificazioni;
	}
	  
	  public Trasformazione(String id ,String denominazione, String descrizione, LocalDateTime dataInizioFase,
				LocalDateTime dataFineFase, Trasformatore trasformatore, List<Certificazione> certificazioni) {
			this.id = id;
			this.denominazione = denominazione;
			this.descrizione = descrizione;
			this.dataInizioFase = dataInizioFase;
			this.dataFineFase = dataFineFase;
			this.trasformatore = trasformatore;
			this.certificazioni = certificazioni;
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

	public LocalDateTime getDataInizioFase() {
		return dataInizioFase;
	}

	public void setDataInizioFase(LocalDateTime dataInizioFase) {
		this.dataInizioFase = dataInizioFase;
	}

	public LocalDateTime getDataFineFase() {
		return dataFineFase;
	}

	public void setDataFineFase(LocalDateTime dataFineFase) {
		this.dataFineFase = dataFineFase;
	}

	public Trasformatore getTrasformatore() {
		return trasformatore;
	}

	public void setTrasformatore(Trasformatore trasformatore) {
		this.trasformatore = trasformatore;
	}

	public List<Certificazione> getCertificazioni() {
	    return certificazioni;
	}

	public void setCertificazioni(List<Certificazione> certificazioni) {
	    this.certificazioni = certificazioni;
	}

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Trasformazione [id=" + id + ", denominazione=" + denominazione + ", descrizione=" + descrizione
				+ ", dataInizioFase=" + dataInizioFase + ", dataFineFase=" + dataFineFase + ", trasformatore="
				+ trasformatore + ", certificazioni=" + certificazioni + "]";
	}
	  
	  
	  
	  
}
