/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Data.CpfCnpjDuplicadoException;
import Data.DAOException;
import Domain.Usuario;

/**
 *
 * @author Eduardo
 */
public class LeilaoFachada {
    private CadastroUsuario cadastroUsuario;
    
    public LeilaoFachada() {
        cadastroUsuario = new CadastroUsuario();
    }
    
    public boolean novoUsuario(String nome, String email, String cpfCnpj) throws LeilaoException {
        Usuario usuario = new Usuario(0, nome, email, cpfCnpj);
        try {
            return cadastroUsuario.adicionaUsuario(usuario);
        }
        catch(CpfCnpjDuplicadoException | DAOException e) {
            throw new LeilaoException(e.getMessage());
        }
    }
    
}
