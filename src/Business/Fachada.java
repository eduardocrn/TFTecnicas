/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Data.CategoriaException;
import Data.CpfCnpjException;
import Data.DAOException;
import Domain.*;
import java.math.BigDecimal;
import java.sql.Time;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Eduardo
 */
public class Fachada {

    private CadastroUsuario cadastroUsuario;
    private CadastroLeilao cadastroLeilao;
    private CadastroCategoria cadastroCategoria;
    private LanceBusiness lanceBusiness;

    public Fachada() {
        cadastroUsuario = new CadastroUsuario();
        cadastroCategoria = new CadastroCategoria();
        cadastroLeilao = new CadastroLeilao();
        lanceBusiness = new LanceBusiness();
    }

    public boolean novoUsuario(String nome, String email, String cpfCnpj) throws LeilaoException {
        Usuario usuario = new Usuario(0, nome, email, cpfCnpj);
        try {
            return cadastroUsuario.adicionaUsuario(usuario);
        } catch (CpfCnpjException | DAOException e) {
            throw new LeilaoException(e.getMessage());
        }
    }

    public boolean novoLeilao(Date dataInicio, Time horaInicio, Date dataFim, Time horaFim, Natureza natureza, FormaLance formaLance, BigDecimal valorLote, Usuario usuario) throws LeilaoException {
        Leilao leilao = new Leilao(0, dataInicio, dataFim, horaInicio, horaFim, natureza, formaLance, valorLote, usuario);
        try {
            return cadastroLeilao.criarLeilao(leilao);
        } catch (DAOException e) {
            throw new LeilaoException(e.getMessage());
        }
    }

    public List<Usuario> buscarTodosUsuarios() {
        List<Usuario> lista = new ArrayList<Usuario>();
        try {
            lista = cadastroUsuario.buscarTodos();
        } catch (DAOException e) {

        }
        return lista;
    }

    public boolean novaCategoria(String nomeCategoria) throws BusinessException {
        Categoria categoria = new Categoria(0, nomeCategoria);
        return cadastroCategoria.adicinaCategoria(categoria);
    }

    public List<Categoria> buscarTodaCategorias() throws DAOException {
        return cadastroCategoria.buscarCategorias();
    }

    public List<Leilao> buscarTodosLeiloes() throws BusinessException {
        return cadastroLeilao.buscarTodos();
    }

    public boolean criarLance(Lance lance) throws BusinessException {
        return lanceBusiness.criarLeilao(lance);
    }

}
