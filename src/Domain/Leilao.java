/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.math.BigDecimal;
import java.sql.Time;
import java.time.LocalDate;

/**
 *
 * @author Eduardo
 */
public class Leilao {
    private int idLeilao;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Time horaInicio;
    private Time horaFim;
    private Natureza natureza;
    private FormaLance formaLance;
    private BigDecimal valorLote;
    private Usuario usuario;
    
    public Leilao(int idLeilao, LocalDate dataInicio, LocalDate dataFim, Time horaInicio,
            Time horaFim, Natureza natureza, FormaLance formaLance, BigDecimal valorLote, Usuario usuario) {
        this.dataFim = dataFim;
        this.dataInicio = dataInicio;
        this.formaLance = formaLance;
        this.horaFim = horaFim;
        this.horaInicio = horaInicio;
        this.idLeilao = idLeilao;
        this.natureza = natureza;
        this.usuario = usuario;
        this.valorLote = valorLote;
    }

    public int getIdLeilao() {
        return idLeilao;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public LocalDate getDataFim() {
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
}
