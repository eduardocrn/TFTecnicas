/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import DAO.BemDAO;
import Domain.Bem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

/**
 *
 * @author Eduardo
 */
public class BemDaoDerby implements BemDAO{

    @Override
    public boolean criarBEm(Bem bem) throws DAOException {
        int resultado;
        String sql = "INSERT INTO Bens (DescricaoBreve, DescricaoCompleta, Categoria_id, Leilao_id) VALUES (?,?,?,?)";
        try (Connection conexao = InicializadorBd.conectarBd()) {
            try (PreparedStatement comando = conexao.prepareStatement(sql)) {
                comando.setString(1, bem.getDescricaoBreve());
                comando.setString(2, bem.getDescricaoCompleta());
                comando.setInt(3, bem.getCategoria().getIdCategoria());
                comando.setInt(4, bem.getLeilao_id());
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
    public List<Bem> buscarTodos() throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
