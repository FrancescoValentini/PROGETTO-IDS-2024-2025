package it.vITA.DTO;

import java.time.LocalDateTime;

import it.vITA.Models.Posizione;
import it.vITA.Models.TipologiaEvento;

public class EventoDTO {
	private LocalDateTime dataEOraEvento;
	private String titolo;
	private String descrizione;
	private double prezzoIngresso;
	private int posti;
	private TipologiaEvento tipologiaEvento;
	private String idPosizioneGeografica;
	
	/**
	 * @param dataEOraEvento
	 * @param titolo
	 * @param descrizione
	 * @param prezzoIngresso
	 * @param posti
	 * @param tipologiaEvento
	 * @param posizioneGeografica
	 */
	public EventoDTO(LocalDateTime dataEOraEvento, String titolo, String descrizione,
			double prezzoIngresso, int posti, TipologiaEvento tipologiaEvento, String idPosizioneGeografica) {
		this.dataEOraEvento = dataEOraEvento;
		this.titolo = titolo;
		this.descrizione = descrizione;
		this.prezzoIngresso = prezzoIngresso;
		this.posti = posti;
		this.tipologiaEvento = tipologiaEvento;
		this.idPosizioneGeografica = idPosizioneGeografica;
	}
	public LocalDateTime getDataEOraEvento() {
		return dataEOraEvento;
	}
	public void setDataEOraEvento(LocalDateTime dataEOraEvento) {
		this.dataEOraEvento = dataEOraEvento;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public double getPrezzoIngresso() {
		return prezzoIngresso;
	}
	public void setPrezzoIngresso(double prezzoIngresso) {
		this.prezzoIngresso = prezzoIngresso;
	}
	public int getPosti() {
		return posti;
	}
	public void setPosti(int posti) {
		this.posti = posti;
	}
	public TipologiaEvento getTipologiaEvento() {
		return tipologiaEvento;
	}
	public void setTipologiaEvento(TipologiaEvento tipologiaEvento) {
		this.tipologiaEvento = tipologiaEvento;
	}
	public String getPosizioneGeografica() {
		return idPosizioneGeografica;
	}
	public void setPosizioneGeografica(String idPosizioneGeografica) {
		this.idPosizioneGeografica = idPosizioneGeografica;
	}
	
	
	
}
