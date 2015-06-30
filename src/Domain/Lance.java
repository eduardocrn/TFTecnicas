/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;

public class Lance {
    private int idLance;
    private Date data;
    private Time hora;
    private BigDecimal valor;
    private Usuario usuario;
    private Leilao leilao;
    
    public Lance(int idLance, Date data, Time hora, BigDecimal valor, Usuario usuario, Leilao leilao) {
        this.idLance = idLance;
        this.data = data;
        this.hora = hora;
        this.valor = valor;
        this.usuario = usuario;
        this.leilao = leilao;
    }

    public int getIdLance() {
        return idLance;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Usuario getUsuario() {
        return usuario;
    }
    
    public Leilao getLeilao() {
        return leilao;
    }

}
