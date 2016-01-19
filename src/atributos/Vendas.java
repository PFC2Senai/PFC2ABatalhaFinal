package atributos;


import java.sql.Time;
import java.util.Date;

/**
 *
 * @author S015365
 */
public class Vendas {
    
    private int idtabVendas;
    private int clienteIdcliente;
    private int tabusuarioIdUsuario;
    private Date dataVenda;
    private Time hora;
    private int idOrdemServico;
    private double total;

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getIdOrdemServico() {
        return idOrdemServico;
    }

    public void setIdOrdemServico(int idOrdemServico) {
        this.idOrdemServico = idOrdemServico;
    }

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
     * @return the clienteIdcliente
     */
    public int getClienteIdcliente() {
        return clienteIdcliente;
    }

    /**
     * @param clienteIdcliente the clienteIdcliente to set
     */
    public void setClienteIdcliente(int clienteIdcliente) {
        this.clienteIdcliente = clienteIdcliente;
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
