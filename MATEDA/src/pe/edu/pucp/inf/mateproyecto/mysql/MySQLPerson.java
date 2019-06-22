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
import pe.edu.pucp.inf.mateproyecto.dao.DAOPerson;
import pe.edu.pucp.inf.mateproyecto.model.bean.Brand;
import pe.edu.pucp.inf.mateproyecto.model.bean.Family;
import pe.edu.pucp.inf.mateproyecto.model.bean.Person;
import pe.edu.pucp.inf.mateproyecto.model.bean.Product;

/**
 *
 * @author Alexander
 */
public class MySQLPerson implements DAOPerson{

    @Override
    public int insert(Person person) {
        int result = 0;
        try{
            DBManager dbManager = DBManager.getDbManager();
            Connection con = DriverManager.getConnection(dbManager.getUrl(), dbManager.getUser(), dbManager.getPassword());
            CallableStatement cs = con.prepareCall("{call InsertPerson(?,?,?,?,?,?,?,?,?)}");
            cs.setDate(2, (Date) person.getBirthdate());
            cs.setString(3, person.getDni());
            cs.setString(4, person.getEmail());
            cs.setString(5, person.getLastName());
            cs.setString(6, person.getName());
            cs.setString(7, person.getPhone());
            cs.setString(8, person.getSecondLastName());
            cs.setInt(9, person.getState());
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return result;
    }

    @Override
    public int update(Person person) {
        int result = 0;
        try{
            DBManager dbManager = DBManager.getDbManager();
            Connection con = DriverManager.getConnection(dbManager.getUrl(), dbManager.getUser(), dbManager.getPassword());
            CallableStatement cs = con.prepareCall("{call UpdatePerson(?,?,?,?,?,?,?,?,?)}");
            cs.setInt(1, person.getPersonID());
            cs.setString(2, person.getName());
            cs.setString(3, person.getLastName());
            cs.setString(4, person.getSecondLastName());
            cs.setString(5, person.getDni());
            cs.setString(6, person.getEmail());
            cs.setString(7, person.getPhone());
            cs.setDate(8, (Date) person.getBirthdate());
            cs.setInt(9, person.getState());
            result = cs.executeUpdate();
            con.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return result;
    }

    @Override
    public int delete(Person person) {
        int result = 0;
        try{
            DBManager dbManager = DBManager.getDbManager();
            Connection con = DriverManager.getConnection(dbManager.getUrl(), dbManager.getUser(), dbManager.getPassword());
            CallableStatement cs = con.prepareCall("{call UpdatePerson(?,?,?,?,?,?,?,?,?)}");
            cs.setInt(1, person.getPersonID());
            cs.setString(2, person.getName());
            cs.setString(3, person.getLastName());
            cs.setString(4, person.getSecondLastName());
            cs.setString(5, person.getDni());
            cs.setString(6, person.getEmail());
            cs.setString(7, person.getPhone());
            cs.setDate(8, (Date) person.getBirthdate());
            cs.setInt(9, 0);
            result = cs.executeUpdate();
            con.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return result;
    }
//    @Override
//    public ArrayList<Person> queryAll() {
//        ArrayList<Person> listPerson = new ArrayList<Person>();
//        try{
//            DBManager dbManager = DBManager.getDbManager();
//            Connection con = DriverManager.getConnection(dbManager.getUrl(), dbManager.getUser(), dbManager.getPassword());
//            CallableStatement cs = con.prepareCall("{call GetAllPersons()}");
//            ResultSet rs = cs.executeQuery();
//            
//            while(rs.next()){
//                Person person = new Person();
//                person.setPersonID(rs.getInt("PersonID"));
//                person.setName(rs.getString("Name"));
//                person.getLastName(rs.getString("Lastname"));
//                person.getSecondLastName(rs.getString("Seconlastname"));
//                product.setProductCareDescription(rs.getString("ProductCareDescription"));
//                product.setProductDescription(rs.getString("ProductDescription"));
//                product.setPurchasePrice(rs.getFloat("PurchasePrice"));
//                product.setSalePrice(rs.getFloat("SalePrice"));
//                product.setSKUcode(rs.getString("SKUcode"));
//                product.setState(rs.getInt("State"));
//                product.setStock(rs.getInt("Stock"));
////              product.setDiscount(DAODiscount.queryById(rs.getInt("DiscountID")));
//
//                CallableStatement cs2 = con.prepareCall("{call GetFamilyById(?)}");
//                cs2.setInt(1,  rs.getInt("Family_FamilyID")   );
//                ResultSet rs2 = cs2.executeQuery();
//                rs2.next();
//                Family family = new Family( rs2.getString("Name"), rs2.getString("Description"), rs2.getInt("State"),  rs2.getString("FamilyID"));
//                product.setFamily(family);
//                
//                CallableStatement cs3 = con.prepareCall("{call GetBrandById(?)}");
//                cs3.setInt(1, rs.getInt("Brand_BrandID"));
//                ResultSet rs3 = cs3.executeQuery();
//                rs3.next();
//                Brand brand = new Brand( rs3.getString("Description"), rs3.getString("Name"), rs3.getInt("State"),  rs3.getString("BrandID"));
//                product.setBrand(brand);
//                                     
//                listProducts.add(product);
//            }
//        }catch(SQLException ex){
//            System.out.println(ex.getMessage());
//        }
//        return listProducts;
//        
//        
//    }
    
}
