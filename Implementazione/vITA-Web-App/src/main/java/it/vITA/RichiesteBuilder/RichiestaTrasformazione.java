package it.vITA.RichiesteBuilder;

import it.vITA.Models.TipoRichiesta;
import it.vITA.Models.Trasformazione;
import it.vITA.Models.UtenteRegistrato;
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
import jakarta.persistence.OneToOne;

@Entity
public class RichiestaTrasformazione {
	@Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", columnDefinition = "VARCHAR(64)")
	private String id;	
	private boolean approvato = false;
	private String commentoCuratore;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "utente_id", referencedColumnName = "id")
	public UtenteRegistrato creatore;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "trasformazione_id", referencedColumnName = "id")
	public Trasformazione trasformazione;
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	public TipoRichiesta tipoRichiesta;
	  
	  public RichiestaTrasformazione(){
	  }
	  
	public RichiestaTrasformazione(String commentoCuratore, UtenteRegistrato creatore,
			Trasformazione trasformazione , boolean status) {
		super();
		this.approvato = status;
		this.commentoCuratore = commentoCuratore;
		this.creatore = creatore;
		this.trasformazione = trasformazione;
		this.tipoRichiesta = TipoRichiesta.TRASFORMAZIONE;
	}
	
	public String getId() {
		return id;
	}

	public boolean isApprovato() {
		return approvato;
	}
	public void setApprovato(boolean approvato) {
		this.approvato = approvato;
	}
	public String getCommentoCuratore() {
		return commentoCuratore;
	}
	public void setCommentoCuratore(String commentoCuratore) {
		this.commentoCuratore = commentoCuratore;
	}
	public Trasformazione getTrasformazione() {
		return trasformazione;
	}
	public void setTrasformazione(Trasformazione trasformazione) {
		this.trasformazione = trasformazione;
	}
	public void setCreatore(UtenteRegistrato creatore) {
		this.creatore = creatore;
	}
	public void setTipoRichiesta(TipoRichiesta tipoRichiesta) {
		this.tipoRichiesta = tipoRichiesta;
	}


}
