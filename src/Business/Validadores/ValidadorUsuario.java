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
public class ValidadorUsuario {
    
    private static ValidadorUsuario vc = null;

    private ValidadorUsuario() {
    }
    
    public static ValidadorUsuario getInstance() {
        if (vc == null) {
            vc = new ValidadorUsuario();
        }
        return (vc);
    }
    
    public boolean validaNome(String nome){
        return !(nome.length() < 5 || nome.length() > 50);
    }
    
    public boolean validaEmail(String email) {
        return !(email.length() < 5 || email.length() > 50);
    }
    
    public boolean validaCpfCnpj(String cpfCnpj) {       
        return !(cpfCnpj.length() != 14 && cpfCnpj.length() != 10);
    }
    
}
