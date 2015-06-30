/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Data.DAOException;
import Data.LeilaoDAODerby;
import Domain.Leilao;

/**
 *
 * @author Eduardo
 */
public class CadastroLeilao {
    private LeilaoDAO bd;
    
    public CadastroLeilao() {
        if(bd == null) 
            bd = new LeilaoDAODerby();
    }
    
    public boolean criarLeilao(Leilao leilao) throws DAOException {
        return bd.criarLeilao(leilao);
    }
}
