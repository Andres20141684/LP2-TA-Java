/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.inf.mateproyecto.dao;

import java.util.ArrayList;
import pe.edu.pucp.inf.mateproyecto.model.bean.Purchase;

/**
 *
 * @author Usuario
 */
public interface DAOPurchase {
    
    int insert(Purchase purchase);
    ArrayList<Purchase> queryAll();
    Purchase queryPurchase(String infPurchase);
    int update(Purchase purchase);
}
