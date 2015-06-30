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
    public boolean validaHoras(String[] horaInicio, String[] horaFim){
        if(horaInicio.length < 2 || horaInicio.length < 2)
            return false;
        if(Integer.valueOf(horaInicio[0]) > 23 || Integer.valueOf(horaFim[0]) > 23)
            return false;
        return true;
    }
    
    public boolean validaDatas(String[] dataInicio, String[] dataFim) {
        if(dataInicio.length < 3 || dataFim.length < 3) // dd/mm/yyyy
            return false;
        if(dataInicio[2].length() < 4 || dataFim[2].length() < 4) //ano
            return false;
        if(Integer.valueOf(dataInicio[1]) > 12 || Integer.valueOf(dataFim[1]) > 12 )
            return false;
        return true;
    }
    
    public boolean validaValorLote(String valor) {
        try{
            BigDecimal decimal = new BigDecimal(valor);
            if(decimal.intValue() < 0)
                return false;
        }catch(Exception e){
            return false;
        }
        return true;
    }
    
}
