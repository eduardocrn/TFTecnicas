/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import DAO.UsuarioDAO;
import Data.CpfCnpjException;
import Data.DAOException;
import Data.UsuarioDAODerby;
import Domain.Usuario;
import java.util.List;


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
    
    public boolean adicionaUsuario(Usuario usuario) throws CpfCnpjException, DAOException {
        return bd.criarUsuario(usuario);
        
    }
    
    public List<Usuario> buscarTodos() throws DAOException {
        return bd.buscarTodos();
    }
    
}
