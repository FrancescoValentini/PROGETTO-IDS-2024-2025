package it.vITA.RichiesteBuilder;

import it.vITA.Models.Prodotto;
import it.vITA.Models.TipoRichiesta;
import it.vITA.Models.UtenteRegistrato;

public class RichiestaProdottoBuilder implements BuilderRichiesteRevisione<Prodotto> {
	private boolean approvato = false;
	private String commentoCuratore;
	public UtenteRegistrato creatore;
	public Prodotto prodotto;
	public TipoRichiesta tipoRichiesta;

	
	/**
	 * Crea una nuova richiesta di revisione per un dato prodotto
	 * 
	 * @return la richiesta di revisione creata
	 * @author Francesco Valentini
	 */
	public RichiestaProdotto build() {
		return new RichiestaProdotto(commentoCuratore,creatore,prodotto,approvato);
	}


	@Override
	public void setApprovato(boolean status) {
		this.approvato = status;

	}
	@Override
	public void setCreatore(UtenteRegistrato creatore) {
		this.creatore = creatore;

	}
	@Override
	public void setElemento(Prodotto elemento) {
		this.prodotto = elemento;

	}
	@Override
	public void setCommento(String commento) {
		this.commentoCuratore = commento;

	}



}
