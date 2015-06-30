/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import DAO.CategoriaDAO;
import Data.CategoriaDAODerby;
import Data.CategoriaException;
import Data.DAOException;
import Domain.Categoria;
import java.util.List;

/**
 *
 * @author Eduardo
 */
class CadastroCategoria {
    private CategoriaDAO bd;
    
    public CadastroCategoria() {
        if(bd == null)
            bd = new CategoriaDAODerby();
    }
    
    public boolean adicinaCategoria(Categoria categoria) throws DAOException, CategoriaException {
        return bd.criarCategoria(categoria);
    }
    
    public List<Categoria> buscarCategorias() throws DAOException {
        return bd.buscarTodos();
    }
    
}
