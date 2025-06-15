package it.vITA.DTO;

import java.time.LocalDateTime;

import it.vITA.Models.Produttore;

public class ProdottoDTO {
	  private String denominazione;
	  private String descrizione;
	  private LocalDateTime dataEoraProduzione;
	  private LocalDateTime dataEoraScadenza;
	  private String idProduttore;
	/**
	 * @param denominazione
	 * @param descrizione
	 * @param dataEoraProduzione
	 * @param dataEoraScadenza
	 * @param produttore
	 */
	public ProdottoDTO(String denominazione, String descrizione, LocalDateTime dataEoraProduzione,
			LocalDateTime dataEoraScadenza, String idProduttore) {
		this.denominazione = denominazione;
		this.descrizione = descrizione;
		this.dataEoraProduzione = dataEoraProduzione;
		this.dataEoraScadenza = dataEoraScadenza;
		this.idProduttore = idProduttore;
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
	public String getProduttore() {
		return idProduttore;
	}
	public void setProduttore(String idProduttore) {
		this.idProduttore = idProduttore;
	}
	  
	  
}
