package it.vITA.DTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

import it.vITA.Models.Certificazione;

public class TrasformazioneDTO {
	 private String denominazione;
	  private String descrizione;
	  private LocalDateTime dataInizioFase;
	  private LocalDateTime dataFineFase;
	  private String idTrasformatore;
	  private ArrayList<Certificazione> certificazioni;
	
	  
	  /**
		 * @param denominazione
		 * @param descrizione
		 * @param dataInizioFase
		 * @param dataFineFase
		 * @param idTrasformatore
		 * @param certificazioni
		 */
		public TrasformazioneDTO(String denominazione, String descrizione, LocalDateTime dataInizioFase,
				LocalDateTime dataFineFase, String idTrasformatore, ArrayList<Certificazione> certificazioni) {
			this.denominazione = denominazione;
			this.descrizione = descrizione;
			this.dataInizioFase = dataInizioFase;
			this.dataFineFase = dataFineFase;
			this.idTrasformatore = idTrasformatore;
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

	    public String getIdTrasformatore() {
	        return idTrasformatore;
	    }

	    public ArrayList<Certificazione> getCertificazioni() {
	        return certificazioni;
	    }
	  
}
