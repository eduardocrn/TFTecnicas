/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

public enum FormaLance {
    ABERTO (1),
    FECHADO(2);
    
    public int valor;
    
    FormaLance(int valor) { 
        this.valor = valor; 
    }
}