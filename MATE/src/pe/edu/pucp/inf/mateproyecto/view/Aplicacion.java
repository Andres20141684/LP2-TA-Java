/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.inf.mateproyecto.view;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import pe.edu.pucp.inf.mateproyecto.config.DBManager;
import pe.edu.pucp.inf.mateproyecto.dao.DAOProduct;
import pe.edu.pucp.inf.mateproyecto.model.bean.Product;
import pe.edu.pucp.inf.mateproyecto.model.bean.Area;
import pe.edu.pucp.inf.mateproyecto.dao.DAOArea;
import pe.edu.pucp.inf.mateproyecto.dao.DAOBrand;
import pe.edu.pucp.inf.mateproyecto.dao.DAOCustomer;
import pe.edu.pucp.inf.mateproyecto.dao.DAODiscount;
import pe.edu.pucp.inf.mateproyecto.dao.DAOEmployee;
import pe.edu.pucp.inf.mateproyecto.dao.DAOFamily;
import pe.edu.pucp.inf.mateproyecto.mysql.MySQLProduct;
import pe.edu.pucp.inf.mateproyecto.mysql.MySQLArea;
import pe.edu.pucp.inf.mateproyecto.dao.DAOPerson;
import pe.edu.pucp.inf.mateproyecto.dao.DAOPremises;
import pe.edu.pucp.inf.mateproyecto.dao.DAOPurchase;
import pe.edu.pucp.inf.mateproyecto.dao.DAOSale;

import pe.edu.pucp.inf.mateproyecto.mysql.MySQLPerson;
import pe.edu.pucp.inf.mateproyecto.model.bean.Person;

import pe.edu.pucp.inf.mateproyecto.dao.DAOSupplier;
import pe.edu.pucp.inf.mateproyecto.dao.DAOUser;
import pe.edu.pucp.inf.mateproyecto.model.bean.Brand;
import pe.edu.pucp.inf.mateproyecto.model.bean.Customer;
import pe.edu.pucp.inf.mateproyecto.model.bean.Discount;
import pe.edu.pucp.inf.mateproyecto.model.bean.Employee;
import pe.edu.pucp.inf.mateproyecto.model.bean.Family;
import pe.edu.pucp.inf.mateproyecto.model.bean.Premises;
import pe.edu.pucp.inf.mateproyecto.model.bean.Purchase;
import pe.edu.pucp.inf.mateproyecto.model.bean.PurchaseLane;
import pe.edu.pucp.inf.mateproyecto.model.bean.Sale;
import pe.edu.pucp.inf.mateproyecto.model.bean.SaleLane;
import pe.edu.pucp.inf.mateproyecto.model.bean.Supplier;
import pe.edu.pucp.inf.mateproyecto.model.bean.User;
import pe.edu.pucp.inf.mateproyecto.mysql.MySQLBrand;
import pe.edu.pucp.inf.mateproyecto.mysql.MySQLCustomer;
import pe.edu.pucp.inf.mateproyecto.mysql.MySQLDiscount;
import pe.edu.pucp.inf.mateproyecto.mysql.MySQLEmployee;
import pe.edu.pucp.inf.mateproyecto.mysql.MySQLFamily;
import pe.edu.pucp.inf.mateproyecto.mysql.MySQLPremises;
import pe.edu.pucp.inf.mateproyecto.mysql.MySQLPurchase;
import pe.edu.pucp.inf.mateproyecto.mysql.MySQLSale;
import pe.edu.pucp.inf.mateproyecto.mysql.MySQLSupplier;
import pe.edu.pucp.inf.mateproyecto.mysql.MySQLUser;

/**
 *
 * @author Usuario
 */
public class Aplicacion {
       
