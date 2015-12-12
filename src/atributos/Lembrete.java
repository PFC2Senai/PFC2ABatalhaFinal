package atributos;

import java.sql.Time;
import java.util.Date;


public class Lembrete {
    
    private int idLembrete;
    private Date dataLembrete;
    private Time hora;
    private String descricao;
    private int codCliente;
    private String nomeCliente;
    private int codUsuario;

    /**
     * @return the idLembrete
     */
    public int getIdLembrete() {
        return idLembrete;
    }

    /**
     * @param idLembrete the idLembrete to set
     */
    public void setIdLembrete(int idLembrete) {
        this.idLembrete = idLembrete;
    }

    /**
     * @return the dataLembrete
     */
    public Date getDataLembrete() {
        return dataLembrete;
    }

    /**
     * @param dataLembrete the dataLembrete to set
     */
    public void setDataLembrete(Date dataLembrete) {
        this.dataLembrete = dataLembrete;
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
     * @return the codCliente
     */
    public int getCodCliente() {
        return codCliente;
    }

    /**
     * @param codCliente the codCliente to set
     */
    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    /**
     * @return the nomeCliente
     */
    public String getNomeCliente() {
        return nomeCliente;
    }

    /**
     * @param nomeCliente the nomeCliente to set
     */
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
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
    
}
