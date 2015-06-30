/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import DAO.LanceDAO;
import DAO.LanceDAODerby;
import DAO.LeilaoDAO;
import Data.DAOException;
import Data.LeilaoDAODerby;
import Domain.Lance;
import Domain.Leilao;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eduardo
 */
public class LanceBusiness {

    private LanceDAO dao;

    public LanceBusiness() {
        if (dao == null) {
           dao = new LanceDAODerby();
        }
    }

    public boolean criarLeilao(Lance lance) throws BusinessException {
        try {
            return dao.criarLance(lance);
        } catch (DAOException ex) {
            throw new BusinessException(ex);
        }
    }
    
}
