package it.vITA.RichiesteBuilder;

import it.vITA.Models.Prodotto;
import it.vITA.Models.TipoRichiesta;
import it.vITA.Models.Trasformazione;
import it.vITA.Models.UtenteRegistrato;

public class RichiestaTrasformazioneBuilder implements BuilderRichiesteRevisione<Trasformazione> {
	
	private boolean approvato = false;
	private String commentoCuratore;
	public UtenteRegistrato creatore;
	public Trasformazione trasformazione;
	public TipoRichiesta tipoRichiesta;
	
	

	/**
	 * Crea una nuova richiesta di revisione per una data trasformazione
	 * 
	 * @return la richiesta di revisione creata
	 * @author Giulia Balestra 
	 */
	public RichiestaTrasformazione build() {
		return new RichiestaTrasformazione(commentoCuratore,creatore,trasformazione,approvato);
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
	public void setElemento(Trasformazione elemento) {
		this.trasformazione = elemento;
		
	}

	@Override
	public void setCommento(String commento) {
		this.commentoCuratore = commento;
	}

}
