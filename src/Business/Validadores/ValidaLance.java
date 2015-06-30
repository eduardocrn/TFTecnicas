/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Validadores;

import Domain.Lance;
import java.math.BigDecimal;

/**
 * Classe Responsavel por validar os lances afim de verificar se estao dentro
 * dos requisitos
 *
 * @author Lucas
 */
public class ValidaLance {

    private static ValidaLance validador = null;

    private ValidaLance() {
    }

    public static ValidaLance getInstance() {
        if (validador == null) {
            validador = new ValidaLance();
        }
        return (validador);
    }

    public boolean validarValor(BigDecimal valor) {
        return valor != null && !BigDecimal.ZERO.equals(valor);
    }

}
