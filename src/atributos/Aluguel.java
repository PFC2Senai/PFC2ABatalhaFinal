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
    private String tabDetLocacaocol;
    
    // atributos da tabela detAluguel no banco
    private int idDetAluguel;
    private Date dataAluguel;
    private Time hora;
    private float valorHora;
    private Date dataDevolucao;
    private int codAluguel;
    private int codEquipamento;
    private int codOrdemServico;


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
     * @return the tabDetLocacaocol
     */
    public String getTabDetLocacaocol() {
        return tabDetLocacaocol;
    }

    /**
     * @param tabDetLocacaocol the tabDetLocacaocol to set
     */
    public void setTabDetLocacaocol(String tabDetLocacaocol) {
        this.tabDetLocacaocol = tabDetLocacaocol;
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
     * @return the valorHora
     */
    public float getValorHora() {
        return valorHora;
    }

    /**
     * @param valorHora the valorHora to set
     */
    public void setValorHora(float valorHora) {
        this.valorHora = valorHora;
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
     * @return the codEquipamento
     */
    public int getCodEquipamento() {
        return codEquipamento;
    }

    /**
     * @param codEquipamento the codEquipamento to set
     */
    public void setCodEquipamento(int codEquipamento) {
        this.codEquipamento = codEquipamento;
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
}
