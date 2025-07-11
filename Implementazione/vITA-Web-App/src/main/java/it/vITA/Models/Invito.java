package it.vITA.Models;

import java.time.LocalDateTime;
import java.util.UUID;

import it.vITA.DataExporter.CSVExportable;
import it.vITA.DataExporter.DataExporter;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="INVITI")
public class Invito implements CSVExportable {
	@Id
    @Column(name = "id", columnDefinition = "VARCHAR(64)")
	private String id;
	
	private LocalDateTime dataEoraCreazioneInvito;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "invitato_id", referencedColumnName = "id")
	private UtenteRegistrato invitato;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "evento_id", referencedColumnName = "id")
	private Evento evento;
	
	public Invito() {this.id = UUID.randomUUID().toString();}
	
	
	
	/**
	 * Crea un nuovo invito
	 * 
	 * @param invitato
	 */
	public Invito(UtenteRegistrato invitato, Evento evento) {
		this.dataEoraCreazioneInvito = LocalDateTime.now();
		this.invitato = invitato;
		this.evento = evento;
	}
	public Invito(String id, UtenteRegistrato invitato, Evento evento) {
		this.dataEoraCreazioneInvito = LocalDateTime.now();
		this.invitato = invitato;
		this.evento = evento;
		this.id = UUID.randomUUID().toString();
	}
	
	public String getId() {
		return id;
	}

	public UtenteRegistrato getInvitato() {
		return invitato;
	}



	public void setInvitato(UtenteRegistrato invitato) {
		this.invitato = invitato;
	}



	public LocalDateTime getDataEoraCreazioneInvito() {
		return dataEoraCreazioneInvito;
	}
	


	@Override
	public String toString() {
		return "Invito [id=" + id + ", dataEoraCreazioneInvito=" + dataEoraCreazioneInvito + ", invitato=" + invitato
				+ "]";
	}
	
	

	@Override
	public String accept(DataExporter exporter) {
		return exporter.exportInvito(this);
	}



	public Evento getEvento() {
		return evento;
	}



	public void setEvento(Evento evento) {
		this.evento = evento;
	}

}
