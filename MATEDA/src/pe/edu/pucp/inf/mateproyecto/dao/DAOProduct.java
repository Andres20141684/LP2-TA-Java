/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.inf.mateproyecto.dao;

import java.util.ArrayList;
import pe.edu.pucp.inf.mateproyecto.model.bean.Product;

/**
 *
 * @author Usuario
 */
public interface DAOProduct {
    
    int insert(Product product);
    int insertDiscount(int idDiscount, int idProduct);
    int update(Product product);
    ArrayList<Product> queryAll();
    Product queryProduct(String infProduct);
    
    
}
