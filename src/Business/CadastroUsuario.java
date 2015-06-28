/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Data.CpfCnpjDuplicadoException;
import Data.DAOException;
import Data.UsuarioDAODerby;
import Domain.Usuario;


/**
 *
 * @author Eduardo
 */
public class CadastroUsuario {
    private UsuarioDAO bd;
    
    public CadastroUsuario(){
        if(bd == null)
            bd = new UsuarioDAODerby();
    }
    
    public boolean adicionaUsuario(Usuario usuario) throws CpfCnpjDuplicadoException, DAOException {
        return bd.criarUsuario(usuario);
        
    }
    
}
