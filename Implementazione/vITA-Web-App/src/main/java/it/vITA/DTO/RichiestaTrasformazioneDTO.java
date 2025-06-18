package it.vITA.DTO;

import it.vITA.Models.TipoRichiesta;

public class RichiestaTrasformazioneDTO {

    private boolean approvato;
    private String commentoCuratore;
    private Long creatoreId;
    private Long trasformazioneId;
    private TipoRichiesta tipoRichiesta;

    public RichiestaTrasformazioneDTO() {
    }

    public RichiestaTrasformazioneDTO(boolean approvato, String commentoCuratore, Long creatoreId, Long trasformazioneId, TipoRichiesta tipoRichiesta) {
        this.approvato = approvato;
        this.commentoCuratore = commentoCuratore;
        this.creatoreId = creatoreId;
        this.trasformazioneId = trasformazioneId;
        this.tipoRichiesta = tipoRichiesta;
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

    public Long getCreatoreId() {
        return creatoreId;
    }

    public void setCreatoreId(Long creatoreId) {
        this.creatoreId = creatoreId;
    }

    public Long getTrasformazioneId() {
        return trasformazioneId;
    }

    public void setTrasformazioneId(Long trasformazioneId) {
        this.trasformazioneId = trasformazioneId;
    }

    public TipoRichiesta getTipoRichiesta() {
        return tipoRichiesta;
    }

    public void setTipoRichiesta(TipoRichiesta tipoRichiesta) {
        this.tipoRichiesta = tipoRichiesta;
    }
}

