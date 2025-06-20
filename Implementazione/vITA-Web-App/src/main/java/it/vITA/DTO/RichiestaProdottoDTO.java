package it.vITA.DTO;

import it.vITA.Models.Prodotto;
import it.vITA.Models.TipoRichiesta;
import it.vITA.Models.UtenteRegistrato;

 /**
  * RichiestaProdottoDTO
  * @author Giulia Balestra
  */

public class RichiestaProdottoDTO {
	private boolean approvato = false;
	private String commentoCuratore;
	private String idCreatore;
	private String idProdotto;

	
	
	public RichiestaProdottoDTO() {}
	
	public RichiestaProdottoDTO(boolean approvato, String commentoCuratore, String idCreatore, String idProdotto) {
		this.approvato = approvato;
		this.commentoCuratore = commentoCuratore;
		this.idCreatore = idCreatore;
		this.idProdotto = idProdotto;
	}

	public boolean isApprovato() {
		return approvato;
	}

	public void setApprovato(boolean approvato) {
		this.approvato = approvato;
	}

	public String getCommentoCuratore() {
		return commentoCuratore;
	}

	public void setCommentoCuratore(String commentoCuratore) {
		this.commentoCuratore = commentoCuratore;
	}

	public String getIdCreatore() {
		return idCreatore;
	}

	public void setIdCreatore(String idCreatore) {
		this.idCreatore = idCreatore;
	}

	public String getIdProdotto() {
		return idProdotto;
	}

	public void setIdProdotto(String idProdotto) {
		this.idProdotto = idProdotto;
	}
	
}
