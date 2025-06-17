package it.vITA.RichiesteBuilder;

import it.vITA.Models.Prodotto;
import it.vITA.Models.TipoRichiesta;
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
public class RichiestaProdotto implements I_RichiestaCuratore {

	  private boolean approvato = false;
	  private String commentoCuratore;
	  @ManyToOne(fetch = FetchType.EAGER)
	  @JoinColumn(name = "utente_id", referencedColumnName = "id")
	  public UtenteRegistrato creatore;
	  @OneToOne(fetch = FetchType.EAGER)
	  @JoinColumn(name = "prodotto_id", referencedColumnName = "id")
	  public Prodotto prodotto;
	  @Enumerated(EnumType.STRING)
	  @Column(nullable = false)
	  public TipoRichiesta tipoRichiesta;
	  
	  public RichiestaProdotto(){
	  }
	  
	public RichiestaProdotto(String commentoCuratore, UtenteRegistrato creatore,
			Prodotto prodotto) {
		super();
		this.approvato = false;
		this.commentoCuratore = commentoCuratore;
		this.creatore = creatore;
		this.prodotto = prodotto;
		this.tipoRichiesta = TipoRichiesta.PRODOTTO;
	}

	@Override
	public void approva() {
		approvato = true;
		
	}

	@Override
	public void rifiuta(String commento) {
		approvato = false;
		this.commentoCuratore = commento;
		
	}

	@Override
	public UtenteRegistrato getCreatore() {
		
		return creatore;
	}

	@Override
	public boolean getStatus() {
		
		return approvato;
	}

	@Override
	public Object getElemento() {
		
		return prodotto;
	}

	@Override
	public TipoRichiesta getTipoRichiesta() {
	
		return tipoRichiesta;
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

	public Prodotto getProdotto() {
		return prodotto;
	}

	public void setProdotto(Prodotto prodotto) {
		this.prodotto = prodotto;
	}

	public void setCreatore(UtenteRegistrato creatore) {
		this.creatore = creatore;
	}

	public void setTipoRichiesta(TipoRichiesta tipoRichiesta) {
		this.tipoRichiesta = tipoRichiesta;
	}

}
