package atributos;


public class Servico {
    float valor;
    String tipoReparo;
    String formaPag;
    float total;
    float desconto;
    String status;

    /**
     * @return the valor
     */
    public float getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(float valor) {
        this.valor = valor;
    }

    /**
     * @return the tipoReparo
     */
    public String getTipoReparo() {
        return tipoReparo;
    }

    /**
     * @param tipoReparo the tipoReparo to set
     */
    public void setTipoReparo(String tipoReparo) {
        this.tipoReparo = tipoReparo;
    }

    /**
     * @return the formaPag
     */
    public String getFormaPag() {
        return formaPag;
    }

    /**
     * @param formaPag the formaPag to set
     */
    public void setFormaPag(String formaPag) {
        this.formaPag = formaPag;
    }

    /**
     * @return the total
     */
    public float getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(float total) {
        this.total = total;
    }

    /**
     * @return the desconto
     */
    public float getDesconto() {
        return desconto;
    }

    /**
     * @param desconto the desconto to set
     */
    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }
}
