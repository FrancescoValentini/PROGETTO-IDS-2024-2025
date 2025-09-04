package it.vITA.DTO;

public class MetodologiaColtivazioneDTO {
	private String denominazione;
	private String descrizione;
	private String idProdotto;
	
	/**
	 *@param denominazione
	 *@param descrizione
	 */
	public MetodologiaColtivazioneDTO(String denominazione, String descrizione, String idProdotto) {
		super();
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

	public String getIdProdotto() {
		return idProdotto;
	}

	public void setIdProdotto(String idProdotto) {
		this.idProdotto = idProdotto;
	}
	
	
	

}
