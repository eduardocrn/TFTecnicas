/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import DAO.LanceDAO;
import DAO.LanceDAODerby;
import DAO.LeilaoDAO;
import DAO.UsuarioDAO;
import Domain.Bem;
import Domain.FormaLance;
import Domain.Leilao;
import Domain.Natureza;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eduardo
 */
public class LeilaoDAODerby implements LeilaoDAO {

    @Override
    public boolean criarLeilao(Leilao leilao) throws DAOException {
        int resultado;
        String sql = "INSERT INTO Leiloes (DataInicio, HoraInicio, DataFim, HoraFim, Natureza, FormaLance, ValorLote, Usuario_id) VALUES (?,?,?,?,?,?,?,?)";
        try (Connection conexao = InicializadorBd.conectarBd()) {
            try (PreparedStatement comando = conexao.prepareStatement(sql)) {
                comando.setDate(1, (java.sql.Date) leilao.getDataInicio());
                comando.setTime(2, leilao.getHoraInicio());
                comando.setDate(3, (java.sql.Date) leilao.getDataFim());
                comando.setTime(4, leilao.getHoraFim());
                comando.setInt(5, leilao.getNatureza().valor);
                comando.setInt(6, leilao.getFormaLance().valor);
                comando.setBigDecimal(7, leilao.getValorLote());
                comando.setInt(8, leilao.getUsuario().getIdUsuario());
                resultado = comando.executeUpdate();
            }
        } catch (Exception ex) {
            throw new DAOException("Falha na inserção. " + ex.getMessage());
        }
        if (resultado == 0)
            throw new DAOException("Falha na inserção.");
        else
            return true;
    }

    @Override
    public boolean atualizarLeilao(Leilao leilao) throws DAOException {
        int resultado;
        String sql = "UPDATE Leiloes SET DataInicio=?,HoraInicio=?,DataFim=?,HoraFim=?,Natureza=?,FormaLance=?,ValorLote=?,Usuario_id=?) VALUES(?,?,?,?,?,?,?,?)";
        try (Connection conexao = InicializadorBd.conectarBd()) {
            try (PreparedStatement comando = conexao.prepareStatement(sql)) {
                comando.setDate(2, (java.sql.Date) leilao.getDataInicio());
                comando.setTime(3, leilao.getHoraInicio());
                comando.setDate(4, (java.sql.Date) leilao.getDataFim());
                comando.setTime(5, leilao.getHoraFim());
                comando.setInt(6, leilao.getNatureza().valor);
                comando.setInt(7, leilao.getFormaLance().valor);
                comando.setBigDecimal(8, leilao.getValorLote());
                comando.setInt(9, leilao.getUsuario().getIdUsuario());
                resultado = comando.executeUpdate();
            }
        } catch (Exception ex) {
            throw new DAOException("Falha na inserção. " + ex.getMessage());
        }
        if (resultado == 0)
            throw new DAOException("Falha na inserção.");
        else
            return true;
    }

    @Override
    public Leilao buscarLeilao(int idLeilao) throws DAOException {
        Leilao leilao = null;
        UsuarioDAO usuarioDb = new UsuarioDAODerby();
        String sql = "SELECT * FROM Leiloes WHERE idLeilao = ?";
        try (Connection conexao = InicializadorBd.conectarBd()) {
            try (PreparedStatement comando = conexao.prepareStatement(sql)) {
                comando.setInt(1, idLeilao);
                try (ResultSet resultado = comando.executeQuery()) {
                    if (resultado.next()) {
                              Natureza natureza = Natureza.OFERTA;
                        if(resultado.getInt("Natureza") == 2)
                            natureza = Natureza.DEMANDA;
                        FormaLance forma = FormaLance.ABERTO;
                        if(resultado.getInt("FormaLance") == 2)
                            forma = FormaLance.FECHADO;
                        leilao = new Leilao(
                                resultado.getInt("idLeilao"), 
                                resultado.getDate("DataInicio"),
                                resultado.getDate("DataFim"),
                                resultado.getTime("HoraInicio"),
                                resultado.getTime("HoraFim"),
                                natureza,
                                forma,
                                resultado.getBigDecimal("ValorLote"),
                                usuarioDb.buscarUsuarioId(resultado.getInt("Usuario_id")),
                                new ArrayList<Bem>());
                    }
                    return leilao;
                }
            }
        } catch (Exception ex) {
            throw new DAOException("Falha na busca. " + ex.getMessage());
        }
    }

    @Override
    public List<Leilao> buscarTodos() throws DAOException {
        UsuarioDAO usuarioDb = new UsuarioDAODerby();
        List<Leilao> lista = new ArrayList<>();
        String sql = "SELECT * FROM Leiloes";
        try (Connection conexao = InicializadorBd.conectarBd()) {
            try (PreparedStatement comando = conexao.prepareStatement(sql)) {
                try (ResultSet resultado = comando.executeQuery()) {
                    while (resultado.next()) {
                        Natureza natureza = Natureza.OFERTA;
                        if(resultado.getInt("Natureza") == 2)
                            natureza = Natureza.DEMANDA;
                        FormaLance forma = FormaLance.ABERTO;
                        if(resultado.getInt("FormaLance") == 2)
                            forma = FormaLance.FECHADO;
                        lista.add(new Leilao(
                                resultado.getInt("idLeilao"), 
                                resultado.getDate("DataInicio"),
                                resultado.getDate("DataFim"),
                                resultado.getTime("HoraInicio"),
                                resultado.getTime("HoraFim"),
                                natureza,
                                forma,
                                resultado.getBigDecimal("ValorLote"),
                                usuarioDb.buscarUsuarioId(resultado.getInt("Usuario_id")),
                                new ArrayList<Bem>())
                        );
                        
                                
                    }
                    return lista;
                }
            }
        } catch (Exception ex) {
            throw new DAOException("Falha na busca. " + ex.getMessage());
        }
    }
    
}
