/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author Eduardo
 */
public enum Natureza {
    OFERTA (1),
    DEMANDA(2);
    
    public int valorNatureza; 
    Natureza(int valor) { 
        valorNatureza = valor; 
    }
}