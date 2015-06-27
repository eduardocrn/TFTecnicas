/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;
import Domain.*;
import java.util.List;
/**
 *
 * @author Eduardo
 */
public interface UsuarioDAO {
    public boolean criarUsuario(Usuario usuario);
    public boolean atualizarUsuario(Usuario usuario);
    Usuario buscarUsuario(int idUsuario);
    List<Usuario> buscarTodos();
}
