/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Data.DAOException;
import Domain.Lance;
import Domain.Leilao;
import java.util.List;

/**
 *
 * @author Eduardo
 */
public interface LanceDAO {
    public boolean criarLance(Lance lance) throws DAOException;
    Lance buscarLance(int idLance) throws DAOException;
    List<Lance> buscarLances(Leilao l) throws DAOException;
    List<Lance> buscarTodos() throws DAOException;
}
