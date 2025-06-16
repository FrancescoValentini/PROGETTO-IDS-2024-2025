package it.vITA.DTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

import it.vITA.Models.Certificazione;

public class TrasformazioneDTO {
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

    private LocalDateTime dataFineFase;
    private String idTrasformatore;
    private ArrayList<String> idCertificazioni;

    public TrasformazioneDTO() {}

        this.descrizione = descrizione;
        this.dataFineFase = dataFineFase;
        this.idTrasformatore = idTrasformatore;
        this.idCertificazioni = idCertificazioni;
    }








    public ArrayList<String> getIdCertificazioni() {
        return idCertificazioni;
    }

	    public ArrayList<Certificazione> getCertificazioni() {
	        return certificazioni;
	    }
	  
}
