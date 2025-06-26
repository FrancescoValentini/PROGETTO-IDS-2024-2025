package it.vITA.RichiesteBuilder;

import java.util.UUID;

import it.vITA.Models.Prodotto;
import it.vITA.Models.TipoRichiesta;
import it.vITA.Models.UtenteRegistrato;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class RichiestaProdotto {
	@Id
    @Column(name = "id", columnDefinition = "VARCHAR(64)")
	private String id;
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
			Prodotto prodotto, boolean status) {
		super();
		this.approvato = status;
		this.commentoCuratore = commentoCuratore;
		this.creatore = creatore;
		this.prodotto = prodotto;
		this.tipoRichiesta = TipoRichiesta.PRODOTTO;
		this.id = UUID.randomUUID().toString();
	}
	
	public RichiestaProdotto(String id, String commentoCuratore, UtenteRegistrato creatore,
			Prodotto prodotto, boolean status) {
		super();
		this.approvato = status;
		this.commentoCuratore = commentoCuratore;
		this.creatore = creatore;
		this.prodotto = prodotto;
		this.tipoRichiesta = TipoRichiesta.PRODOTTO;
		this.id = id;
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
