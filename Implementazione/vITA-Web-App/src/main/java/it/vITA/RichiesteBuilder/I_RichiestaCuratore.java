package it.vITA.RichiesteBuilder;

import it.vITA.Models.TipoRichiesta;
import it.vITA.Models.UtenteRegistrato;

public interface I_RichiestaCuratore {
	
	public void approva();
	
	public void rifiuta(String commento);
	
	public UtenteRegistrato getCreatore();
	
	public boolean getStatus();
	
	public Object getElemento();
	
	public TipoRichiesta getTipoRichiesta();

}
