/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Validadores;

/**
 *
 * @author Eduardo
 */
public class ValidadorBem {
    private static ValidadorBem vc = null;

    private ValidadorBem() {
    }
    
    public static ValidadorBem getInstance() {
        if (vc == null) {
            vc = new ValidadorBem();
        }
        return (vc);
    }

    public boolean validaDescBreve(String descricaoBasica){
        return !(descricaoBasica.length() < 5 || descricaoBasica.length() > 50);
    }
    
    public boolean validaDescCompleta(String descricaoCompleta){
        return !(descricaoCompleta.length() < 5 || descricaoCompleta.length() > 50);
    }
}
