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
import pe.edu.pucp.inf.mateproyecto.dao.DAOArea;
import pe.edu.pucp.inf.mateproyecto.model.bean.Area;

/**
 *
 * @author Usuario
 */
public class MySQLArea implements DAOArea {

    @Override
    public int insert(Area area){
        int result = 0;
        try{
            DBManager dbManager = DBManager.getDbManager();
            Connection con = DriverManager.getConnection(dbManager.getUrl(), dbManager.getUser(), dbManager.getPassword());
            CallableStatement cs = con.prepareCall("{call InsertArea(?,?,?,?,?)}");
            cs.setString(1, area.getAbbreviation());
            cs.setString(2, area.getDescription());
            cs.setString(3, area.getIdArea());
            cs.setInt(4, area.getState());
            result = cs.executeUpdate();
                       
            con.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return result;
     
          
    }

    @Override
    public ArrayList<Area> queryAll(){
        ArrayList<Area> listAreas = new ArrayList<Area>();
        try{
            DBManager dbManager = DBManager.getDbManager();
            Connection con = DriverManager.getConnection(dbManager.getUrl(), dbManager.getUser(), dbManager.getPassword());
            CallableStatement cs = con.prepareCall("{call GetAllAreas()}");
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                Area area = new Area();
                area.setId(rs.getInt("AreaID"));
                area.setAbbreviation(rs.getString("Abbreviation"));
                area.setDescription(rs.getString("Description"));
                area.setIdArea(rs.getString("Id"));
                       
                listAreas.add(area);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return listAreas;
    }

    @Override
    public int update(Area area) {
        int result = 0;
        try{
            DBManager dbManager = DBManager.getDbManager();
            Connection con = DriverManager.getConnection(dbManager.getUrl(), dbManager.getUser(), dbManager.getPassword());
            CallableStatement cs = con.prepareCall("{call UpdateArea(?,?,?,?,?)}");
            cs.setString(1, area.getAbbreviation());
            cs.setString(2, area.getDescription());
            cs.setInt(3, area.getState());
            cs.setString(4, "Usuario Modificador");
            cs.setString(5, area.getIdArea());
            result = cs.executeUpdate();
            con.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return result;
    }

    @Override
    public int delete(Area area) {
        int result = 0;
        try{
            DBManager dbManager = DBManager.getDbManager();
            Connection con = DriverManager.getConnection(dbManager.getUrl(), dbManager.getUser(), dbManager.getPassword());
            CallableStatement cs = con.prepareCall("{call UpdateArea(?,?,?,?,?)}");
            cs.setString(1, area.getAbbreviation());
            cs.setString(2, area.getDescription());
            cs.setInt(3, 0);
            cs.setString(4, "Usuario Modificador");
            cs.setString(5, area.getIdArea());
            result = cs.executeUpdate();
            con.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return result;
    }
    
    
    

    
    
}
