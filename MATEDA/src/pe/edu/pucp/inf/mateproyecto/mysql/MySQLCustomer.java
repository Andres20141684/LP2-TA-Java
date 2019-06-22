/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.inf.mateproyecto.mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.inf.mateproyecto.config.DBManager;
import pe.edu.pucp.inf.mateproyecto.dao.DAOCustomer;
import pe.edu.pucp.inf.mateproyecto.model.bean.Customer;

/**
 *
 * @author Usuario
 */
public class MySQLCustomer implements DAOCustomer{

    @Override
    public int insert(Customer customer) {
        int result = 0;
        try{
            DBManager dbManager = DBManager.getDbManager();
            Connection con = DriverManager.getConnection(dbManager.getUrl(), dbManager.getUser(), dbManager.getPassword());
            CallableStatement cs = con.prepareCall("{call InsertCustomer(?,?,?,?,?,?,?,?,?)}");
            cs.setString(1, customer.getAddress());
            cs.setString(2, customer.getDescriptionCustomer());
            cs.setString(3, customer.getEmail());
            cs.setString(4,customer.getId());
            cs.setString(5, customer.getKindOfCustomer());
            cs.setString(6,customer.getOccupation());
            cs.setString(7, customer.getPhone());
            cs.setInt(8, customer.getState());
            result = cs.executeUpdate();
            con.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return result;
        
    }

    @Override
    public int update(Customer customer) {
        int result = 0;
        try{
            DBManager dbManager = DBManager.getDbManager();
            Connection con = DriverManager.getConnection(dbManager.getUrl(), dbManager.getUser(), dbManager.getPassword());
            CallableStatement cs = con.prepareCall("{call UpdateCustomer(?,?,?,?,?,?,?,?,?)}");
            cs.setString(1, customer.getAddress());
            cs.setString(2, customer.getDescriptionCustomer());
            cs.setString(3, customer.getEmail());
            cs.setString(4, customer.getKindOfCustomer());
            cs.setString(5,customer.getOccupation());
            cs.setString(6, customer.getPhone());
            cs.setInt(7,customer.getState());
            cs.setString(8, "Usuario Modificador");
            cs.setInt(9, customer.getIdCustomer());
            result = cs.executeUpdate();
            con.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return result;
    }

    @Override
    public ArrayList<Customer> queryAll() {
        ArrayList<Customer> listCustomers = new ArrayList<Customer>();
        try{
            DBManager dbManager = DBManager.getDbManager();
            Connection con = DriverManager.getConnection(dbManager.getUrl(), dbManager.getUser(), dbManager.getPassword());
            CallableStatement cs = con.prepareCall("{call GetAllCustomers()}");
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                Customer customer = new Customer();
                customer.setAddress(rs.getString("Address"));
                customer.setDescriptionCustomer(rs.getString("Descriptioncustomer"));
                customer.setEmail(rs.getString("Email"));
                customer.setId(rs.getString("ID"));
                customer.setIdCustomer(rs.getInt("CustomerID"));
                customer.setKindOfCustomer(rs.getString("Kinfofcustomer"));
                customer.setOccupation(rs.getString("Occupation"));
                customer.setPhone(rs.getString("Phone"));
                customer.setState(rs.getInt("State"));        
                            
                listCustomers.add(customer);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return listCustomers;
    }

    @Override
    public Customer queryById(String idCustomer) {
        
        
        Customer customer = new Customer();
        try{
            DBManager dbManager = DBManager.getDbManager();
            Connection con = DriverManager.getConnection(dbManager.getUrl(), dbManager.getUser(), dbManager.getPassword());
            CallableStatement cs = con.prepareCall("{call GetCustomerByIdCustomer(?)}");
            cs.setString(1, idCustomer );
            ResultSet rs= cs.executeQuery();
            rs.next();
            customer.setAddress(rs.getString("Address"));
            customer.setDescriptionCustomer(rs.getString("Descriptioncustomer"));
            customer.setEmail(rs.getString("Email"));
            customer.setId(rs.getString("ID"));
            customer.setIdCustomer(rs.getInt("CustomerID"));
            customer.setKindOfCustomer(rs.getString("Kinfofcustomer"));
            customer.setOccupation(rs.getString("Occupation"));
            customer.setPhone(rs.getString("Phone"));
            customer.setState(rs.getInt("State"));        
            
            con.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return customer;
                
        
    }

    @Override
    public int delete(Customer customer) {
        int result = 0;
        try{
            DBManager dbManager = DBManager.getDbManager();
            Connection con = DriverManager.getConnection(dbManager.getUrl(), dbManager.getUser(), dbManager.getPassword());
            CallableStatement cs = con.prepareCall("{call UpdateCustomer(?,?,?,?,?,?,?,?,?)}");
            cs.setString(1, customer.getAddress());
            cs.setString(2, customer.getDescriptionCustomer());
            cs.setString(3, customer.getEmail());
            cs.setString(4, customer.getKindOfCustomer());
            cs.setString(5,customer.getOccupation());
            cs.setString(6, customer.getPhone());
            cs.setInt(7,0);
            cs.setString(8, "Usuario Modificador");
            cs.setInt(9, customer.getIdCustomer());
            result = cs.executeUpdate();
            con.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return result;
    }
    
}
