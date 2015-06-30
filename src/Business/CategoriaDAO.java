/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Data.CategoriaException;
import Data.DAOException;
import Domain.Categoria;
import java.util.List;

/**
 *
 * @author Eduardo
 */
public interface CategoriaDAO {
     public boolean criarCategoria(Categoria categoria) throws DAOException, CategoriaException;
     Categoria buscarCategoria(String nomeCategoria) throws DAOException;
     List<Categoria> buscarTodos() throws DAOException;
}
