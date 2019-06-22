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
import java.sql.Types;
import java.util.ArrayList;
import pe.edu.pucp.inf.mateproyecto.config.DBManager;
import pe.edu.pucp.inf.mateproyecto.dao.DAOPurchase;
import pe.edu.pucp.inf.mateproyecto.model.bean.Product;
import pe.edu.pucp.inf.mateproyecto.model.bean.Purchase;
import pe.edu.pucp.inf.mateproyecto.model.bean.PurchaseLane;
import pe.edu.pucp.inf.mateproyecto.model.bean.Supplier;

/**
 *
 * @author Usuario
 */
public class MySQLPurchase implements DAOPurchase{

    @Override
    public int insert(Purchase purchase) {
        int result = 0;
        try{
            DBManager dbManager = DBManager.getDbManager();
            Connection con = DriverManager.getConnection(dbManager.getUrl(), dbManager.getUser(), dbManager.getPassword());
            CallableStatement cs = con.prepareCall("{call InsertPurchase(?,?,?,?,?,?)}");
                   
            cs.setString(1, purchase.getCurrency());
            cs.setString(2, purchase.getSerialCode());
            cs.setInt(3, purchase.getState());
            cs.setFloat(4,purchase.getTotalPurchase() );
            cs.setInt(5, purchase.getSupplier().getId());
             
            //cs.registerOutParameter("_PurchaseID",java.sql.Types.INTEGER);
            cs.registerOutParameter(6, Types.INTEGER);
            result = cs.executeUpdate();
            
            CallableStatement cs2 = con.prepareCall("{call InsertPurchaseLane(?,?,?,?,?)}");
            
            for (PurchaseLane pl: purchase.getPurchaseLanes()){
                cs2.setInt(1, pl.getQuantity());
                cs2.setFloat(2, pl.getSubtotal());
                cs2.setInt(3, cs.getInt("_PurchaseID"));
                cs2.setInt(4, pl.getProduct().getId());
                cs2.executeUpdate();
            }
            
            con.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return result;
    }

    @Override
    public ArrayList<Purchase> queryAll() {
        ArrayList<Purchase> listPurchases = new ArrayList<Purchase>();
        try{
            DBManager dbManager = DBManager.getDbManager();
            Connection con = DriverManager.getConnection(dbManager.getUrl(), dbManager.getUser(), dbManager.getPassword());
            CallableStatement cs = con.prepareCall("{call GetAllPurchase()}");
            ResultSet rs = cs.executeQuery();
            
            CallableStatement cs2 = con.prepareCall("{call GetSupplierById(?)}");
            CallableStatement cs3 = con.prepareCall("{call GetAllPurchasesLaneById(?)}");
            CallableStatement cs4 = con.prepareCall("{call GetProductById(?)}");
            
            
            while(rs.next()){
                Purchase purchase = new Purchase();
                purchase.setCurrency(rs.getString("Currency"));
                purchase.setId(rs.getInt("PurchaseID"));
                purchase.setSerialCode(rs.getString("Serialcode"));
                purchase.setState(rs.getInt("State"));
                
                Supplier supplier = new Supplier();
                cs2.setInt(1, rs.getInt("SupplierID"));
                ResultSet rs2 = cs2.executeQuery();
                rs2.next();
                
                //proveedor
                supplier.setAddress(rs2.getString("Address"));
                supplier.setBankData(rs2.getString("Bankdata"));
                supplier.setContactEmail(rs2.getString("Contactemail"));
                supplier.setContactPerson(rs2.getString("Contactperson"));
                supplier.setContactPhone(rs2.getString("Contactphone"));
                supplier.setId(rs2.getInt("SupplierID"));
                supplier.setName(rs2.getString("Name"));
                supplier.setRUC(rs2.getString("RUC"));
                supplier.setState(rs2.getInt("State"));
                supplier.setSupplierCode(rs2.getString("Suppliercode"));
                supplier.setTermOfSale(rs2.getString("TermOfSale"));
                
                
                purchase.setSupplier(supplier);
                purchase.setTotalPurchase(rs.getFloat("Totalpurchase"));
                
                //líneas de venta
                
                cs3.setInt(1, rs.getInt("PurchaseID"));
                ResultSet rs3 = cs3.executeQuery();
                
                ArrayList<PurchaseLane> listPurchaseLanes = new ArrayList<PurchaseLane>();
                while(rs3.next()){
                    Product product = new Product();
                    cs4.setInt(1,rs3.getInt("PRODUCT_Id"));
                    ResultSet rs4 = cs4.executeQuery();
                    rs4.next();
                    product.setAvailability(rs4.getInt("Availability"));
                    product.setId(rs4.getInt("ProductID"));
                
  
                
                    product.setName(rs4.getString("Name"));
                    product.setIgv(rs4.getFloat("Igv"));
                    product.setKindOfProduct(rs4.getString("Kindofproduct"));
                    product.setProductCareDescription(rs4.getString("Productcaredescription"));
                    product.setProductDescription(rs4.getString("Productdescription"));
                    product.setPurchasePrice(rs4.getFloat("Purchaseprice"));
                    product.setSalePrice(rs4.getFloat("Saleprice"));
                    product.setSKUcode(rs4.getString("Skucode"));
                    product.setState(rs4.getInt("State"));
                    product.setStock(rs4.getInt("Stock"));
                    
                    
                    PurchaseLane purchaselane= new PurchaseLane();
                    purchaselane.setIdPurchaseLane(rs3.getInt("PurchaselaneID"));
                    purchaselane.setProduct(product);
                    purchaselane.setQuantity(rs3.getInt("Quantity"));
                    purchaselane.setSubtotal(rs3.getFloat("Subtotal"));
                    listPurchaseLanes.add(purchaselane);
                }
                
                purchase.setPurchaseLanes(listPurchaseLanes);
                listPurchases.add(purchase);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return listPurchases;
    }

    @Override
    public Purchase queryPurchase(String infPurchase) {
        Purchase purchase = new Purchase();
        try{
            DBManager dbManager = DBManager.getDbManager();
            Connection con = DriverManager.getConnection(dbManager.getUrl(), dbManager.getUser(), dbManager.getPassword());
            CallableStatement cs = con.prepareCall("{call GetPurchaseBySerialcode(?)}");
            cs.setString(1,infPurchase);
            ResultSet rs = cs.executeQuery();
            CallableStatement cs2 = con.prepareCall("{call GetSupplierById(?)}");
            CallableStatement cs3 = con.prepareCall("{call GetAllPurchasesLaneById(?)}");
            CallableStatement cs4 = con.prepareCall("{call GetProductById(?)}");
            
            
            rs.next();
            
            purchase.setCurrency(rs.getString("Currency"));
            purchase.setId(rs.getInt("PurchaseID"));
            purchase.setSerialCode(rs.getString("Serialcode"));
            purchase.setState(rs.getInt("State"));
                
            Supplier supplier = new Supplier();
            cs2.setInt(1, rs.getInt("SupplierID"));
            ResultSet rs2 = cs2.executeQuery();
            rs2.next();
            //proveedor
            supplier.setAddress(rs2.getString("Address"));
            supplier.setBankData(rs2.getString("Bankdata"));
            supplier.setContactEmail(rs2.getString("Contactemail"));
            supplier.setContactPerson(rs2.getString("Contactperson"));
            supplier.setContactPhone(rs2.getString("Contactphone"));
            supplier.setId(rs2.getInt("SupplierID"));
            supplier.setName(rs2.getString("Name"));
            supplier.setRUC(rs2.getString("RUC"));
            supplier.setState(rs2.getInt("State"));
            supplier.setSupplierCode(rs2.getString("Suppliercode"));
            supplier.setTermOfSale(rs2.getString("TermOfSale"));
                
                
            purchase.setSupplier(supplier);
            purchase.setTotalPurchase(rs.getFloat("Totalpurchase"));
                
            //líneas de venta
                
            cs3.setInt(1, rs.getInt("PurchaseID"));
            ResultSet rs3 = cs3.executeQuery();
            
            ArrayList<PurchaseLane> listPurchaseLanes = new ArrayList<PurchaseLane>();
                while(rs3.next()){
                    Product product = new Product();
                    cs4.setInt(1,rs3.getInt("PRODUCT_Id"));
                    ResultSet rs4 = cs4.executeQuery();
                    rs4.next();
                    product.setAvailability(rs4.getInt("Availability"));
                    product.setId(rs4.getInt("ProductID"));
                    product.setName(rs4.getString("NameProduct"));
                    product.setIgv(rs4.getFloat("Igv"));
                    product.setProductCareDescription(rs4.getString("ProductCareDescription"));
                    product.setProductDescription(rs4.getString("ProductDescription"));
                    product.setPurchasePrice(rs4.getFloat("PurchasePrice"));
                    product.setSalePrice(rs4.getFloat("SalePrice"));
                    product.setSKUcode(rs4.getString("SKUcode"));
                    product.setState(rs4.getInt("State"));
                    product.setStock(rs4.getInt("Stock"));
                    
                    
                    PurchaseLane purchaselane= new PurchaseLane();
                    purchaselane.setIdPurchaseLane(rs3.getInt("PurchaselaneID"));
                    purchaselane.setProduct(product);
                    purchaselane.setQuantity(rs3.getInt("Quantity"));
                    purchaselane.setSubtotal(rs3.getFloat("Subtotal"));
                    listPurchaseLanes.add(purchaselane);
                }
            purchase.setPurchaseLanes(listPurchaseLanes);
                
                
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return purchase;
        
        
        
    }

    @Override
    public int update(Purchase purchase) {
        int result = 0;
        try{
            DBManager dbManager = DBManager.getDbManager();
            Connection con = DriverManager.getConnection(dbManager.getUrl(), dbManager.getUser(), dbManager.getPassword());
            CallableStatement cs = con.prepareCall("{call UpdatePurchase(?,?,?,?,?,?)}");
                   
            cs.setString(1, purchase.getCurrency());
            cs.setString(2, purchase.getSerialCode());
            cs.setInt(3, purchase.getState());
            cs.setFloat(4,purchase.getTotalPurchase() );
            cs.setInt(5, purchase.getSupplier().getId());
            cs.setInt(6, purchase.getId());
            result = cs.executeUpdate();
            
            CallableStatement cs2 = con.prepareCall("{call UpdatePurchaseLane(?,?,?,?,?)}");
            
            for (PurchaseLane pl: purchase.getPurchaseLanes()){
                cs2.setInt(1, pl.getQuantity());
                cs2.setFloat(2, pl.getSubtotal());
                cs2.setInt(3, purchase.getId());
                cs2.setInt(4, pl.getProduct().getId());
                cs2.setInt(5, pl.getIdPurchaseLane());
                cs2.executeUpdate();
            }
            
            con.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return result;
    }
    
    
    
}
