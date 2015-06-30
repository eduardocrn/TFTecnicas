/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.math.BigDecimal;
import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Leilao {

    private int idLeilao;
    private Date dataInicio;
    private Date dataFim;
    private Time horaInicio;
    private Time horaFim;
    private Natureza natureza;
    private FormaLance formaLance;
    private BigDecimal valorLote;
    private Usuario usuario;
    private List<Bem> bens;

    public Leilao(int idLeilao, Date dataInicio, Date dataFim, Time horaInicio,
            Time horaFim, Natureza natureza, FormaLance formaLance, BigDecimal valorLote, Usuario usuario, List<Bem> bens) {
        this.dataFim = dataFim;
        this.dataInicio = dataInicio;
        this.formaLance = formaLance;
        this.horaFim = horaFim;
        this.horaInicio = horaInicio;
        this.idLeilao = idLeilao;
        this.natureza = natureza;
        this.usuario = usuario;
        this.valorLote = valorLote;
        this.bens = bens;
    }

    public int getIdLeilao() {
        return idLeilao;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public Time getHoraInicio() {
        return horaInicio;
    }

    public Time getHoraFim() {
        return horaFim;
    }

    public Natureza getNatureza() {
        return natureza;
    }

    public FormaLance getFormaLance() {
        return formaLance;
    }

    public BigDecimal getValorLote() {
        return valorLote;
    }

    public Usuario getUsuario() {
        return usuario;
    }
    
    public List<Bem> getBens(){
        return bens;
    }

    @Override
    public String toString() {
        return String.valueOf(idLeilao);
    }

}
