/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atributos;

/**
 *
 * @author WilhamJr
 */
public class Funcionario {
    private int id;
    private String funcionario;
    private String rg;
    private String cpf;
    private String cargo;
    private double salario;
    private int idContato;
    private int idUsuario;
    private String dataAdmicao;
    private String ctps;
    private String numCtps;
    private String serieCtps;
    private String UfCtps;

    public String getCtps() {
        return ctps;
    }

    public void setCtps(String ctps) {
        this.ctps = ctps;
    }

    public String getNumCtps() {
        return numCtps;
    }

    public void setNumCtps(String numCtps) {
        this.numCtps = numCtps;
    }

    public String getSerieCtps() {
        return serieCtps;
    }

    public void setSerieCtps(String serieCtps) {
        this.serieCtps = serieCtps;
    }

    public String getUfCtps() {
        return UfCtps;
    }

    public void setUfCtps(String UfCtps) {
        this.UfCtps = UfCtps;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(String funcionario) {
        this.funcionario = funcionario;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getIdContato() {
        return idContato;
    }

    public void setIdContato(int idContato) {
        this.idContato = idContato;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getDataAdmicao() {
        return dataAdmicao;
    }

    public void setDataAdmicao(String dataAdmicao) {
        this.dataAdmicao = dataAdmicao;
    }
    
}
