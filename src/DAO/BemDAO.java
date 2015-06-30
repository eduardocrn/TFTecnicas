/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Data.DAOException;
import Domain.Bem;
import java.util.List;

/**
 *
 * @author Eduardo
 */
public interface BemDAO {
    public boolean criarBEm(Bem bem) throws DAOException;
     List<Bem> buscarTodos() throws DAOException;
}
