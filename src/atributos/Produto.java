package atributos;

import java.util.Date;

/**
 *
 * @author WilhamJr
 */
public class Produto {
    
    private int idProduto;
    private int idUsuario;
    private String produto;

    
    //det produto
    private int idDetProduto;
    private int codProduto;
    private int codModelo;
    private int codFabricante;
    private int quantidade;
    private double precoEntrada;
    private double precoSaida;
    private int quantidadeMinima;
    private Date dataCadProduto;

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    /**
     * @return the codModelo
     */
    public int getCodModelo() {
        return codModelo;
    }

    /**
     * @param codModelo the codModelo to set
     */
    public void setCodModelo(int codModelo) {
        this.codModelo = codModelo;
    }

    /**
     * @return the codFabricante
     */
    public int getCodFabricante() {
        return codFabricante;
    }

    /**
     * @param codFabricante the codFabricante to set
     */
    public void setCodFabricante(int codFabricante) {
        this.codFabricante = codFabricante;
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
     * @return the precoEntrada
     */
    public double getPrecoEntrada() {
        return precoEntrada;
    }

    /**
     * @param precoEntrada the precoEntrada to set
     */
    public void setPrecoEntrada(double precoEntrada) {
        this.precoEntrada = precoEntrada;
    }

    /**
     * @return the precoSaida
     */
    public double getPrecoSaida() {
        return precoSaida;
    }

    /**
     * @param precoSaida the precoSaida to set
     */
    public void setPrecoSaida(double precoSaida) {
        this.precoSaida = precoSaida;
    }

    /**
     * @return the idDetProduto
     */
    public int getIdDetProduto() {
        return idDetProduto;
    }

    /**
     * @param idDetProduto the idDetProduto to set
     */
    public void setIdDetProduto(int idDetProduto) {
        this.idDetProduto = idDetProduto;
    }

    /**
     * @return the codProduto
     */
    public int getCodProduto() {
        return codProduto;
    }

    /**
     * @param codProduto the codProduto to set
     */
    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }

    /**
     * @return the quantidadeMinima
     */
    public int getQuantidadeMinima() {
        return quantidadeMinima;
    }

    /**
     * @param quantidadeMinima the quantidadeMinima to set
     */
    public void setQuantidadeMinima(int quantidadeMinima) {
        this.quantidadeMinima = quantidadeMinima;
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
    
}
