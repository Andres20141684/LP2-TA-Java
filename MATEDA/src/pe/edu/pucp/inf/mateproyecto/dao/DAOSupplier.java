/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.inf.mateproyecto.dao;

import java.util.ArrayList;
import pe.edu.pucp.inf.mateproyecto.model.bean.Supplier;

/**
 *
 * @author Usuario
 */
public interface DAOSupplier {
    int insert(Supplier supplier);
    int update(Supplier supplier);
    int insertArtist(int idArtist, int idSupplier);
    ArrayList<Supplier> queryAll();
    Supplier querySupplier(String infCustomer);
    
    
}
