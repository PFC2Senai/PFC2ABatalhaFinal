package modeloRelatorio;

import java.util.ArrayList;

/**
 *
 * @author Josy
 */
public class ModeloRelatProposta {
 
    
    private String empresa;
    private String contato;
    private String email;
    private String funcionario;
   // private String dataProposta;
    private String referencia;
    private String mensagem;
    private ArrayList<String> tipoServico = new ArrayList();
    private ArrayList<String> pecas = new ArrayList();
    private String valorTotal;
    private String condicaoVenda;
    private String observacao;
    private String validadeP;
    private String reajuste;
    private String localServico;
    private String prazoExecucao;
    private String pagamento;
    private String impostos;
    private String condicoesGerais;
    private String garantia;

    /**
     * @return the empresa
     */
    public String getEmpresa() {
        return empresa;
    }

    /**
     * @param empresa the empresa to set
     */
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    /**
     * @return the contato
     */
    public String getContato() {
        return contato;
    }

    /**
     * @param contato the contato to set
     */
    public void setContato(String contato) {
        this.contato = contato;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the funcionario
     */
    public String getFuncionario() {
        return funcionario;
    }

    /**
     * @param funcionario the funcionario to set
     */
    public void setFuncionario(String funcionario) {
        this.funcionario = funcionario;
    }

//    /**
//     * @return the dataProposta
//     */
//    public String getDataProposta() {
//        return dataProposta;
//    }
//
//    /**
//     * @param dataProposta the dataProposta to set
//     */
//    public void setDataProposta(String dataProposta) {
//        this.dataProposta = dataProposta;
//    }

    /**
     * @return the referencia
     */
    public String getReferencia() {
        return referencia;
    }

    /**
     * @param referencia the referencia to set
     */
    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    /**
     * @return the mensagem
     */
    public String getMensagem() {
        return mensagem;
    }

    /**
     * @param mensagem the mensagem to set
     */
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    /**
     * @return the tipoServico
     */
    public ArrayList<String> getTipoServico() {
        return tipoServico;
    }

    /**
     * @param tipoServico the tipoServico to set
     */
    public void setTipoServico(ArrayList<String> tipoServico) {
        this.tipoServico = tipoServico;
    }

    /**
     * @return the pecas
     */
    public ArrayList<String> getPecas() {
        return pecas;
    }

    /**
     * @param pecas the pecas to set
     */
    public void setPecas(ArrayList<String> pecas) {
        this.pecas = pecas;
    }

    /**
     * @return the valorTotal
     */
    public String getValorTotal() {
        return valorTotal;
    }

    /**
     * @param valorTotal the valorTotal to set
     */
    public void setValorTotal(String valorTotal) {
        this.valorTotal = valorTotal;
    }

    /**
     * @return the condicaoVenda
     */
    public String getCondicaoVenda() {
        return condicaoVenda;
    }

    /**
     * @param condicaoVenda the condicaoVenda to set
     */
    public void setCondicaoVenda(String condicaoVenda) {
        this.condicaoVenda = condicaoVenda;
    }

    /**
     * @return the observacao
     */
    public String getObservacao() {
        return observacao;
    }

    /**
     * @param observacao the observacao to set
     */
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    /**
     * @return the validadeP
     */
    public String getValidadeP() {
        return validadeP;
    }

    /**
     * @param validadeP the validadeP to set
     */
    public void setValidadeP(String validadeP) {
        this.validadeP = validadeP;
    }

    /**
     * @return the reajuste
     */
    public String getReajuste() {
        return reajuste;
    }

    /**
     * @param reajuste the reajuste to set
     */
    public void setReajuste(String reajuste) {
        this.reajuste = reajuste;
    }

    /**
     * @return the localServico
     */
    public String getLocalServico() {
        return localServico;
    }

    /**
     * @param localServico the localServico to set
     */
    public void setLocalServico(String localServico) {
        this.localServico = localServico;
    }

    /**
     * @return the prazoExecucao
     */
    public String getPrazoExecucao() {
        return prazoExecucao;
    }

    /**
     * @param prazoExecucao the prazoExecucao to set
     */
    public void setPrazoExecucao(String prazoExecucao) {
        this.prazoExecucao = prazoExecucao;
    }

    /**
     * @return the pagamento
     */
    public String getPagamento() {
        return pagamento;
    }

    /**
     * @param pagamento the pagamento to set
     */
    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }

    /**
     * @return the impostos
     */
    public String getImpostos() {
        return impostos;
    }

    /**
     * @param impostos the impostos to set
     */
    public void setImpostos(String impostos) {
        this.impostos = impostos;
    }

    /**
     * @return the condicoesGerais
     */
    public String getCondicoesGerais() {
        return condicoesGerais;
    }

    /**
     * @param condicoesGerais the condicoesGerais to set
     */
    public void setCondicoesGerais(String condicoesGerais) {
        this.condicoesGerais = condicoesGerais;
    }

    /**
     * @return the garantia
     */
    public String getGarantia() {
        return garantia;
    }

    /**
     * @param garantia the garantia to set
     */
    public void setGarantia(String garantia) {
        this.garantia = garantia;
    }
    
}
