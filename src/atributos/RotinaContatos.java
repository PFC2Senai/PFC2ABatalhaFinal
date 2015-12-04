/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atributos;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author Vinicius
 */
public class RotinaContatos {
    int idRotinaContato;
    int idCliente;
    int idUsuario;
    Date dataRotinaContato;
    String Cliente;
    Time horaRotinaContato;
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

    public Date getDataRotinaContato() {
        return dataRotinaContato;
    }

    public void setDataRotinaContato(Date dataRotinaContato) {
        this.dataRotinaContato = dataRotinaContato;
    }

    public Time getHoraRotinaContato() {
        return horaRotinaContato;
    }

    public void setHoraRotinaContato(Time horaRotinaContato) {
        this.horaRotinaContato = horaRotinaContato;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }    
}
