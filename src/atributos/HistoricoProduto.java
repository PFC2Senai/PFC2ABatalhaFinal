package atributos;

import java.util.Date;


public class HistoricoProduto {
    
    
    private int idHistProduto;
    private double valor;
    private Date dataCadProduto;
    private int quantidade;
    private int codDetProduto;

    /**
     * @return the idHistProduto
     */
    public int getIdHistProduto() {
        return idHistProduto;
    }

    /**
     * @param idHistProduto the idHistProduto to set
     */
    public void setIdHistProduto(int idHistProduto) {
        this.idHistProduto = idHistProduto;
    }

    /**
     * @return the valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * @return the dataCadProduto
     */
    public Date getDataCadProduto() {
        return dataCadProduto;
    }

    /**
     * @param dataCadProduto the dataCadProduto to set
     */
    public void setDataCadProduto(Date dataCadProduto) {
        this.dataCadProduto = dataCadProduto;
    }

    /**
     * @return the quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the codDetProduto
     */
    public int getCodDetProduto() {
        return codDetProduto;
    }

    /**
     * @param codDetProduto the codDetProduto to set
     */
    public void setCodDetProduto(int codDetProduto) {
        this.codDetProduto = codDetProduto;
    }
    
}
