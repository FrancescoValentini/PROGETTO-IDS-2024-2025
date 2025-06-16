package it.vITA.DTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TrasformazioneDTO {
    private String denominazione;
    private String descrizione;
    private LocalDateTime dataFineFase;
    private String idTrasformatore;
    private List<String> idCertificazione;

    public TrasformazioneDTO() {}

    public TrasformazioneDTO(String denominazione, String descrizione, LocalDateTime dataFineFase,
                            String idTrasformatore, ArrayList<String> idCertificazione) {
        this.denominazione = denominazione;
        this.descrizione = descrizione;
        this.dataFineFase = dataFineFase;
        this.idTrasformatore = idTrasformatore;
        this.idCertificazione = idCertificazione;
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

    public List<String> getIdCertificazione() {
        return idCertificazione;
    }

    public void setIdCertificazioni(List<String> idCertificazione) {
        this.idCertificazione = idCertificazione;
    }
}
