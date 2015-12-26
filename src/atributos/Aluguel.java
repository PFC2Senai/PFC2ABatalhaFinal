package atributos;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author S015365
 */
public class Aluguel {
    
    private int idtabDetLocacao;
    private int tabusuarioIdUsuario;
    private int tabclienteIdcliente;
    private String descricaotLocacao;
    private Date dataAluguel;
    private Time hora;
    private int codOrdemServico;
    private Date dataDevolucao;
    
    // atributos da tabela detAluguel no banco
    private int idDetAluguel;    
    private double valorLocacao;  
    private int codAluguel;
    private int codDetEquipamento;
    private int quatidadeEqui;
    


    /**
     * @return the idtabDetLocacao
     */
    public int getIdtabDetLocacao() {
        return idtabDetLocacao;
    }

    /**
     * @param idtabDetLocacao the idtabDetLocacao to set
     */
    public void setIdtabDetLocacao(int idtabDetLocacao) {
        this.idtabDetLocacao = idtabDetLocacao;
    }

    /**
     * @return the tabusuarioIdUsuario
     */
    public int getTabusuarioIdUsuario() {
        return tabusuarioIdUsuario;
    }

    /**
     * @param tabusuarioIdUsuario the tabusuarioIdUsuario to set
     */
    public void setTabusuarioIdUsuario(int tabusuarioIdUsuario) {
        this.tabusuarioIdUsuario = tabusuarioIdUsuario;
    }

    /**
     * @return the tabclienteIdcliente
     */
    public int getTabclienteIdcliente() {
        return tabclienteIdcliente;
    }

    /**
     * @param tabclienteIdcliente the tabclienteIdcliente to set
     */
    public void setTabclienteIdcliente(int tabclienteIdcliente) {
        this.tabclienteIdcliente = tabclienteIdcliente;
    }

    /**
     * @return the descricaotLocacao
     */
    public String getDescricaotLocacao() {
        return descricaotLocacao;
    }

    /**
     * @param descricaotLocacao the descricaotLocacao to set
     */
    public void setDescricaotLocacao(String descricaotLocacao) {
        this.descricaotLocacao = descricaotLocacao;
    }
    
    /**
     * @return the idDetAluguel
     */
    public int getIdDetAluguel() {
        return idDetAluguel;
    }

    /**
     * @param idDetAluguel the idDetAluguel to set
     */
    public void setIdDetAluguel(int idDetAluguel) {
        this.idDetAluguel = idDetAluguel;
    }

    /**
     * @return the dataAluguel
     */
    public Date getDataAluguel() {
        return dataAluguel;
    }

    /**
     * @param dataAluguel the dataAluguel to set
     */
    public void setDataAluguel(Date dataAluguel) {
        this.dataAluguel = dataAluguel;
    }

    /**
     * @return the hora
     */
    public Time getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(Time hora) {
        this.hora = hora;
    }

    /**
     * @return the valorLocacao
     */
    public double getValorLocacao() {
        return valorLocacao;
    }

    /**
     * @param valorLocacao the valorLocacao to set
     */
    public void setValorLocacao(double valorLocacao) {
        this.valorLocacao = valorLocacao;
    }

    /**
     * @return the dataDevolucao
     */
    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    /**
     * @param dataDevolucao the dataDevolucao to set
     */
    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    /**
     * @return the codAluguel
     */
    public int getCodAluguel() {
        return codAluguel;
    }

    /**
     * @param codAluguel the codAluguel to set
     */
    public void setCodAluguel(int codAluguel) {
        this.codAluguel = codAluguel;
    }

    /**
     * @return the codDetEquipamento
     */
    public int getCodDetEquipamento() {
        return codDetEquipamento;
    }

    /**
     * @param codDetEquipamento the codDetEquipamento to set
     */
    public void setCodDetEquipamento(int codDetEquipamento) {
        this.codDetEquipamento = codDetEquipamento;
    }

    /**
     * @return the codOrdemServico
     */
    public int getCodOrdemServico() {
        return codOrdemServico;
    }

    /**
     * @param codOrdemServico the codOrdemServico to set
     */
    public void setCodOrdemServico(int codOrdemServico) {
        this.codOrdemServico = codOrdemServico;
    }

    /**
     * @return the quatidadeEqui
     */
    public int getQuatidadeEqui() {
        return quatidadeEqui;
    }

    /**
     * @param quatidadeEqui the quatidadeEqui to set
     */
    public void setQuatidadeEqui(int quatidadeEqui) {
        this.quatidadeEqui = quatidadeEqui;
    }
}