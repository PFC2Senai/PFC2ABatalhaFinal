package atributos;

/**
 *
 * @author S015365
 */
public class Equipamento {
    
    private int idEquipamento;
    private int tabusuarioIdUsuario;
    private String equipamento;
    
    //tab detalhe equipamento
    private int idDetEquipamento;
    private int codModelo;
    private int codFabricante;
    private int codFornecedor;
    private int codEquipamento; // chave estrangeira da tab equipamento

    /**
     * @return the idEquipamento
     */
    public int getIdEquipamento() {
        return idEquipamento;
    }

    /**
     * @param idEquipamento the idEquipamento to set
     */
    public void setIdEquipamento(int idEquipamento) {
        this.idEquipamento = idEquipamento;
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
     * @return the equipamento
     */
    public String getEquipamento() {
        return equipamento;
    }

    /**
     * @param equipamento the equipamento to set
     */
    public void setEquipamento(String equipamento) {
        this.equipamento = equipamento;
    }

    /**
     * @return the idDetEquipamento
     */
    public int getIdDetEquipamento() {
        return idDetEquipamento;
    }

    /**
     * @param idDetEquipamento the idDetEquipamento to set
     */
    public void setIdDetEquipamento(int idDetEquipamento) {
        this.idDetEquipamento = idDetEquipamento;
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
    
    
}
