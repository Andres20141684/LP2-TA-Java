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
import pe.edu.pucp.inf.mateproyecto.dao.DAOBrand;
import pe.edu.pucp.inf.mateproyecto.model.bean.Brand;

/**
 *
 * @author Usuario
 */
public class MySQLBrand implements DAOBrand{

    @Override
    public int insert(Brand brand) {
        int result = 0;
        try{
            DBManager dbManager = DBManager.getDbManager();
            Connection con = DriverManager.getConnection(dbManager.getUrl(), dbManager.getUser(), dbManager.getPassword());
            CallableStatement cs = con.prepareCall("{call InsertArea(?,?,?,?,?)}");
               
            cs.setString(1, brand.getName());
            cs.setString(2, brand.getDescription());
            cs.setString(3, brand.getBrandID());
            cs.setInt(4, brand.getState());
            result = cs.executeUpdate();
                     
            
            
            con.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return result;
    }

    @Override
    public ArrayList<Brand> queryAll() {
        ArrayList<Brand> listBrands = new ArrayList<Brand>();
        try{
            DBManager dbManager = DBManager.getDbManager();
            Connection con = DriverManager.getConnection(dbManager.getUrl(), dbManager.getUser(), dbManager.getPassword());
            CallableStatement cs = con.prepareCall("{call GetAllBrands()}");
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                Brand brand = new Brand();
                brand.setName(rs.getString("Name"));
                brand.setDescription(rs.getString("Description"));
                brand.setId(rs.getInt("Id"));
                brand.setBrandID(rs.getString("BrandID"));
                            
                listBrands.add(brand);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return listBrands;
    }

    @Override
    public int update(Brand brand) {
        int result = 0;
        try{
            DBManager dbManager = DBManager.getDbManager();
            Connection con = DriverManager.getConnection(dbManager.getUrl(), dbManager.getUser(), dbManager.getPassword());
            CallableStatement cs = con.prepareCall("{call UpdateBrand(?,?,?,?,?)}");
            cs.setString(1, brand.getBrandID());
            cs.setString(2, brand.getDescription());
            cs.setString(3, brand.getName());
            cs.setInt(4, brand.getState());
            cs.setString(5, "Usuario Modificador");
            result = cs.executeUpdate();
            con.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return result;
    }

    @Override
    public int delete(Brand brand) {
        int result = 0;
        try{
            DBManager dbManager = DBManager.getDbManager();
            Connection con = DriverManager.getConnection(dbManager.getUrl(), dbManager.getUser(), dbManager.getPassword());
            CallableStatement cs = con.prepareCall("{call UpdateBrand(?,?,?,?,?)}");
            cs.setString(1, brand.getBrandID());
            cs.setString(2, brand.getDescription());
            cs.setString(3, brand.getName());
            cs.setInt(4, 0);
            cs.setString(5, "Usuario Modificador");
            result = cs.executeUpdate();
            con.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return result;
    }
    
    
    
}
