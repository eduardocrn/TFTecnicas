/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Validadores;

import java.math.BigDecimal;
import java.sql.Time;
import javafx.scene.chart.PieChart.Data;

/**
 *
 * @author Eduardo
 */
public class ValidadorLeilao {
    
    private static ValidadorLeilao vc = null;

    private ValidadorLeilao() {
    }
    
    public static ValidadorLeilao getInstance() {
        if (vc == null) {
            vc = new ValidadorLeilao();
        }
        return (vc);
    }
    
    public boolean validaHoras(Time horaInicio, Time horaFim){
        return true;
    }
    
    public boolean validaDatas(Data dataInicio, Data dataFim) {
        return true;
    }
    
    public boolean validaValorLote(BigDecimal valor) {
        return true;
    }
    
}
