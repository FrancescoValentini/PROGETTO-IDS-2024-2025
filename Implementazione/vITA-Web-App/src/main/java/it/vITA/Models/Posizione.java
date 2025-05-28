package it.vITA.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "POSIZIONI_GEOGRAFICHE")
public class Posizione {
	@Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", columnDefinition = "VARCHAR(64)")
	private String id;
	private String latitudine;
	private String longitudine;
	
	public Posizione() {}
	
	/**
	 * Posizione geografica
	 * 
	 * @param latitudine
	 * @param longitudine
	 */
	public Posizione(String latitudine, String longitudine) {
		this.latitudine = latitudine;
		this.longitudine = longitudine;
	}

	public String getLatitudine() {
		return latitudine;
	}

	public void setLatitudine(String latitudine) {
		this.latitudine = latitudine;
	}

	public String getLongitudine() {
		return longitudine;
	}

	public void setLongitudine(String longitudine) {
		this.longitudine = longitudine;
	}

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Posizione [id=" + id + ", latitudine=" + latitudine + ", longitudine=" + longitudine + "]";
	}
	
	
	
	
	
	
}
