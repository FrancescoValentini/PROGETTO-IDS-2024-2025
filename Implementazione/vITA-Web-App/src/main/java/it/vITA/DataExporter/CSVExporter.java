package it.vITA.DataExporter;

import it.vITA.Models.Evento;
import it.vITA.Models.Invito;

import java.util.List;

/**
 * Classe che consente l'esportazione in CSV
 */
public class CSVExporter implements DataExporter {
	
	public String export(List<CSVExportable> elementi) {
		StringBuilder sb = new StringBuilder();
		
		if(elementi.size() > 0) sb.append(addCSVHeader(elementi.get(0)));
		
		for(CSVExportable elemento : elementi) {
			sb.append(elemento.accept(this)).append("\n");
		}
		
		return sb.toString();
		
	}
	
	/**
	 * Aggiunge l'header per il CSV in base al tipo di elemento passato
	 * 
	 * @param elemento
	 * @return Header CSV
	 * @author Francesco Valentini
	 */
	private String addCSVHeader(CSVExportable elemento) {
		if(elemento instanceof Evento) {
			return "Id;DataEOraCreazione;DataEOraEvento;Titolo;Descrizione;PrezzoIngresso;TipologiaEvento;PosizioneGeografica\n";
		}else if(elemento instanceof Invito) {
			return "Id;DataEOraCreazione;IdInvitato\n";
		}
		return "";
	}
	
	@Override
	public String exportEvento(Evento evento) {
		StringBuilder sb = new StringBuilder();
		
		sb.append(evento.getId());
		sb.append(";");
		sb.append(evento.getDataEOraCreazione());
		sb.append(";");
		sb.append(evento.getDataEOraEvento());
		sb.append(";");
		sb.append(evento.getTitolo());
		sb.append(";");
		sb.append(evento.getDescrizione());
		sb.append(";");
		sb.append(evento.getPrezzoIngresso());
		sb.append(";");
		sb.append(evento.getTipologiaEvento());
		sb.append(";");
		sb.append(evento.getPosizioneGeografica());
		
		return sb.toString();
	}
	

	@Override
	public String exportInvito(Invito invito) {
		StringBuilder sb = new StringBuilder();
		
		sb.append(invito.getId());
		sb.append(";");
		sb.append(invito.getDataEoraCreazioneInvito());
		sb.append(";");
		sb.append(invito.getInvitato().getId());
		
		return sb.toString();
	}

}
