/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.inf.mateproyecto.dao;

import java.util.ArrayList;
import pe.edu.pucp.inf.mateproyecto.model.bean.Discount;

/**
 *
 * @author Usuario
 */
public interface DAODiscount {
    
    int insert(Discount discount);
    int update(Discount discount);
    ArrayList<Discount> queryAll();
    int delete(Discount discount);
    
    
    
}
