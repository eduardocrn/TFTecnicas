/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Data.CategoriaException;
import Data.CpfCnpjException;
import Data.DAOException;
import Domain.Categoria;
import Domain.Usuario;
import java.util.List;

/**
 *
 * @author Eduardo
 */
public class Fachada {
    private CadastroUsuario cadastroUsuario;
    private CadastroLeilao cadastroLeilao;
    private CadastroCategoria cadastroCategoria;
    
    public Fachada() {
        cadastroUsuario = new CadastroUsuario();
        cadastroCategoria = new CadastroCategoria();
        cadastroLeilao = new CadastroLeilao();
    }
    
    public boolean novoUsuario(String nome, String email, String cpfCnpj) throws LeilaoException {
        Usuario usuario = new Usuario(0, nome, email, cpfCnpj);
        try {
            return cadastroUsuario.adicionaUsuario(usuario);
        }
        catch(CpfCnpjException | DAOException e) {
            throw new LeilaoException(e.getMessage());
        }
    }
    
    public boolean novoLeilao(String nome, String email, String cpfCnpj) throws LeilaoException {
        throw new LeilaoException("");
    }
    
    public List<Usuario> buscarTodosUsuarios() throws DAOException {
        List<Usuario> lista ;
        lista = cadastroUsuario.buscarTodos();
        return lista;
    }

    public boolean novaCategoria(String nomeCategoria) throws CategoriaException {
        Categoria categoria = new Categoria(0,nomeCategoria);
        try {
            return cadastroCategoria.adicinaCategoria(categoria);
        }catch(DAOException | CategoriaException e){
            throw new CategoriaException(e.getMessage());
        }
    }

    public List<Categoria> buscarTodaCategorias() throws DAOException {
        return cadastroCategoria.buscarCategorias();
    }
    
}