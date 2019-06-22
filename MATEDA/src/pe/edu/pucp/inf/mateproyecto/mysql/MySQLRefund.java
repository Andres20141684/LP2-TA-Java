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
import pe.edu.pucp.inf.mateproyecto.dao.DAORefund;
import pe.edu.pucp.inf.mateproyecto.model.bean.Refund;
import pe.edu.pucp.inf.mateproyecto.model.bean.RefundLane;

/**
 *
 * @author Usuario
 */
public class MySQLRefund implements DAORefund{

    @Override
    public int insert(Refund refund) {
        
        int result = 0;
        try{
            DBManager dbManager = DBManager.getDbManager();
            Connection con = DriverManager.getConnection(dbManager.getUrl(), dbManager.getUser(), dbManager.getPassword());
            CallableStatement cs = con.prepareCall("{call InsertRefund(?,?,?,?,?,?)}");
            cs.setString(1, refund.getIdRefound());       
            cs.setInt(2,refund.getState() );
            cs.setFloat(3, refund.getTotalReturned());
            cs.setInt(4, refund.getCustomer().getIdCustomer());
            cs.setInt(5,refund.getSale().getId() );
             
            cs.registerOutParameter("_RefundID",java.sql.Types.INTEGER);
            result = cs.executeUpdate();
            
            CallableStatement cs2 = con.prepareCall("{call InsertRefoundLane(?,?,?,?,?)}");
            
            for (RefundLane rl: refund.getRefundLanes()){
                cs2.setInt(1, rl.getQuantity());
                cs2.setString(2, rl.getReason());
                cs2.setFloat(3, rl.getSubtotal());
                cs2.setInt(4, cs.getInt("_RefundID"));
                cs2.setInt(5, rl.getProduct().getId());
                cs2.executeUpdate();
            }
            
                                   
            con.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        return result;
        
        
        
    }
    
}
