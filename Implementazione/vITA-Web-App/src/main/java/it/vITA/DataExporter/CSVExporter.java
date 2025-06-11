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
		
		for(CSVExportable elemento : elementi) {
			if(elemento instanceof Evento) {
				sb.append(elemento.accept(this)).append("\n");
			}else if(elemento instanceof Invito) {
				
			}
		}
		
		return sb.toString();
		
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
		// TODO Auto-generated method stub
		return null;
	}

}
