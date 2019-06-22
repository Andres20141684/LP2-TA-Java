/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.inf.mateproyecto.mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import pe.edu.pucp.inf.mateproyecto.config.DBManager;
import pe.edu.pucp.inf.mateproyecto.dao.DAOWarehouse;
import pe.edu.pucp.inf.mateproyecto.model.bean.PurchaseLane;
import pe.edu.pucp.inf.mateproyecto.model.bean.Warehouse;

/**
 *
 * @author Usuario
 */
public class MySQLWarehouse implements DAOWarehouse{

    @Override
    public int insert(Warehouse w) {
        
        int result = 0;
        try{
            DBManager dbManager = DBManager.getDbManager();
            Connection con = DriverManager.getConnection(dbManager.getUrl(), dbManager.getUser(), dbManager.getPassword());
            CallableStatement cs = con.prepareCall("{call InsertWarehouse(?,?,?,?,?)}");
                   
            cs.setString(1,w.getDescription() );
            cs.setInt(2, w.getState());
            cs.setString(3, w.getIdWarehouse());
            cs.setInt(4, w.getPremises().getId());
            
            cs.registerOutParameter("AutoId",java.sql.Types.INTEGER);
            result = cs.executeUpdate();
            
                
                      
            con.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return result;
    }
    
    
    
    
    
    
    
    
}
