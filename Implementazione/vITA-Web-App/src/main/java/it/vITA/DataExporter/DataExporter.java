package it.vITA.DataExporter;

import it.vITA.Models.Evento;
import it.vITA.Models.Invito;

/**
 * Design pattern Visitor
 * 
 * Consente l'esportazione di inviti ed eventi in formato 
 * testuale
 */
public interface DataExporter {
	/**
	 * Esporta un evento
	 * @param evento l'evento da esportare
	 * @return la rappresentazione in stringa
	 */
	String exportEvento(Evento evento);
	
	/**
	 * Esporta un invito
	 * @param invito l'invito da esportare
	 * @return la rappresentazione in stringa
	 */
	String exportInvito(Invito invito);

}
