package it.vITA.DTO;

public class PosizioneDTO {
	private String latitudine;
	private String longitudine;
	
	public PosizioneDTO(String latitudine, String longitudine) {
		this.latitudine = latitudine;
		this.longitudine = longitudine;
	}

	public String getLatitudine() {
		return latitudine;
	}

	public void setLatitudine(String latitudine) {
		this.latitudine = latitudine;
	}

	public String getLongitudine() {
		return longitudine;
	}

	public void setLongitudine(String longitudine) {
		this.longitudine = longitudine;
	}
	
	
}
