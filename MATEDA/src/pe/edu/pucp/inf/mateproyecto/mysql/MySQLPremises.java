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
import pe.edu.pucp.inf.mateproyecto.dao.DAOPremises;
import pe.edu.pucp.inf.mateproyecto.model.bean.Premises;

/**
 *
 * @author Usuario
 */
public class MySQLPremises implements DAOPremises{

    @Override
    public int insert(Premises premises) {
       int result = 0;
        try{
            DBManager dbManager = DBManager.getDbManager();
            Connection con = DriverManager.getConnection(dbManager.getUrl(), dbManager.getUser(), dbManager.getPassword());
            CallableStatement cs = con.prepareCall("{call InsertPremises(?,?,?,?)}");
               
            cs.setString(1, premises.getAddress());
            cs.setString(2, premises.getDescription());
            cs.setInt(3, premises.getState());
            result = cs.executeUpdate();
            
            con.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return result;
    }

    @Override
    public ArrayList<Premises> queryAll() {
        ArrayList<Premises> listPremises = new ArrayList<Premises>();
        try{
            DBManager dbManager = DBManager.getDbManager();
            Connection con = DriverManager.getConnection(dbManager.getUrl(), dbManager.getUser(), dbManager.getPassword());
            CallableStatement cs = con.prepareCall("{call GetAllPremises()}");
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                Premises premises = new Premises();
                premises.setAddress(rs.getString("Address"));
                premises.setDescription(rs.getString("Description"));
                premises.setId(rs.getInt("PremisesID"));
                premises.setState(rs.getInt("State"));
                      
                listPremises.add(premises);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return listPremises;
    }

    @Override
    public int update(Premises premises) {
        int result = 0;
        try{
            DBManager dbManager = DBManager.getDbManager();
            Connection con = DriverManager.getConnection(dbManager.getUrl(), dbManager.getUser(), dbManager.getPassword());
            CallableStatement cs = con.prepareCall("{call UpdatePremises(?,?,?,?,?)}");
            cs.setString(1, premises.getAddress());
            cs.setString(2, premises.getDescription());
            cs.setInt(3, premises.getState());
            cs.setString(4, "Usuario Modificador");
            cs.setInt(5, premises.getId());
            result = cs.executeUpdate();
            cs.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return result;
    }

    @Override
    public int delete(Premises premises) {
        int result = 0;
        try{
            DBManager dbManager = DBManager.getDbManager();
            Connection con = DriverManager.getConnection(dbManager.getUrl(), dbManager.getUser(), dbManager.getPassword());
            CallableStatement cs = con.prepareCall("{call UpdatePremises(?,?,?,?,?,?)}");
            cs.setString(1, premises.getAddress());
            cs.setString(2, premises.getDescription());
            cs.setInt(3, 0);
            cs.setString(4, "Usuario Modificador");
            cs.setInt(5, premises.getId());
            result = cs.executeUpdate();
            cs.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return result;
    }

    @Override
    public Premises queryPremises(String infPremises) {
        Premises premises = new Premises();
        try{
            DBManager dbManager = DBManager.getDbManager();
            Connection con = DriverManager.getConnection(dbManager.getUrl(), dbManager.getUser(), dbManager.getPassword());
            CallableStatement cs = con.prepareCall("{call GetPremisesByName(?)}");
            cs.setString(1,infPremises);
            ResultSet rs = cs.executeQuery();
            rs.next();
            
            premises.setAddress(rs.getString("Address"));
            premises.setDescription(rs.getString("Description"));
            premises.setId(rs.getInt("PremisesID"));
            premises.setState(rs.getInt("State"));
             
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return premises;
    }
    
    
}

