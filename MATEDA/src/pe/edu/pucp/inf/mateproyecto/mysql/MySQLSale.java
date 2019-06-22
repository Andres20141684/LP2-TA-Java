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
import pe.edu.pucp.inf.mateproyecto.dao.DAOSale;
import pe.edu.pucp.inf.mateproyecto.model.bean.Customer;
import pe.edu.pucp.inf.mateproyecto.model.bean.Employee;
import pe.edu.pucp.inf.mateproyecto.model.bean.Product;
import pe.edu.pucp.inf.mateproyecto.model.bean.Sale;
import pe.edu.pucp.inf.mateproyecto.model.bean.SaleLane;

/**
 *
 * @author Usuario
 */
public class MySQLSale implements DAOSale{

    @Override
    public int insert(Sale sale) {
        int result = 0;
        try{
            DBManager dbManager = DBManager.getDbManager();
            Connection con = DriverManager.getConnection(dbManager.getUrl(), dbManager.getUser(), dbManager.getPassword());
            CallableStatement cs = con.prepareCall("{call InsertSale(?,?,?,?,?,?)}");
            cs.setString(1, sale.getSerialCode());
            cs.setInt(2,sale.getState());
            cs.setFloat(3,sale.getTotalSale());
            cs.setInt(4, sale.getEmployee().getIdEmployee());
            cs.setInt(5, sale.getCustomer().getIdCustomer());
            
            //insert detail - sale for (lineSale:sale.getLineSale()) lo de arriba con linesale e insrtar cada cosa
            //cs.registerOutParameter("_SaleID",java.sql.Types.INTEGER);
            cs.registerOutParameter(6, Types.INTEGER);
            result = cs.executeUpdate();
            
            CallableStatement cs2 = con.prepareCall("{call InsertSaleLane(?,?,?,?,?)}");
            
            for (SaleLane sl: sale.getSaleLanes()){
                cs2.setFloat(1, sl.getSubtotal());
                cs2.setInt(2, sl.getQuantity());
                cs2.setInt(3, cs.getInt("_SaleID"));
                cs2.setInt(4, sl.getProduct().getId());
                cs2.executeUpdate();
            }
           
            con.close();
           
            
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }
        return result;
                
    }
    
