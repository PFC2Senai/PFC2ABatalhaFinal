package atributos;

import java.util.Date;


public class Servico {
    
    private int idServico;
    private int codUsuario;
    private int codCliente;
    private String descricaoServico;
    private float preco;
    private Date dataServico;
    
    private int idDetServico;
    private int codServico; //chave estrangeira tab servico
    private int codProduto; //chave estrangeira
    private int codOrdemServico; //chave estrangeira
    private int quantidade;

    /**
     * @return the idServico
     */
    public int getIdServico() {
        return idServico;
    }

    /**
     * @param idServico the idServico to set
     */
    public void setIdServico(int idServico) {
        this.idServico = idServico;
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
     * @return the descricaoServico
     */
    public String getDescricaoServico() {
        return descricaoServico;
    }

    /**
     * @param descricaoServico the descricaoServico to set
     */
    public void setDescricaoServico(String descricaoServico) {
        this.descricaoServico = descricaoServico;
    }

    /**
     * @return the preco
     */
    public float getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(float preco) {
        this.preco = preco;
    }

    /**
     * @return the dataServico
     */
    public Date getDataServico() {
        return dataServico;
    }

    /**
     * @param dataServico the dataServico to set
     */
    public void setDataServico(Date dataServico) {
        this.dataServico = dataServico;
    }

    /**
     * @return the idDetServico
     */
    public int getIdDetServico() {
        return idDetServico;
    }

    /**
     * @param idDetServico the idDetServico to set
     */
    public void setIdDetServico(int idDetServico) {
        this.idDetServico = idDetServico;
    }

    /**
     * @return the codServico
     */
    public int getCodServico() {
        return codServico;
    }

    /**
     * @param codServico the codServico to set
     */
    public void setCodServico(int codServico) {
        this.codServico = codServico;
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
}
