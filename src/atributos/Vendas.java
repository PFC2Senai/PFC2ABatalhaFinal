package atributos;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author S015365
 */
public class Vendas {
    private int idtabVendas;
    private int cliente_idcliente;
    private int tabusuario_id_usuario;
    private String produto;
    private Date dataVenda;
    private Time hora;

    /**
     * @return the idtabVendas
     */
    public int getIdtabVendas() {
        return idtabVendas;
    }

    /**
     * @param idtabVendas the idtabVendas to set
     */
    public void setIdtabVendas(int idtabVendas) {
        this.idtabVendas = idtabVendas;
    }

    /**
     * @return the cliente_idcliente
     */
    public int getCliente_idcliente() {
        return cliente_idcliente;
    }

    /**
     * @param cliente_idcliente the cliente_idcliente to set
     */
    public void setCliente_idcliente(int cliente_idcliente) {
        this.cliente_idcliente = cliente_idcliente;
    }

    /**
     * @return the tabusuario_id_usuario
     */
    public int getTabusuario_id_usuario() {
        return tabusuario_id_usuario;
    }

    /**
     * @param tabusuario_id_usuario the tabusuario_id_usuario to set
     */
    public void setTabusuario_id_usuario(int tabusuario_id_usuario) {
        this.tabusuario_id_usuario = tabusuario_id_usuario;
    }

    /**
     * @return the produto
     */
    public String getProduto() {
        return produto;
    }

    /**
     * @param produto the produto to set
     */
    public void setProduto(String produto) {
        this.produto = produto;
    }

    /**
     * @return the dataVenda
     */
    public Date getDataVenda() {
        return dataVenda;
    }

    /**
     * @param dataVenda the dataVenda to set
     */
    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
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
    
}
