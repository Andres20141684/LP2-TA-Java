/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.inf.mateproyecto.mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.inf.mateproyecto.config.DBManager;
import pe.edu.pucp.inf.mateproyecto.dao.DAODiscount;
import pe.edu.pucp.inf.mateproyecto.model.bean.Discount;

/**
 *
 * @author Usuario
 */
public class MySQLDiscount implements DAODiscount {

    @Override
    public int insert(Discount discount) {
       int result = 0;
        try{
            DBManager dbManager = DBManager.getDbManager();
            Connection con = DriverManager.getConnection(dbManager.getUrl(), dbManager.getUser(), dbManager.getPassword());
            CallableStatement cs = con.prepareCall("{call InsertDiscount(?,?,?,?,?,?,?)}");
            
            cs.setString(1,discount.getDescription() );
            cs.setFloat(2,discount.getDiscountAmount());
            cs.setDate(3, (Date) discount.getStartDate());
            cs.setDate(4, (Date) discount.getEndDate());
            cs.setString(5,discount.getIdDiscount());
            cs.setInt(6, discount.getState());
                       
            
                 
            result = cs.executeUpdate();
            con.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return result;
    }

    @Override
    public int update(Discount discount) {
        int result =0;
        try{
            DBManager dbManager = DBManager.getDbManager();
            Connection con = DriverManager.getConnection(dbManager.getUrl(), dbManager.getUser(), dbManager.getPassword());
            CallableStatement cs = con.prepareCall("{call UpdateDiscount(?,?,?,?,?,?,?)}");
            cs.setInt(1,discount.getId());
            cs.setString(2,discount.getDescription() );
            cs.setFloat(3,discount.getDiscountAmount());
            cs.setDate(4, (Date) discount.getStartDate());
            cs.setDate(5, (Date) discount.getEndDate());
            cs.setString(6,discount.getIdDiscount());
            cs.setInt(7, discount.getState());
            result = cs.executeUpdate();
            con.close();
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
               
       return result;
    }

    @Override
    public ArrayList<Discount> queryAll() {
        ArrayList<Discount> listDiscounts = new ArrayList<Discount>();
        try{
            DBManager dbManager = DBManager.getDbManager();
            Connection con = DriverManager.getConnection(dbManager.getUrl(), dbManager.getUser(), dbManager.getPassword());
            CallableStatement cs = con.prepareCall("{call GetAllDiscounts()}");
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                Discount discount = new Discount();
                discount.setDescription(rs.getString("Description"));
                discount.setDiscountAmount( rs.getFloat("Discountamount"));
                discount.setStartDate(rs.getDate("Startdate"));
                discount.setEndDate(rs.getDate("Enddate"));
                discount.setId(rs.getInt("Id") );
                discount.setIdDiscount(rs.getString("DiscountID"));
                discount.setState(rs.getInt("State"));
                listDiscounts.add(discount);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return listDiscounts;
    }

    @Override
    public int delete(Discount discount) {
        int result =0;
        try{
            DBManager dbManager = DBManager.getDbManager();
            Connection con = DriverManager.getConnection(dbManager.getUrl(), dbManager.getUser(), dbManager.getPassword());
            CallableStatement cs = con.prepareCall("{call UpdateDiscount(?,?,?,?,?,?,?)}");
            cs.setInt(1,discount.getId());
            cs.setString(2,discount.getDescription() );
            cs.setFloat(3,discount.getDiscountAmount());
            cs.setDate(4, (Date) discount.getStartDate());
            cs.setDate(5, (Date) discount.getEndDate());
            cs.setString(6,discount.getIdDiscount());
            cs.setInt(7, 0);
            result = cs.executeUpdate();
            con.close();
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return result;
    }
    
    
    
}
