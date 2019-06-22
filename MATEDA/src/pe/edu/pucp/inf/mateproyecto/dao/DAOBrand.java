/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.inf.mateproyecto.dao;

import java.util.ArrayList;
import pe.edu.pucp.inf.mateproyecto.model.bean.Brand;

/**
 *
 * @author Usuario
 */
public interface DAOBrand {
    
    int insert(Brand brand);
    ArrayList<Brand> queryAll();
    int update(Brand brand);
    int delete(Brand brand);
}
