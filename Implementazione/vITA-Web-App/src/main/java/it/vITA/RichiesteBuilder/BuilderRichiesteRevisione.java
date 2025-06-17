package it.vITA.RichiesteBuilder;

import it.vITA.Models.UtenteRegistrato;

public interface BuilderRichiesteRevisione<T> {
	public void setApprovato(boolean status);
	public void setCreatore(UtenteRegistrato creatore);
	public void setElemento(T elemento);
	public void setCommento(String commento);
}
