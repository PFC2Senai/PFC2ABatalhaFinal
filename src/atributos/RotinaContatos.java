/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atributos;

/**
 *
 * @author Vinicius
 */
public class RotinaContatos {
    int idRotinaContato;
    int idCliente;
    int idUsuario;
    String dataRotinaContato;
    String Cliente;
    String horaRotinaContato;
    String descricaoRotina;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    public String getCliente() {
        return Cliente;
    }

    public void setCliente(String Cliente) {
        this.Cliente = Cliente;
    }

    public String getDescricaoRotina() {
        return descricaoRotina;
    }

    public void setDescricaoRotina(String descricaoRotina) {
        this.descricaoRotina = descricaoRotina;
    }

    public int getIdRotinaContato() {
        return idRotinaContato;
    }

    public void setIdRotinaContato(int idRotinaContato) {
        this.idRotinaContato = idRotinaContato;
    }

    public String getDataRotinaContato() {
        return dataRotinaContato;
    }

    public void setDataRotinaContato(String dataRotinaContato) {
        this.dataRotinaContato = dataRotinaContato;
    }

    public String getHoraRotinaContato() {
        return horaRotinaContato;
    }

    public void setHoraRotinaContato(String horaRotinaContato) {
        this.horaRotinaContato = horaRotinaContato;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }    
}
