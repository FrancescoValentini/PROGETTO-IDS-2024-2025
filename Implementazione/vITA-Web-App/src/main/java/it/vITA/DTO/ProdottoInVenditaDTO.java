package it.vITA.DTO;

public class ProdottoInVenditaDTO {
	private int qta = 1;
	private double prezzo = 0;
	private String idProdotto;
	
	
	
	/**
	 * @param qta
	 * @param prezzo
	 * @param idProdotto
	 */
	public ProdottoInVenditaDTO(int qta, double prezzo, String idProdotto) {
		this.qta = qta;
		this.prezzo = prezzo;
		this.idProdotto = idProdotto;
	}
	
	public int getQta() {
		return qta;
	}
	public void setQta(int qta) {
		this.qta = qta;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	public String getIdProdotto() {
		return idProdotto;
	}
	public void setIdProdotto(String idProdotto) {
		this.idProdotto = idProdotto;
	}
	
	
}
