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
public class ValidadorCategoria {
    private static ValidadorCategoria vc = null;

    private ValidadorCategoria() {
    }
    
    public static ValidadorCategoria getInstance() {
        if (vc == null) {
            vc = new ValidadorCategoria();
        }
        return (vc);
    }
    
    public boolean validaNome(String nome){
        return !(nome.length() < 5 || nome.length() > 50);
    }
   
}
