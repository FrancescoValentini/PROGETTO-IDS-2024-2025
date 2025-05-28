package it.vITA.Models;

import java.time.LocalDateTime;
import java.util.ArrayList;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "EVENTI")
public class Evento {
	@Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", columnDefinition = "VARCHAR(64)")
	private String id;
	private LocalDateTime dataEOraEvento;
	private LocalDateTime dataEOraCreazione;
	private String titolo;
	private String descrizione;
	private double prezzoIngresso;
	private int posti;
	
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
	public TipologiaEvento tipologiaEvento;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "posizione_id", referencedColumnName = "id")
	private Posizione posizioneGeografica;
	
	
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "evento_id") 
	public ArrayList<Iscrizione> iscrizioni;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "evento_id") 
	public ArrayList<Invito> inviti;
	
	
	public Evento() {}


	/**
	 * Crea un nuovo evento
	 * 
	 * @param dataEOraEvento
	 * @param dataEOraCreazione
	 * @param titolo
	 * @param descrizione
	 * @param prezzoIngresso
	 * @param posti
	 * @param tipologiaEvento
	 * @param posizioneGeografica
	 */
	public Evento(LocalDateTime dataEOraEvento, LocalDateTime dataEOraCreazione, String titolo, String descrizione,
			double prezzoIngresso, int posti, TipologiaEvento tipologiaEvento, Posizione posizioneGeografica) {
		this.dataEOraEvento = dataEOraEvento;
		this.dataEOraCreazione = dataEOraCreazione;
		this.titolo = titolo;
		this.descrizione = descrizione;
		this.prezzoIngresso = prezzoIngresso;
		this.posti = posti;
		this.tipologiaEvento = tipologiaEvento;
		this.posizioneGeografica = posizioneGeografica;
		
		this.iscrizioni = new ArrayList<>();
		this.inviti = new ArrayList<>();
	}


	public LocalDateTime getDataEOraEvento() {
		return dataEOraEvento;
	}


	public void setDataEOraEvento(LocalDateTime dataEOraEvento) {
		this.dataEOraEvento = dataEOraEvento;
	}


	public LocalDateTime getDataEOraCreazione() {
		return dataEOraCreazione;
	}


	public void setDataEOraCreazione(LocalDateTime dataEOraCreazione) {
		this.dataEOraCreazione = dataEOraCreazione;
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


	public Posizione getPosizioneGeografica() {
		return posizioneGeografica;
	}


	public void setPosizioneGeografica(Posizione posizioneGeografica) {
		this.posizioneGeografica = posizioneGeografica;
	}


	public ArrayList<Iscrizione> getIscrizioni() {
		return iscrizioni;
	}


	public void setIscrizioni(ArrayList<Iscrizione> iscrizioni) {
		this.iscrizioni = iscrizioni;
	}


	public ArrayList<Invito> getInviti() {
		return inviti;
	}


	public void setInviti(ArrayList<Invito> inviti) {
		this.inviti = inviti;
	}


	public String getId() {
		return id;
	}


	@Override
	public String toString() {
		return "Evento [id=" + id + ", dataEOraEvento=" + dataEOraEvento + ", dataEOraCreazione=" + dataEOraCreazione
				+ ", titolo=" + titolo + ", descrizione=" + descrizione + ", prezzoIngresso=" + prezzoIngresso
				+ ", posti=" + posti + ", tipologiaEvento=" + tipologiaEvento + ", posizioneGeografica="
				+ posizioneGeografica + ", iscrizioni=" + iscrizioni + ", inviti=" + inviti + "]";
	}
	
	
	
	
	
	
	
}
