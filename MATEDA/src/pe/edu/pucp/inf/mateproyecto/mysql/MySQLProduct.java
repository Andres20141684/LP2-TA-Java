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
import java.util.Date;
import pe.edu.pucp.inf.mateproyecto.config.DBManager;
import pe.edu.pucp.inf.mateproyecto.dao.DAOProduct;
import pe.edu.pucp.inf.mateproyecto.model.bean.Brand;
import pe.edu.pucp.inf.mateproyecto.model.bean.Discount;
import pe.edu.pucp.inf.mateproyecto.model.bean.Family;
import pe.edu.pucp.inf.mateproyecto.model.bean.Product;

/**
 *
 * @author Usuario
 */
public class MySQLProduct implements DAOProduct {

    @Override
    public int insert(Product product) {
        int result = 0;
        try{
            DBManager dbManager = DBManager.getDbManager();
            Connection con = DriverManager.getConnection(dbManager.getUrl(), dbManager.getUser(), dbManager.getPassword());
            CallableStatement cs = con.prepareCall("{call InsertProduct(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            cs.setInt(1, product.getAvailability());
            cs.setString(2,product.getName());
            cs.setFloat(3, product.getIgv());
            cs.setString(4, product.getProductCareDescription());
            cs.setString(5, product.getProductDescription());
            cs.setFloat(6, product.getPurchasePrice());
            cs.setFloat(7, product.getSalePrice());
            cs.setString(8, product.getSKUcode());
            cs.setInt(9, product.getState());
            cs.setInt(10, product.getStock());
            cs.setInt(11, product.getFamily().getId()); 
            cs.setInt(12, product.getBrand().getId());
            cs.setInt(13, product.getDiscount().getId());
                 
            result = cs.executeUpdate();
            con.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return result;
    }

    @Override
    public int update(Product product) {
        
        int result = 0;
        try{
            DBManager dbManager = DBManager.getDbManager();
            Connection con = DriverManager.getConnection(dbManager.getUrl(), dbManager.getUser(), dbManager.getPassword());
            CallableStatement cs = con.prepareCall("{call UpdateProduct(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            cs.setInt(1, product.getId());
            cs.setInt(2, product.getAvailability());
            cs.setString(3,product.getName());
            cs.setFloat(4, product.getIgv());
            cs.setString(5, product.getProductCareDescription());
            cs.setString(6, product.getProductDescription());
            cs.setFloat(7, product.getPurchasePrice());
            cs.setFloat(8, product.getSalePrice());
            cs.setString(9, product.getSKUcode());
            cs.setInt(10, product.getState());
            cs.setInt(11, product.getStock());
            cs.setInt(12, product.getFamily().getId());
            cs.setInt(13, product.getBrand().getId());
            cs.setInt(14, product.getDiscount().getId());
            result = cs.executeUpdate();
            con.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return result;
    
    }

    @Override
    public ArrayList<Product> queryAll() {
        ArrayList<Product> listProducts = new ArrayList<Product>();
        try{
            DBManager dbManager = DBManager.getDbManager();
            Connection con = DriverManager.getConnection(dbManager.getUrl(), dbManager.getUser(), dbManager.getPassword());
            CallableStatement cs = con.prepareCall("{call GetAllProducts()}");
            ResultSet rs = cs.executeQuery();
            
            while(rs.next()){
                Product product = new Product();
                product.setAvailability(rs.getInt("Availability"));
                product.setId(rs.getInt("Id"));
                product.setName(rs.getString("NameProduct"));
                product.setIgv(rs.getFloat("Igv"));
                product.setProductCareDescription(rs.getString("ProductCareDescription"));
                product.setProductDescription(rs.getString("ProductDescription"));
                product.setPurchasePrice(rs.getFloat("PurchasePrice"));
                product.setSalePrice(rs.getFloat("SalePrice"));
                product.setSKUcode(rs.getString("SKUcode"));
                product.setState(rs.getInt("State"));
                product.setStock(rs.getInt("Stock"));
                
                CallableStatement cs4 = con.prepareCall("{call GetDiscountById(?)}");
                cs4.setInt(1,  rs.getInt("DiscountID")   );
                ResultSet rs4 = cs4.executeQuery();
                rs4.next();
                Discount discount = new Discount( rs4.getString("DiscountID"),  rs4.getString("DiscountID") ,(Date) rs4.getDate("Startdate"),(Date)rs4.getDate("Enddate"), rs4.getFloat("Discountamount"), rs4.getInt("State"));
                discount.setId(rs.getInt("DiscountID"));
                product.setDiscount(discount);

                CallableStatement cs2 = con.prepareCall("{call GetFamilyById(?)}");
                cs2.setInt(1,  rs.getInt("Family_FamilyID")   );
                ResultSet rs2 = cs2.executeQuery();
                rs2.next();
                Family family = new Family( rs2.getString("Name"), rs2.getString("Description"), rs2.getInt("State"),  rs2.getString("FamilyID"));
                product.setFamily(family);
                
                CallableStatement cs3 = con.prepareCall("{call GetBrandById(?)}");
                cs3.setInt(1, rs.getInt("Brand_BrandID"));
                ResultSet rs3 = cs3.executeQuery();
                rs3.next();
                Brand brand = new Brand( rs3.getString("Description"), rs3.getString("Name"), rs3.getInt("State"),  rs3.getString("BrandID"));
                product.setBrand(brand);
                                     
                listProducts.add(product);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return listProducts;
        
        
    }

    @Override
    public int insertDiscount(int idDiscount, int idProduct) {
        int result = 0;
        try{
            DBManager dbManager = DBManager.getDbManager();
            Connection con = DriverManager.getConnection(dbManager.getUrl(), dbManager.getUser(), dbManager.getPassword());
            CallableStatement cs = con.prepareCall("{call UpdateDiscountProduct(?,?)}");
            cs.setInt(1, idDiscount );
            cs.setInt(2, idProduct );
            result = cs.executeUpdate();
            con.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return result;
    }

    @Override
    public Product queryProduct(String infProduct) {
        Product product = new Product();
        try{
            DBManager dbManager = DBManager.getDbManager();
            Connection con = DriverManager.getConnection(dbManager.getUrl(), dbManager.getUser(), dbManager.getPassword());
            CallableStatement cs = con.prepareCall("{call GetProductBySkucode(?)}");
            cs.setString(1,infProduct);
            ResultSet rs = cs.executeQuery();
            
            rs.next();
                
            product.setAvailability(rs.getInt("Availability"));
            product.setId(rs.getInt("Id"));
            product.setName(rs.getString("NameProduct"));
            product.setIgv(rs.getFloat("Igv"));
            product.setProductCareDescription(rs.getString("ProductCareDescription"));
            product.setProductDescription(rs.getString("ProductDescription"));
            product.setPurchasePrice(rs.getFloat("PurchasePrice"));
            product.setSalePrice(rs.getFloat("SalePrice"));
            product.setSKUcode(rs.getString("SKUcode"));
            product.setState(rs.getInt("State"));
            product.setStock(rs.getInt("Stock"));
            
                    
            CallableStatement cs4 = con.prepareCall("{call GetDiscountById(?)}");
            cs4.setInt(1,  rs.getInt("DiscountID")   );
            ResultSet rs4 = cs4.executeQuery();
            rs4.next();
            Discount discount = new Discount( rs4.getString("DiscountID"),  rs4.getString("DiscountID") ,(Date) rs4.getDate("Startdate"),(Date)rs4.getDate("Enddate"), rs4.getFloat("Discountamount"), rs4.getInt("State"));
            discount.setId(rs.getInt("DiscountID"));
            product.setDiscount(discount);

            CallableStatement cs2 = con.prepareCall("{call GetFamilyById(?)}");
            cs2.setInt(1,  rs.getInt("Family_FamilyID")   );
            ResultSet rs2 = cs2.executeQuery();
            rs2.next();
            Family family = new Family( rs2.getString("Name"), rs2.getString("Description"), rs2.getInt("State"),  rs2.getString("FamilyID"));
            product.setFamily(family);
                
            CallableStatement cs3 = con.prepareCall("{call GetBrandById(?)}");
            cs3.setInt(1, rs.getInt("Brand_BrandID"));
            ResultSet rs3 = cs3.executeQuery();
            rs3.next();
            Brand brand = new Brand( rs3.getString("Description"), rs3.getString("Name"), rs3.getInt("State"),  rs3.getString("BrandID"));
            product.setBrand(brand);
                                     
         
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return product;
    }
    
    
    
    
}
