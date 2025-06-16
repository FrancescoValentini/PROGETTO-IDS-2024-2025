package it.vITA.DTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class TrasformazioneDTO {
    private String denominazione;
    private String descrizione;
    private LocalDateTime dataFineFase;
    private String idTrasformatore;
    private ArrayList<String> idCertificazioni;

    public TrasformazioneDTO() {}

    public TrasformazioneDTO(String denominazione, String descrizione, LocalDateTime dataFineFase,
                            String idTrasformatore, ArrayList<String> idCertificazioni) {
        this.denominazione = denominazione;
        this.descrizione = descrizione;
        this.dataFineFase = dataFineFase;
        this.idTrasformatore = idTrasformatore;
        this.idCertificazioni = idCertificazioni;
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

    public LocalDateTime getDataFineFase() {
        return dataFineFase;
    }

    public void setDataFineFase(LocalDateTime dataFineFase) {
        this.dataFineFase = dataFineFase;
    }

    public String getIdTrasformatore() {
        return idTrasformatore;
    }

    public void setIdTrasformatore(String idTrasformatore) {
        this.idTrasformatore = idTrasformatore;
    }

    public ArrayList<String> getIdCertificazioni() {
        return idCertificazioni;
    }

    public void setIdCertificazioni(ArrayList<String> idCertificazioni) {
        this.idCertificazioni = idCertificazioni;
    }
}
