package it.vITA.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="METODOLOGIE_COLTIVAZIONE")
public class MetodologiaColtivazione {
	@Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", columnDefinition = "VARCHAR(64)")
	private String id;
	private String denominazione;
	private String descrizione;
	
	public MetodologiaColtivazione() {}

	public MetodologiaColtivazione(String denominazione, String descrizione) {
		this.denominazione = denominazione;
		this.descrizione = descrizione;
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
		return "MetodologiaColtivazione [id=" + id + ", denominazione=" + denominazione + ", descrizione=" + descrizione
				+ "]";
	}
	
	
	
}
