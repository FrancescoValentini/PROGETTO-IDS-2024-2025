package it.vITA.DTO;

public class AllergeneDTO {
	private String denominazione;
	private String descrizione;
	private String idProdotto;
	
	
	/**
	 * @param denominazione
	 * @param descrizione
	 * 
	 */
	public AllergeneDTO(String denominazione, String descrizione, String idProdotto) {
		this.denominazione = denominazione;
		this.descrizione = descrizione;
		this.idProdotto = idProdotto;
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
	
	public String getidProdotto() {
		return this.idProdotto;
	}
	
	
	
}