       public static void main(String[] args) throws ParseException {
           


//        try{
//            DBManager dbManager = DBManager.getDbManager();
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection con = DriverManager.getConnection(
//                    dbManager.getUrl(),dbManager.getUser(),dbManager.getPassword() );
//            
//            JasperReport reportProducts = (JasperReport) JRLoader.loadObjectFromFile(
//                    Aplicacion.class.getResource("/pe/edu/pucp/inf/mateproyecto/reports/TopProductsReport.jasper").getFile()); //ruta del reporte
//            HashMap hm = new HashMap();
//            
//            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
//
//            String dateString = format.format( new Date()   );
//            Date   date1       = format.parse ( "01/01/2010" );
//            Date   date2 = format.parse("01/01/2020");
//            
//            
//            
//           
//            
//            hm.put("Initial Date",date1);
//            hm.put("Final Date",date2);
//            
//            JasperPrint impression = JasperFillManager.fillReport(reportProducts, hm, con);
//            
//            JasperViewer visor = new JasperViewer(impression);
//            visor.setVisible(true);
//            
//        }catch(ClassNotFoundException | SQLException | JRException ex){
//            System.out.println(ex.getMessage());
//        }
        
//            DAOProduct productController = new MySQLProduct();
//            ArrayList<Product> products = productController.queryAll();
//            
//            for(Product p: products  ){
//                System.out.println(p.getName());
//            }        
//            //Areas
//           System.out.println("Area\n");
//           DAOArea areaController = new MySQLArea();
//           ArrayList<Area> areas = areaController.queryAll();
//           for(Area a:areas){
//               System.out.println(a.getAbbreviation());
//           }
//           System.out.println("Suppliers\n");
//           DAOSupplier supplierController = new MySQLSupplier();
//           ArrayList<Supplier> suppliers = supplierController.queryAll();
//           for(Supplier s:suppliers){
//               System.out.println(s.getName());
//           }
//           System.out.println("\nBrands\n");
//           DAOBrand brandController = new MySQLBrand();
//           ArrayList<Brand> brands = brandController.queryAll();
//           for(Brand b:brands){
//               System.out.println(b.getName());
//           }

//            DAOCustomer customerController = new MySQLCustomer();
//            ArrayList<Customer> customer = customerController.queryAll();
//            for(Customer c: customer)
//                System.out.println(c.getDescriptionCustomer());
//            
//            Customer c1 = new Customer();
//            c1.setAddress("Los olvidados de Dios");
//            c1.setDescriptionCustomer("Jose Perez");
//            c1.setEmail("asfagfasd@gmail.com");
//            c1.setId("67891");
//            c1.setKindOfCustomer("persona natural");
//            c1.setOccupation("abogado");
//            c1.setPhone("123456789");
//            c1.setState(1);
//            //customerController.insert(c1);
////            System.out.println(c1.getIdCustomer());
////            System.out.println(c1.getId());
//            c1.setIdCustomer(12);
////            customerController.update(c1);
//            customerController.delete(c1);

//            DAOProduct productController = new MySQLProduct();
//            Family f = new Family();
//            f.setId(1);
//            Brand b = new Brand();
//            b.setId(1);
//            Discount d = new Discount();
//            d.setId(1);
//            Product p = new Product();
//            p.setId(33);
//            p.setAvailability(1);
//            p.setName("Nuevo producto");
//            p.setIgv((float) 1.3);
//            p.setProductCareDescription("descripcion de cuidado");
//            p.setProductDescription("descripcion del producto");
//            p.setPurchasePrice(20);
//            p.setSalePrice(40);
//            p.setSKUcode("Nuevo SKUCODE");
//            p.setState(1);
//            p.setStock(100);
//            p.setFamily(f);
//            p.setBrand(b);
//            p.setDiscount(d);
            //int i = productController.insert(p);
            //int i = productController.update(p);
//            int i = productController.insertDiscount(2, p.getId());
//            System.out.println(i);
//            Product p1 = productController.queryProduct("T0000000");
//            System.out.println(p1.getSKUcode());

//            DAOUser userController = new MySQLUser();
//            ArrayList<User> users = userController.queryAll();
//            for(User u:users)
//                System.out.println(u.getUser());
            
//            DAOArea areaController = new MySQLArea();
//            ArrayList<Area> areas = areaController.queryAll();
//            for(Area a:areas)
//                System.out.println(a.getIdArea());
            
//            DAOPremises premisesController = new MySQLPremises();
//            ArrayList<Premises> premises = premisesController.queryAll();
//            for(Premises p:premises)
//                System.out.println(p.getAddress());
            
//            DAODiscount discountController = new MySQLDiscount();
//            ArrayList<Discount> discounts = discountController.queryAll();
//            for(Discount d:discounts)
//                System.out.println(d.getDescription());

//           DAOEmployee employeeController = new MySQLEmployee();
//           Employee e = new Employee();
//           e = employeeController.queryById(5);
//           System.out.println(e.getArea().getId());
              
            
//              DAOSale saleController = new MySQLSale();
//              Sale s = new Sale();
//              s.setSerialCode("F002300");
//              s.setState(1);
//              s.setTotalSale(15);
//              Employee e = new Employee();
//              e.setIdEmployee(3);
//              s.setEmployee(e);
//              Customer c = new Customer();
//              c.setIdCustomer(12);
//              s.setCustomer(c);
//              SaleLane sl = new SaleLane();
//              sl.setSubtotal(15);
//              sl.setQuantity(2);
//              Product p = new Product();
//              p.setId(30);
//              sl.setProduct(p);
//              ArrayList<SaleLane> aux = new ArrayList<SaleLane>();
//              aux.add(sl);
//              s.setSaleLanes(aux);
//              //int i = saleController.insert(s);
//              s.setId(27);
//              sl.setIdSaleLane(46);
//              int i = saleController.update(s);
//              System.out.println(i);
            DAOPurchase purchaseController = new MySQLPurchase();
            Purchase p = new Purchase();
            p.setCurrency("Euros");
            p.setSerialCode("A000012");
            p.setState(1);
            p.setTotalPurchase(30);
            Supplier s = new Supplier();
            s.setId(1);
            p.setSupplier(s);
            PurchaseLane pl = new PurchaseLane();
            pl.setQuantity(1);
            pl.setSubtotal(30);
            Product pd = new Product();
            pd.setId(2);
            pl.setProduct(pd);
            ArrayList<PurchaseLane> apd = new ArrayList<PurchaseLane>();
            apd.add(pl);
            p.setPurchaseLanes(apd);
            //int i = purchaseController.insert(p);
            p.setId(7);
            pl.setIdPurchaseLane(3);
            int i = purchaseController.update(p);
            System.out.println(i);
       }

}
