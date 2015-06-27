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
public class Usuario {
    private int idUsuario;
    private String nome;
    private String cpfCnpj;
    private String email;
    
    public Usuario(int idUsuario, String nome, String cpfCnpj, String email) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.cpfCnpj = cpfCnpj;
        this.email = email;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public String getEmail() {
        return email;
    }
     
}
