package it.vITA.DTO;

public class IscrizioneDTO {
	private String idUtenteRegistrato;
	private String idEvento;
	
	public IscrizioneDTO(String idUtenteRegistrato, String idEvento) {
		this.idUtenteRegistrato = idUtenteRegistrato;
		this.idEvento = idEvento;
	}

	public String getIdUtenteRegistrato() {
		return idUtenteRegistrato;
	}

	public void setIdUtenteRegistrato(String idUtenteRegistrato) {
		this.idUtenteRegistrato = idUtenteRegistrato;
	}

	public String getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(String idEvento) {
		this.idEvento = idEvento;
	}
	
	

}
