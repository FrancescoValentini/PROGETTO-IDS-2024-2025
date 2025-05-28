package it.vITA.DataExporter;

/**
 * Interfaccia implementata dagli oggetti che possono essere esportati
 * in formato CSV
 */
public interface CSVExportable {
	String accept(DataExporter exporter);
}
