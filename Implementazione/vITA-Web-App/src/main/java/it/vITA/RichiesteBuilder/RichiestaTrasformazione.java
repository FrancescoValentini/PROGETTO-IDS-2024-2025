package it.vITA.RichiesteBuilder;

import it.vITA.Models.TipoRichiesta;
import it.vITA.Models.Trasformazione;
import it.vITA.Models.UtenteRegistrato;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class RichiestaTrasformazione implements I_RichiestaCuratore{
	
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
			Trasformazione trasformazione) {
		super();
		this.approvato = false;
		this.commentoCuratore = commentoCuratore;
		this.creatore = creatore;
		this.trasformazione = trasformazione;
		this.tipoRichiesta = TipoRichiesta.TRASFORMAZIONE;
	}

	@Override
	public void approva() {
		approvato = true;
		
	}
	@Override
	public void rifiuta(String commento) {
		approvato = false;
		commentoCuratore = commento;
		
	}
	@Override
	public UtenteRegistrato getCreatore() {
		
		return creatore;
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
	@Override
	public boolean getStatus() {
		
		return approvato;
	}
	@Override
	public Object getElemento() {
		
		return trasformazione;
	}
	@Override
	public TipoRichiesta getTipoRichiesta() {
		
		return tipoRichiesta;
	}
	


}
