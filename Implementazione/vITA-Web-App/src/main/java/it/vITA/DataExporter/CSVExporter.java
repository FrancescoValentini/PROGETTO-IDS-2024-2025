package it.vITA.DataExporter;

import it.vITA.Models.Evento;
import it.vITA.Models.Invito;

import java.util.List;

/**
 * Classe che consente l'esportazione in CSV
 */
public class CSVExporter implements DataExporter {
	
	public String export(List<CSVExportable> elementi) {
		return null;
	}
	
	@Override
	public String exportEvento(Evento evento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String exportInvito(Invito invito) {
		// TODO Auto-generated method stub
		return null;
	}

}
