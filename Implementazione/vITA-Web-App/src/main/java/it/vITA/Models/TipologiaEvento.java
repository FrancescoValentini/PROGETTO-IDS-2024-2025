package it.vITA.Models;

/**
 * Enumera le possibili tipologie di eventi nella piattaforma
 */
public enum TipologiaEvento {
	VISITA_AZIENDA,
	TOUR_DEGUSTAZIONE,
	FIERA,
	EVENTO_LOCALE;
	
	/**
	 * Converte un numero intero nella tipologia corrispondente
	 * @param type il numero intero
	 * @return la tipologia di evento, null se il numero non è valido
	 */
	public static TipologiaEvento fromInteger(int type) {
		return switch(type) {
			case 0 -> VISITA_AZIENDA;
			case 1 -> TOUR_DEGUSTAZIONE;
			case 2 -> FIERA;
			case 3 -> EVENTO_LOCALE;
			default -> null;
		};
	}
	
	/**
	 * Converte una TipologiaEvento nel corrispondente numero intero
	 * 
	 * @param type la TipologiaEvento
	 * @return il numero intero corrispondente, -1 se la tipologia non è valida
	 */
	public static int toInteger(TipologiaEvento type) {
		return switch(type) {
			case VISITA_AZIENDA -> 0;
			case TOUR_DEGUSTAZIONE -> 1;
			case FIERA -> 2;
			case EVENTO_LOCALE -> 3;
			default -> -1;
		};
	}
	
}