    @Override
    public ArrayList<Sale> queryALL() {
        ArrayList<Sale> listSales = new ArrayList<Sale>();
        try{
            DBManager dbManager = DBManager.getDbManager();
            Connection con = DriverManager.getConnection(dbManager.getUrl(), dbManager.getUser(), dbManager.getPassword());
            CallableStatement cs = con.prepareCall("{call GetAllSales()}");
            ResultSet rs = cs.executeQuery();
            CallableStatement cs2 = con.prepareCall("{call GetCustomerById(?)}");
            CallableStatement cs3 = con.prepareCall("{call GetAllSaleLaneById(?)}");
            CallableStatement cs4 = con.prepareCall("{call GetProductById(?)}");
            
                      
            while(rs.next()){
                Sale sale = new Sale();
                sale.setId(rs.getInt("SaleID"));
                sale.setTotalSale(rs.getFloat("TotalSale"));
                sale.setState(rs.getInt("State"));
                sale.setSerialCode(rs.getString("Serialcode"));
                
                Customer customer = new Customer();
                
                cs2.setInt(1, rs.getInt("Customer_CustomerID"));
                ResultSet rs2 = cs2.executeQuery();
                rs2.next();
                
                //customer
                customer.setAddress(rs2.getString("Address"));
                customer.setDescriptionCustomer(rs2.getString("Descriptioncustomer"));
                customer.setEmail(rs2.getString("Email"));
                customer.setIdCustomer(rs2.getInt("CustomerID"));
                customer.setId(rs2.getString("Id"));
                customer.setKindOfCustomer(rs2.getString("Kinfofcustomer"));
                customer.setOccupation(rs2.getString("Occupation"));
                customer.setPhone(rs2.getString("Phone"));
                customer.setState(rs2.getInt("State"));        
                
                sale.setCustomer(customer);
                               
                //employee
                MySQLEmployee employeeControl = new MySQLEmployee();
                Employee employee = employeeControl.queryById(rs.getInt("EmployeeID"));
                sale.setEmployee(employee);
                //líneas de venta
                
                cs3.setInt(1, rs.getInt("SaleID"));
                ResultSet rs3 = cs3.executeQuery();
                ArrayList<SaleLane> listSaleLanes = new ArrayList<SaleLane>();
                while(rs3.next()){
                    Product product = new Product();
                    cs4.setInt(1,rs3.getInt("PRODUCT_Id"));
                    ResultSet rs4 = cs4.executeQuery();
                    rs4.next();
                    product.setAvailability(rs4.getInt("Availability"));
                    product.setId(rs4.getInt("Id"));
                    product.setName(rs4.getString("NameProduct"));
                    product.setIgv(rs4.getFloat("Igv"));
                    product.setProductCareDescription(rs4.getString("ProductCareDescription"));
                    product.setProductDescription(rs4.getString("ProductDescription"));
                    product.setPurchasePrice(rs4.getFloat("PurchasePrice"));
                    product.setSalePrice(rs4.getFloat("SalePrice"));
                    product.setSKUcode(rs4.getString("SKUcode"));
                    product.setState(rs4.getInt("State"));
                    product.setStock(rs4.getInt("Stock"));
                    
                    
                    SaleLane salelane= new SaleLane();
                    salelane.setIdSaleLane(rs3.getInt("SalelaneID"));
                    salelane.setProduct(product);
                    salelane.setQuantity(rs3.getInt("Quantity"));
                    salelane.setSubtotal(rs3.getFloat("Subtotal"));
                    
                    listSaleLanes.add(salelane);
                }
                
                sale.setSaleLanes(listSaleLanes);
                listSales.add(sale);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return listSales;

        
        
        
    }

    @Override
    public Sale querySale(String infSale) {
        Sale sale = new Sale();
        try{
            DBManager dbManager = DBManager.getDbManager();
            Connection con = DriverManager.getConnection(dbManager.getUrl(), dbManager.getUser(), dbManager.getPassword());
            CallableStatement cs = con.prepareCall("{call GetSaleBySerialcode(?)}");
            cs.setString(1, infSale);
            ResultSet rs = cs.executeQuery();
            
            CallableStatement cs2 = con.prepareCall("{call GetCustomerById(?)}");
            CallableStatement cs3 = con.prepareCall("{call GetAllSaleLaneById(?)}");
            CallableStatement cs4 = con.prepareCall("{call GetProductById(?)}");
            
                      
            rs.next();
                
            sale.setId(rs.getInt("SaleID"));
            sale.setTotalSale(rs.getFloat("TotalSale"));
            sale.setState(rs.getInt("State"));
            sale.setSerialCode(rs.getString("Serialcode"));
                
            Customer customer = new Customer();
               
            cs2.setInt(1, rs.getInt("Customer_CustomerID"));
            ResultSet rs2 = cs2.executeQuery();
            rs2.next();
                
            //customer
            customer.setAddress(rs2.getString("Address"));
            customer.setDescriptionCustomer(rs2.getString("Descriptioncustomer"));
            customer.setEmail(rs2.getString("Email"));
            customer.setIdCustomer(rs2.getInt("CustomerID"));
            customer.setId(rs2.getString("Id"));
            customer.setKindOfCustomer(rs2.getString("Kinfofcustomer"));
            customer.setOccupation(rs2.getString("Occupation"));
            customer.setPhone(rs2.getString("Phone"));
            customer.setState(rs2.getInt("State"));        
                
            sale.setCustomer(customer);
                               
                //employee
            MySQLEmployee employeeControl = new MySQLEmployee();
            Employee employee = employeeControl.queryById(rs.getInt("EmployeeID"));
            sale.setEmployee(employee);
                //líneas de venta
                
            cs3.setInt(1, rs.getInt("SaleID"));
            ResultSet rs3 = cs3.executeQuery();
            ArrayList<SaleLane> listSaleLanes = new ArrayList<SaleLane>();
            while(rs3.next()){
                    Product product = new Product();
                    cs4.setInt(1,rs3.getInt("PRODUCT_Id"));
                    ResultSet rs4 = cs4.executeQuery();
                    rs4.next();
                    product.setAvailability(rs4.getInt("Availability"));
                    product.setId(rs4.getInt("Id"));
                    product.setName(rs4.getString("NameProduct"));
                    product.setIgv(rs4.getFloat("Igv"));
                    product.setProductCareDescription(rs4.getString("ProductCareDescription"));
                    product.setProductDescription(rs4.getString("ProductDescription"));
                    product.setPurchasePrice(rs4.getFloat("PurchasePrice"));
                    product.setSalePrice(rs4.getFloat("SalePrice"));
                    product.setSKUcode(rs4.getString("SKUcode"));
                    product.setState(rs4.getInt("State"));
                    product.setStock(rs4.getInt("Stock"));
                    
                    
                    SaleLane salelane= new SaleLane();
                    salelane.setIdSaleLane(rs3.getInt("SalelaneID"));
                    salelane.setProduct(product);
                    salelane.setQuantity(rs3.getInt("Quantity"));
                    salelane.setSubtotal(rs3.getFloat("Subtotal"));
                    
                    listSaleLanes.add(salelane);
                }
                
                sale.setSaleLanes(listSaleLanes);
                
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return sale;    
        
        
        
    }

    @Override
    public int update(Sale sale) {
        int result = 0;
        try{
            DBManager dbManager = DBManager.getDbManager();
            Connection con = DriverManager.getConnection(dbManager.getUrl(), dbManager.getUser(), dbManager.getPassword());
            CallableStatement cs = con.prepareCall("{call UpdateSale(?,?,?,?,?,?)}");
            cs.setString(1, sale.getSerialCode());
            cs.setInt(2,sale.getState());
            cs.setFloat(3,sale.getTotalSale());
            cs.setInt(4, sale.getEmployee().getIdEmployee());
            cs.setInt(5, sale.getCustomer().getIdCustomer());
            cs.setInt(6, sale.getId());
            result = cs.executeUpdate();
            
            CallableStatement cs2 = con.prepareCall("{call UpdateSaleLane(?,?,?,?,?)}");
            
            for (SaleLane sl: sale.getSaleLanes()){
                cs2.setFloat(1, sl.getSubtotal());
                cs2.setInt(2, sl.getQuantity());
                cs2.setInt(3, sale.getId());
                cs2.setInt(4, sl.getProduct().getId());
                cs2.setInt(5, sl.getIdSaleLane());
                cs2.executeUpdate();
            }
            con.close();
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return result;
    }


    
}
