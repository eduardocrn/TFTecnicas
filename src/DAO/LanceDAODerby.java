/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Data.DAOException;
import Data.InicializadorBd;
import Data.LeilaoDAODerby;
import Data.UsuarioDAODerby;
import Domain.Lance;
import Domain.Lance;
import Domain.Leilao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eduardo
 */
public class LanceDAODerby implements LanceDAO {

    @Override
    public List<Lance> buscarTodos() throws DAOException {
        UsuarioDAO usuarioDb = new UsuarioDAODerby();
        LeilaoDAO leilaoDAO = new LeilaoDAODerby();
        List<Lance> lista = new ArrayList<>();
        String sql = "SELECT * FROM Lances";
        try (Connection conexao = InicializadorBd.conectarBd()) {
            try (PreparedStatement comando = conexao.prepareStatement(sql)) {
                try (ResultSet resultado = comando.executeQuery()) {
                    while (resultado.next()) {
                        lista.add(new Lance(
                                resultado.getInt("idLance"),
                                resultado.getDate("Data"),
                                resultado.getTime("Hora"),
                                resultado.getBigDecimal("Valor"),
                                usuarioDb.buscarUsuarioId(resultado.getInt("Usuario_id")),
                                leilaoDAO.buscarLeilao(resultado.getInt("Leilao_id"))));
                    }

                    return lista;
                }
            }
        } catch (Exception ex) {
            throw new DAOException("Falha Lance buscarTodos" + ex.getMessage());
        }
    }

    @Override
    public boolean criarLance(Lance lance) throws DAOException {
        int resultado;
        String sql = "INSERT INTO Lances (Data, Hora, Valor, Usuario_id, Leilao_id) VALUES (?,?,?,?,?)";
        try (Connection conexao = InicializadorBd.conectarBd()) {
            try (PreparedStatement comando = conexao.prepareStatement(sql)) {
                comando.setDate(2, new java.sql.Date(lance.getData().getTime()));
                comando.setTime(3, lance.getHora());
                comando.setBigDecimal(4, lance.getValor());
                comando.setInt(5, lance.getUsuario().getIdUsuario());
                comando.setInt(6, lance.getIdLance());
                resultado = comando.executeUpdate();
            }
        } catch (Exception ex) {
            throw new DAOException("Falha na inserção. " + ex.getMessage());
        }
        if (resultado == 0) {
            throw new DAOException("Falha na inserção.");
        } else {
            return true;
        }
    }

    @Override
    public Lance buscarLance(int idLance) throws DAOException {
        UsuarioDAO usuarioDb = new UsuarioDAODerby();
        LeilaoDAO leilaoDAO = new LeilaoDAODerby();
        String sql = "SELECT * FROM Lances WHERE idLance = ?";
        try (Connection conexao = InicializadorBd.conectarBd()) {
            try (PreparedStatement comando = conexao.prepareStatement(sql)) {
                comando.setInt(1, idLance);
                try (ResultSet resultado = comando.executeQuery()) {
                    if (resultado.next()) {
                        return new Lance(
                                resultado.getInt("idLance"),
                                resultado.getDate("Data"),
                                resultado.getTime("Hora"),
                                resultado.getBigDecimal("Valor"),
                                usuarioDb.buscarUsuarioId(resultado.getInt("Usuario_id")),
                                leilaoDAO.buscarLeilao(resultado.getInt("Leilao_id")));
                    }
                    return null;
                }
            }
        } catch (Exception ex) {
            throw new DAOException("Falha buscarLance. " + ex.getMessage());
        }
    }

    @Override
    public List<Lance> buscarLances(Leilao l) throws DAOException {
        UsuarioDAO usuarioDb = new UsuarioDAODerby();
        LeilaoDAO leilaoDAO = new LeilaoDAODerby();
        List<Lance> lista = new ArrayList<>();
        String sql = "SELECT * FROM Lances WHERE Leilao_id = ?";
        try (Connection conexao = InicializadorBd.conectarBd()) {
            try (PreparedStatement comando = conexao.prepareStatement(sql)) {
                comando.setInt(1, l.getIdLeilao());
                try (ResultSet resultado = comando.executeQuery()) {
                    while (resultado.next()) {
                        lista.add(new Lance(
                                resultado.getInt("idLance"),
                                resultado.getDate("Data"),
                                resultado.getTime("Hora"),
                                resultado.getBigDecimal("Valor"),
                                usuarioDb.buscarUsuarioId(resultado.getInt("Usuario_id")),
                                leilaoDAO.buscarLeilao(resultado.getInt("Leilao_id"))));
                    }

                    return lista;
                }
            }
        } catch (Exception ex) {
            throw new DAOException("Falha List<Lance> buscarLances" + ex.getMessage());
        }
    }

}
