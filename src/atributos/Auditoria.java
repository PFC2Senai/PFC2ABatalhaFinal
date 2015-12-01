package atributos;

import java.util.Date;

/**
 *
 * @author S015365
 */
public class Auditoria {
    
    private int idAuditoria;
    private int codUsuario;
    private Date dataAcesso;
    
    private int idDetAuditoria;
    private Date dataModificacao;
    private String descricao;
    private int codAuditoria; // chave estrangeira da tab Auditoria

    /**
     * @return the idAuditoria
     */
    public int getIdAuditoria() {
        return idAuditoria;
    }

    /**
     * @param idAuditoria the idAuditoria to set
     */
    public void setIdAuditoria(int idAuditoria) {
        this.idAuditoria = idAuditoria;
    }

    /**
     * @return the codUsuario
     */
    public int getCodUsuario() {
        return codUsuario;
    }

    /**
     * @param codUsuario the codUsuario to set
     */
    public void setCodUsuario(int codUsuario) {
        this.codUsuario = codUsuario;
    }

    /**
     * @return the dataAcesso
     */
    public Date getDataAcesso() {
        return dataAcesso;
    }

    /**
     * @param dataAcesso the dataAcesso to set
     */
    public void setDataAcesso(Date dataAcesso) {
        this.dataAcesso = dataAcesso;
    }

    /**
     * @return the idDetAuditoria
     */
    public int getIdDetAuditoria() {
        return idDetAuditoria;
    }

    /**
     * @param idDetAuditoria the idDetAuditoria to set
     */
    public void setIdDetAuditoria(int idDetAuditoria) {
        this.idDetAuditoria = idDetAuditoria;
    }

    /**
     * @return the dataModificacao
     */
    public Date getDataModificacao() {
        return dataModificacao;
    }

    /**
     * @param dataModificacao the dataModificacao to set
     */
    public void setDataModificacao(Date dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the codAuditoria
     */
    public int getCodAuditoria() {
        return codAuditoria;
    }

    /**
     * @param codAuditoria the codAuditoria to set
     */
    public void setCodAuditoria(int codAuditoria) {
        this.codAuditoria = codAuditoria;
    }
    
    
    
}
