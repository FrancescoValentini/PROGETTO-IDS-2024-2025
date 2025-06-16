package it.vITA.DTO;

public class TrasformatoreDTO {

	    private String partitaIva;
	    private String denominazioneAzienda;
	    private String telefonoAziendale;
	    private String idPosizioneGeografica;

	    public TrasformatoreDTO() {}

	    public TrasformatoreDTO(String partitaIva, String denominazioneAzienda, String telefonoAziendale, String idPosizioneGeografica) {
	        this.partitaIva = partitaIva;
	        this.denominazioneAzienda = denominazioneAzienda;
	        this.telefonoAziendale = telefonoAziendale;
	        this.idPosizioneGeografica = idPosizioneGeografica;
	    }

	    public String getPartitaIva() {
	        return partitaIva;
	    }

	    public void setPartitaIva(String partitaIva) {
	        this.partitaIva = partitaIva;
	    }

	    public String getDenominazioneAzienda() {
	        return denominazioneAzienda;
	    }

	    public void setDenominazioneAzienda(String denominazioneAzienda) {
	        this.denominazioneAzienda = denominazioneAzienda;
	    }

	    public String getTelefonoAziendale() {
	        return telefonoAziendale;
	    }

	    public void setTelefonoAziendale(String telefonoAziendale) {
	        this.telefonoAziendale = telefonoAziendale;
	    }

	    public String getIdPosizioneGeografica() {
	        return idPosizioneGeografica;
	    }

	    public void setIdPosizioneGeografica(String idPosizioneGeografica) {
	        this.idPosizioneGeografica = idPosizioneGeografica;
	    }
	}

