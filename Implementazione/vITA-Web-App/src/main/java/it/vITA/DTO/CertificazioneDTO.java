package it.vITA.DTO;

import java.time.LocalDateTime;

public class CertificazioneDTO {
	private String denominazione;
	private String descrizione;
	private String denominazioneEnteCertificatore;
	private LocalDateTime dataScadenza;
	
	/**
	 * @param denominazione
	 * @param descrizione
	 * @param denominazioneEnteCertificatore
	 * @param dataScadenza
	 */
	
	public CertificazioneDTO(String denominazione, String descrizione, String denominazioneEnteCertificatore,
			LocalDateTime dataScadenza) {
		this.denominazione = denominazione;
		this.descrizione = descrizione;
		this.denominazioneEnteCertificatore = denominazioneEnteCertificatore;
		this.dataScadenza = dataScadenza;
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


	public LocalDateTime getDataScadenza() {
		return dataScadenza;
	}


	public void setDataScadenza(LocalDateTime dataScadenza) {
		this.dataScadenza = dataScadenza;
	}
	
	
	
}
