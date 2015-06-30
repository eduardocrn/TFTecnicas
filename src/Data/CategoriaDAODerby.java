/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import DAO.CategoriaDAO;
import Domain.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eduardo
 */
public class CategoriaDAODerby implements CategoriaDAO {

    @Override
    public boolean criarCategoria(Categoria categoria) throws DAOException, CategoriaException {
        int resultado;
        if (buscarCategoria(categoria.getNomeCategoria()) != null) {
            throw new CategoriaException("Nome categoria já existe: " + categoria.getNomeCategoria());
        }
        String sql = "INSERT INTO CategoriasBens (NomeCAtegoria) VALUES (?)";
        try (Connection conexao = InicializadorBd.conectarBd()) {
            try (PreparedStatement comando = conexao.prepareStatement(sql)) {
                comando.setString(1, categoria.getNomeCategoria());
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
    public Categoria buscarCategoria(String nomeCategoria) throws DAOException {
        Categoria categoria = null;
        String sql = "SELECT * FROM CategoriasBens WHERE NomeCategoria = ?";
        try (Connection conexao = InicializadorBd.conectarBd()) {
            try (PreparedStatement comando = conexao.prepareStatement(sql)) {
                comando.setString(1, nomeCategoria);
                try (ResultSet resultado = comando.executeQuery()) {
                    if (resultado.next()) {
                        categoria = new Categoria(
                                resultado.getInt("idCategoria"),
                                resultado.getString("NomeCategoria"));
                    }
                    return categoria;
                }
            }
        } catch (Exception ex) {
            throw new DAOException("Falha na busca. " + ex.getMessage());
        }
    }

    @Override
    public List<Categoria> buscarTodos() throws DAOException {
        List<Categoria> lista = new ArrayList<>();
        String sql = "SELECT * FROM CategoriasBens";
        try (Connection conexao = InicializadorBd.conectarBd()) {
            try (PreparedStatement comando = conexao.prepareStatement(sql)) {
                try (ResultSet resultado = comando.executeQuery()) {
                    while (resultado.next()) {
                        lista.add(new Categoria(
                                resultado.getInt("idCategoria"),
                                resultado.getString("NomeCategoria")));
                    }
                    return lista;
                }
            }
        } catch (Exception ex) {
            throw new DAOException("Falha na busca. " + ex.getMessage());
        }
    }
    
}
