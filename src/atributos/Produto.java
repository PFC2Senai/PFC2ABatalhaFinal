package atributos;

/**
 *
 * @author WilhamJr
 */
public class Produto {
    
    private int idProduto;
    private int idUsuario;
    private String produto;
    private int codFornecedor;
    private int codModelo;
    private int codFabricante;
    private int quantidade;
    private float precoEntrada;
    private float precoSaida;

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
     * @return the codFornecedor
     */
    public int getCodFornecedor() {
        return codFornecedor;
    }

    /**
     * @param codFornecedor the codFornecedor to set
     */
    public void setCodFornecedor(int codFornecedor) {
        this.codFornecedor = codFornecedor;
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
    public void setPrecoEntrada(float precoEntrada) {
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
    public void setPrecoSaida(float precoSaida) {
        this.precoSaida = precoSaida;
    }
    
}
