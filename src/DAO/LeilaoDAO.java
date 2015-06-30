/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Data.DAOException;
import Domain.Leilao;
import java.util.List;

/**
 *
 * @author Eduardo
 */
public interface LeilaoDAO {
    public boolean criarLeilao(Leilao leilao) throws DAOException;
    public boolean atualizarLeilao(Leilao leilao) throws DAOException;
    Leilao buscarLeilao(int idLeilao) throws DAOException;
    List<Leilao> buscarTodos() throws DAOException;
}
