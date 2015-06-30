/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;
import Business.UsuarioDAO;
import Domain.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAODerby implements UsuarioDAO{

    @Override
    public boolean criarUsuario(Usuario usuario) throws CpfCnpjException, DAOException{
        int resultado;
        if (buscarUsuarioCpfCnpj(usuario.getCpfCnpj()) != null) {
            throw new CpfCnpjException("CPF/CNPJ já existe no banco de dados : " + usuario.getCpfCnpj());
        }
        String sql = "INSERT INTO Usuarios (CpfCnpj, Nome, Email) VALUES (?,?,?)";
        try (Connection conexao = InicializadorBd.conectarBd()) {
            try (PreparedStatement comando = conexao.prepareStatement(sql)) {
                comando.setString(1, usuario.getCpfCnpj());
                comando.setString(2, usuario.getNome());
                comando.setString(3, usuario.getEmail());
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
    public boolean atualizarUsuario(Usuario usuario) throws CpfInexistenteException, DAOException{
        int resultado = 0;
        if (buscarUsuarioCpfCnpj(usuario.getCpfCnpj()) == null) {
            throw new CpfInexistenteException("CPF Inexistente no banco de dados : " + usuario.getCpfCnpj());
        }
        String sql = "UPDATE Usuarios SET Nome=?, Email=?, CpfCnpj=? WHERE idUsuario = ?";
        try (Connection conexao = InicializadorBd.conectarBd()) {
            try (PreparedStatement comando = conexao.prepareStatement(sql)) {
                comando.setString(1, usuario.getNome());
                comando.setString(2, usuario.getEmail());
                comando.setString(3, usuario.getCpfCnpj());
                comando.setInt(4, usuario.getIdUsuario());
                resultado = comando.executeUpdate();
            }
        } catch (Exception ex) {
            throw new DAOException("Falha na alteração. " + ex.getMessage());
        }
        if (resultado == 0)
            throw new DAOException("Falha na alteração.");
        else
            return true;
    }

    @Override
    public List<Usuario> buscarTodos() throws DAOException{
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM Usuarios";
        try (Connection conexao = InicializadorBd.conectarBd()) {
            try (PreparedStatement comando = conexao.prepareStatement(sql)) {
                try (ResultSet resultado = comando.executeQuery()) {
                    while (resultado.next()) {
                        lista.add(new Usuario(
                                resultado.getInt("idUsuario"),
                                resultado.getString("Nome"),
                                resultado.getString("CpfCnpj"),
                                resultado.getString("Email")));
                    }
                    return lista;
                }
            }
        } catch (Exception ex) {
            throw new DAOException("Falha na busca. " + ex.getMessage());
        }
    }

    @Override
    public Usuario buscarUsuarioId(int idUsuario) throws DAOException{
        Usuario usuario = null;
        String sql = "SELECT * FROM Usuarios WHERE idUsuario = ?";
        try (Connection conexao = InicializadorBd.conectarBd()) {
            try (PreparedStatement comando = conexao.prepareStatement(sql)) {
                comando.setInt(1, idUsuario);
                try (ResultSet resultado = comando.executeQuery()) {
                    if (resultado.next()) {
                        usuario = new Usuario(
                                resultado.getInt("idUsuario"),
                                resultado.getString("Nome"),
                                resultado.getString("CpfCnpj"),
                                resultado.getString("Email"));
                    }
                    return usuario;
                }
            }
        } catch (Exception ex) {
            throw new DAOException("Falha na busca. " + ex.getMessage());
        }
    }

    @Override
    public Usuario buscarUsuarioCpfCnpj(String cpfCnpj) throws DAOException{
        Usuario usuario = null;
        String sql = "SELECT * FROM Usuarios WHERE CpfCnpj = ?";
        try (Connection conexao = InicializadorBd.conectarBd()) {
            try (PreparedStatement comando = conexao.prepareStatement(sql)) {
                comando.setString(1, cpfCnpj);
                try (ResultSet resultado = comando.executeQuery()) {
                    if (resultado.next()) {
                        usuario = new Usuario(
                                resultado.getInt("idUsuario"),
                                resultado.getString("Nome"),
                                resultado.getString("CpfCnpj"),
                                resultado.getString("Email"));
                    }
                    return usuario;
                }
            }
        }
        catch (SQLException se) {
            throw new DAOException("Falha na busca. " + se.getMessage());
        }
        catch (Exception ex) {
            throw new DAOException("Falha na busca. " + ex.getMessage());
        }
    }
    
}
