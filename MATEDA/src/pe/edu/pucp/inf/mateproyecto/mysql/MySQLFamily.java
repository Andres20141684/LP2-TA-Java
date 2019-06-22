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
import pe.edu.pucp.inf.mateproyecto.dao.DAOFamily;
import pe.edu.pucp.inf.mateproyecto.model.bean.Brand;
import pe.edu.pucp.inf.mateproyecto.model.bean.Family;

/**
 *
 * @author Usuario
 */
public class MySQLFamily implements DAOFamily{

    @Override
    public int insert(Family family) {
        int result = 0;
        try{
            DBManager dbManager = DBManager.getDbManager();
            Connection con = DriverManager.getConnection(dbManager.getUrl(), dbManager.getUser(), dbManager.getPassword());
            CallableStatement cs = con.prepareCall("{call InsertFamily(?,?,?,?,?)}");
                   
            cs.setString(1, family.getDescription());
            cs.setString(2, family.getIdFamily());
            cs.setString(3, family.getName());
            cs.setInt(4, family.getState());
            result = cs.executeUpdate();
            
            con.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return result;
    }

    @Override
    public ArrayList<Family> queryALL() {
       ArrayList<Family> listFamilies = new ArrayList<Family>();
        try{
            DBManager dbManager = DBManager.getDbManager();
            Connection con = DriverManager.getConnection(dbManager.getUrl(), dbManager.getUser(), dbManager.getPassword());
            CallableStatement cs = con.prepareCall("{call GetAllFamilies()}");
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                Family family = new Family();
                family.setName(rs.getString("Name"));
                family.setDescription(rs.getString("Description"));
                family.setId(rs.getInt("Id"));
                family.setIdFamily(rs.getString("FamilyID"));
                family.setState(rs.getInt("State"));
                listFamilies.add(family);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return listFamilies;
        
        
    }

    @Override
    public int update(Family family) {
        int result = 0;
        try{
            DBManager dbManager = DBManager.getDbManager();
            Connection con = DriverManager.getConnection(dbManager.getUrl(), dbManager.getUser(), dbManager.getPassword());
            CallableStatement cs = con.prepareCall("{call UpdateFamily(?,?,?,?,?)}");
            cs.setString(1, family.getIdFamily());
            cs.setString(2, family.getName());
            cs.setString(3, family.getDescription());
            cs.setInt(4, family.getState());
            cs.setString(5, "Usuario Modificador");
            result = cs.executeUpdate();
            con.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return result;
    }


    @Override
    public int delete(Family family) {
        int result = 0;
        try{
            DBManager dbManager = DBManager.getDbManager();
            Connection con = DriverManager.getConnection(dbManager.getUrl(), dbManager.getUser(), dbManager.getPassword());
            CallableStatement cs = con.prepareCall("{call UpdateFamily(?,?,?,?,?,?,?,?,?)}");
            cs.setString(1, family.getIdFamily());
            cs.setString(2, family.getName());
            cs.setString(3, family.getDescription());
            cs.setInt(4, 0);
            cs.setString(5, "Usuario Modificador");
            result = cs.executeUpdate();
            con.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return result;
    }

    @Override
    public Family queryFamily(String infFamily) {
        Family family = new Family();
        try{
            DBManager dbManager = DBManager.getDbManager();
            Connection con = DriverManager.getConnection(dbManager.getUrl(), dbManager.getUser(), dbManager.getPassword());
            CallableStatement cs = con.prepareCall("{call GetFamilyByFamilyCode(?)}");
            cs.setString(1, infFamily);
            ResultSet rs = cs.executeQuery();
            rs.next();
            family.setName(rs.getString("Name"));
            family.setDescription(rs.getString("Description"));
            family.setId(rs.getInt("Id"));
            family.setIdFamily(rs.getString("FamilyID"));
            family.setState(rs.getInt("State"));
          
                
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return family;
    
    
    
    }
    
    
    
}
