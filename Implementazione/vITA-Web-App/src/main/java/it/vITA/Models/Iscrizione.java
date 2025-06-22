package it.vITA.Models;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="ISCRIZIONI")
public class Iscrizione {
	@Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", columnDefinition = "VARCHAR(64)")
	private String id;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "iscritto_id", referencedColumnName = "id")
	private UtenteRegistrato iscritto;
	private LocalDateTime dataEoraIscrizione;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "evento_id", referencedColumnName = "id")
	private Evento evento;
	
	public Iscrizione() {}

	/**
	 * Crea una nuova iscrizione 
	 * 
	 * @param iscritto
	 */
	public Iscrizione(UtenteRegistrato iscritto, Evento evento) {
		this.iscritto = iscritto;
		this.dataEoraIscrizione = LocalDateTime.now();
		this.evento = evento;
	}

	public UtenteRegistrato getIscritto() {
		return iscritto;
	}

	public void setIscritto(UtenteRegistrato iscritto) {
		this.iscritto = iscritto;
	}

	public LocalDateTime getDataEoraIscrizione() {
		return dataEoraIscrizione;
	}

	public void setDataEoraIscrizione(LocalDateTime dataEoraIscrizione) {
		this.dataEoraIscrizione = dataEoraIscrizione;
	}

	public String getId() {
		return id;
	}
	
	

	@Override
	public String toString() {
		return "Iscrizione [id=" + id + ", iscritto=" + iscritto + ", dataEoraIscrizione=" + dataEoraIscrizione + "]";
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}
	
	
	

}
