/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.inf.mateproyecto.mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.inf.mateproyecto.config.DBManager;
import pe.edu.pucp.inf.mateproyecto.dao.DAOSupplier;
import pe.edu.pucp.inf.mateproyecto.model.bean.Supplier;

/**
 *
 * @author Usuario
 */
public class MySQLSupplier implements DAOSupplier{

    @Override
    public int insert(Supplier supplier) {
        int result = 0;
        try{
            DBManager dbManager = DBManager.getDbManager();
            Connection con = DriverManager.getConnection(dbManager.getUrl(), dbManager.getUser(), dbManager.getPassword());
            CallableStatement cs = con.prepareCall("{call InsertSupplier(?,?,?,?,?,?,?,?,?,?,?)}");
            cs.setString(1, supplier.getAddress());
            cs.setString(2,supplier.getBankData());
            cs.setString(3, supplier.getContactEmail());
            cs.setString(4, supplier.getContactPerson());
            cs.setString(5, supplier.getContactPhone());
            cs.setString(6, supplier.getName());
            cs.setString(7, supplier.getRUC());
            cs.setInt(8, supplier.getState());
            cs.setString(9, supplier.getSupplierCode());
            cs.setString(10, supplier.getTermOfSale());        
          
            result = cs.executeUpdate();
            con.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return result;
    }
    
    


    @Override
    public int insertArtist(int idArtist, int idSupplier) {
        int result = 0;
        try{
            DBManager dbManager = DBManager.getDbManager();
            Connection con = DriverManager.getConnection(dbManager.getUrl(), dbManager.getUser(), dbManager.getPassword());
            CallableStatement cs = con.prepareCall("{call UpdateArtistSupplier(?,?)}");
            cs.setInt(1, idArtist );
            cs.setInt(2, idSupplier );
            result = cs.executeUpdate();
            con.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return result;
    
    
    }

    @Override
    public ArrayList<Supplier> queryAll() {
        
        ArrayList<Supplier> listSuppliers = new ArrayList<Supplier>();
        try{
            DBManager dbManager = DBManager.getDbManager();
            Connection con = DriverManager.getConnection(dbManager.getUrl(), dbManager.getUser(), dbManager.getPassword());
            
            CallableStatement cs = con.prepareCall("{call GetAllSuppliers()}");
            ResultSet rs = cs.executeQuery();
            
            while(rs.next()){
                                      
                Supplier supplier = new Supplier();
                
                supplier.setAddress(rs.getString("Address"));
                supplier.setBankData(rs.getString("Bankdata"));
                supplier.setContactEmail(rs.getString("Contactemail"));
                supplier.setContactPerson(rs.getString("Contactperson"));
                supplier.setContactPhone(rs.getString("Contactphone"));
                supplier.setId(rs.getInt("SupplierID"));
                supplier.setName(rs.getString("Name"));
                supplier.setRUC(rs.getString("RUC"));
                supplier.setState(rs.getInt("State"));
                supplier.setSupplierCode(rs.getString("Suppliercode"));
                supplier.setTermOfSale(rs.getString("TermOfSale"));
                                
                listSuppliers.add(supplier);
            }
            con.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return listSuppliers;

    
    }

    @Override
    public int update(Supplier supplier) {
        int result = 0;
        try{
            DBManager dbManager = DBManager.getDbManager();
            Connection con = DriverManager.getConnection(dbManager.getUrl(), dbManager.getUser(), dbManager.getPassword());

            CallableStatement cs = con.prepareCall("{call UpdateSupplier(?,?,?,?,?,?,?,?,?,?,?)}");
            cs.setString(1, supplier.getAddress());
            cs.setString(2,supplier.getBankData());
            cs.setString(3, supplier.getContactEmail());
            cs.setString(4, supplier.getContactPerson());
            cs.setString(5, supplier.getContactPhone());
            cs.setString(6, supplier.getName());
            cs.setString(7, supplier.getRUC());
            cs.setInt(8, supplier.getState());
            cs.setString(9, supplier.getSupplierCode());
            cs.setString(10, supplier.getTermOfSale());   
            cs.setInt(11, supplier.getId());
          
            result = cs.executeUpdate();
            con.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return result;  
    }

    @Override
    public Supplier querySupplier(String infCustomer) {
        Supplier supplier = new Supplier();
        try{
            DBManager dbManager = DBManager.getDbManager();
            Connection con = DriverManager.getConnection(dbManager.getUrl(), dbManager.getUser(), dbManager.getPassword());
            
            CallableStatement cs = con.prepareCall("{call GetSupplierBySupplierCode(?)}");
            cs.setString(1, infCustomer);
            ResultSet rs = cs.executeQuery();
            
            rs.next();
                                      
               
                
                supplier.setAddress(rs.getString("Address"));
                supplier.setBankData(rs.getString("Bankdata"));
                supplier.setContactEmail(rs.getString("Contactemail"));
                supplier.setContactPerson(rs.getString("Contactperson"));
                supplier.setContactPhone(rs.getString("Contactphone"));
                supplier.setId(rs.getInt("SupplierID"));
                supplier.setName(rs.getString("Name"));
                supplier.setRUC(rs.getString("RUC"));
                supplier.setState(rs.getInt("State"));
                supplier.setSupplierCode(rs.getString("Suppliercode"));
                supplier.setTermOfSale(rs.getString("TermOfSale"));
                                
               
            
            con.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return supplier;
    }

}
