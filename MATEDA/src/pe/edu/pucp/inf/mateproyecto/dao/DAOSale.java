/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.inf.mateproyecto.dao;

import java.util.ArrayList;
import pe.edu.pucp.inf.mateproyecto.model.bean.Sale;

/**
 *
 * @author Usuario
 */
public interface DAOSale {
    
    int insert(Sale sale);
    ArrayList<Sale> queryALL();
    Sale querySale(String infSale);
    int update(Sale sale);
}
