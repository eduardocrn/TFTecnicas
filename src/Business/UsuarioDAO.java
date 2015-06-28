/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;
import Data.CpfCnpjDuplicadoException;
import Data.CpfInexistenteException;
import Data.DAOException;
import Domain.*;
import java.util.List;

public interface UsuarioDAO {
    public boolean criarUsuario(Usuario usuario) throws CpfCnpjDuplicadoException, DAOException;
    public boolean atualizarUsuario(Usuario usuario) throws CpfInexistenteException, DAOException;
    Usuario buscarUsuarioId(int idUsuario) throws DAOException;
    Usuario buscarUsuarioCpfCnpj(String cpfCnpj) throws DAOException;
    List<Usuario> buscarTodos() throws DAOException;
}
