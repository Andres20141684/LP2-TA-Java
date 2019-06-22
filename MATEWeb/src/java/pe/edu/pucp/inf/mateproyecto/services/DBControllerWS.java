/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.inf.mateproyecto.services;

import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import pe.edu.pucp.inf.mateproyecto.dao.DAOArea;
import pe.edu.pucp.inf.mateproyecto.dao.DAOBrand;
import pe.edu.pucp.inf.mateproyecto.dao.DAOCustomer;
import pe.edu.pucp.inf.mateproyecto.dao.DAODiscount;
import pe.edu.pucp.inf.mateproyecto.dao.DAOEmployee;
import pe.edu.pucp.inf.mateproyecto.dao.DAOFamily;
import pe.edu.pucp.inf.mateproyecto.dao.DAOPremises;
import pe.edu.pucp.inf.mateproyecto.dao.DAOProduct;
import pe.edu.pucp.inf.mateproyecto.dao.DAOPurchase;
import pe.edu.pucp.inf.mateproyecto.dao.DAORefund;
import pe.edu.pucp.inf.mateproyecto.dao.DAOSale;
import pe.edu.pucp.inf.mateproyecto.dao.DAOSupplier;
import pe.edu.pucp.inf.mateproyecto.dao.DAOUser;
import pe.edu.pucp.inf.mateproyecto.model.bean.Area;
import pe.edu.pucp.inf.mateproyecto.model.bean.Brand;
import pe.edu.pucp.inf.mateproyecto.model.bean.Customer;
import pe.edu.pucp.inf.mateproyecto.model.bean.Discount;
import pe.edu.pucp.inf.mateproyecto.model.bean.Employee;
import pe.edu.pucp.inf.mateproyecto.model.bean.Family;
import pe.edu.pucp.inf.mateproyecto.model.bean.Premises;
import pe.edu.pucp.inf.mateproyecto.model.bean.Product;
import pe.edu.pucp.inf.mateproyecto.model.bean.Purchase;
import pe.edu.pucp.inf.mateproyecto.model.bean.Refund;
import pe.edu.pucp.inf.mateproyecto.model.bean.Sale;
import pe.edu.pucp.inf.mateproyecto.model.bean.Supplier;
import pe.edu.pucp.inf.mateproyecto.model.bean.User;
import pe.edu.pucp.inf.mateproyecto.mysql.MySQLArea;
import pe.edu.pucp.inf.mateproyecto.mysql.MySQLBrand;
import pe.edu.pucp.inf.mateproyecto.mysql.MySQLCustomer;
import pe.edu.pucp.inf.mateproyecto.mysql.MySQLDiscount;
import pe.edu.pucp.inf.mateproyecto.mysql.MySQLEmployee;
import pe.edu.pucp.inf.mateproyecto.mysql.MySQLFamily;
import pe.edu.pucp.inf.mateproyecto.mysql.MySQLPremises;
import pe.edu.pucp.inf.mateproyecto.mysql.MySQLProduct;
import pe.edu.pucp.inf.mateproyecto.mysql.MySQLPurchase;
import pe.edu.pucp.inf.mateproyecto.mysql.MySQLRefund;
import pe.edu.pucp.inf.mateproyecto.mysql.MySQLSale;
import pe.edu.pucp.inf.mateproyecto.mysql.MySQLSupplier;
import pe.edu.pucp.inf.mateproyecto.mysql.MySQLUser;

/**
 *
 * @author Usuario
 */
@WebService(serviceName = "DBControllerWS")
public class DBControllerWS {


    /**
     * Web service operation
     */
    
    @WebMethod(operationName = "queryAllProducts")
    public ArrayList<Product> queryProducts() {
        //TODO write your implementation code here:
        DAOProduct productController = new MySQLProduct();
        return productController.queryAll();
    }
    
    @WebMethod(operationName = "queryAllCustomer")
    public ArrayList<Customer> queryCustomer() {
        //TODO write your implementation code here:
        DAOCustomer customerController = new MySQLCustomer();
        return customerController.queryAll();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "insertCustomer")
    public Integer insertCustomer(@WebParam(name = "customer") Customer customer) {
        //TODO write your implementation code here:
        DAOCustomer customerController = new MySQLCustomer();
        return customerController.insert(customer);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "updateCustomer")
    public Integer updateCustomer(@WebParam(name = "customer") Customer customer) {
        //TODO write your implementation code here:
        DAOCustomer customerController = new MySQLCustomer();
        return customerController.update(customer);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteCustomer")
    public Integer deleteCustomer(@WebParam(name = "customer") Customer customer) {
        //TODO write your implementation code here:
        DAOCustomer customerController = new MySQLCustomer();
        return customerController.delete(customer);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "insertEmployee")
    public Integer insertEmployee(@WebParam(name = "employee") Employee employee) {
        //TODO write your implementation code here:
        DAOEmployee employeeController = new MySQLEmployee();
        return employeeController.insert(employee);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "updateEmployee")
    public Integer updateEmployee(@WebParam(name = "employee") Employee employee) {
        //TODO write your implementation code here:
        DAOEmployee employeeController = new MySQLEmployee();
        return employeeController.update(employee);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "queryAllEmployee")
    public ArrayList<Employee> queryAllEmployee() {
        //TODO write your implementation code here:
        DAOEmployee employeeController = new MySQLEmployee();
        return employeeController.queryAll();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "queryByIdEmployee")
    public Employee queryByIdEmployee(@WebParam(name = "idEmployee") Integer idEmployee) {
        //TODO write your implementation code here:
        DAOEmployee employeeController = new MySQLEmployee();
        return employeeController.queryById(idEmployee);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "insertSupplier")
    public Integer insertSupplier(@WebParam(name = "supplier") Supplier supplier) {
        //TODO write your implementation code here:
        DAOSupplier supplierController = new MySQLSupplier();
        return supplierController.insert(supplier);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "queryAllSupplier")
    public ArrayList<Supplier> queryAllSupplier() {
        //TODO write your implementation code here:
        DAOSupplier supplierController = new MySQLSupplier();
        return supplierController.queryAll();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "updateSupplier")
    public Integer updateSupplier(@WebParam(name = "supplier") Supplier supplier) {
        //TODO write your implementation code here:
        DAOSupplier supplierController = new MySQLSupplier();
        return supplierController.update(supplier);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "insertFamily")
    public Integer insertFamily(@WebParam(name = "family") Family family) {
        //TODO write your implementation code here:
        DAOFamily familyController = new MySQLFamily();
        return familyController.insert(family);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "queryAllFamily")
    public ArrayList<Family> queryAllFamily() {
        //TODO write your implementation code here:
        DAOFamily familyController = new MySQLFamily();
        return familyController.queryALL();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "updateFamily")
    public Integer updateFamily(@WebParam(name = "family") Family family) {
        //TODO write your implementation code here:
        DAOFamily familyController = new MySQLFamily();
        return familyController.update(family);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "insertProduct")
    public Integer insertProduct(@WebParam(name = "product") Product product) {
        //TODO write your implementation code here:
        DAOProduct productController = new MySQLProduct();
        return productController.insert(product);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "updateProduct")
    public Integer updateProduct(@WebParam(name = "product") Product product) {
        //TODO write your implementation code here:
        DAOProduct productController = new MySQLProduct();
        return productController.update(product);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "insertDiscountProduct")
    public Integer insertDiscountProduct(@WebParam(name = "idDiscount") Integer idDiscount, @WebParam(name = "idProduct") Integer idProduct) {
        //TODO write your implementation code here:
        DAOProduct productController = new MySQLProduct();
        return productController.insertDiscount(idDiscount, idProduct);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "updateUser")
    public Integer updateUser(@WebParam(name = "user") User user) {
        //TODO write your implementation code here:
        DAOUser userController = new MySQLUser();
        return userController.update(user);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "insertUser")
    public Integer insertUser(@WebParam(name = "user") User user) {
        //TODO write your implementation code here:
        DAOUser userController = new MySQLUser();
        return userController.insert(user);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "queryAllUser")
    public ArrayList<User> queryAllUser() {
        //TODO write your implementation code here:
        DAOUser userController = new MySQLUser();
        return userController.queryAll();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "insertSale")
    public Integer insertSale(@WebParam(name = "sale") Sale sale) {
        //TODO write your implementation code here:
        DAOSale saleController = new MySQLSale();
        return saleController.insert(sale);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "queryAllSale")
    public ArrayList<Sale> queryAllSale() {
        //TODO write your implementation code here:
        DAOSale saleController = new MySQLSale();
        return saleController.queryALL();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "queryAllArea")
    public ArrayList<Area> queryAllArea() {
        //TODO write your implementation code here:
        DAOArea areaController = new MySQLArea();
        return areaController.queryAll();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "queryAllBrand")
    public ArrayList<Brand> queryAllBrand() {
        //TODO write your implementation code here:
        DAOBrand brandController = new MySQLBrand();
        return brandController.queryAll();
    }


    /**
     * Web service operation
     */
    @WebMethod(operationName = "queryAllPremises")
    public ArrayList<Premises> queryAllPremises() {
        //TODO write your implementation code here:
        DAOPremises premisesController = new MySQLPremises();
        return premisesController.queryAll();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "insertPremises")
    public Integer insertPremises(@WebParam(name = "premises") Premises premises) {
        //TODO write your implementation code here:
        DAOPremises premisesController = new MySQLPremises();
        return premisesController.insert(premises);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "updatePremises")
    public Integer updatePremises(@WebParam(name = "premises") Premises premises) {
        //TODO write your implementation code here:
        DAOPremises premisesController = new MySQLPremises();
        return premisesController.update(premises);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "queryAllDiscount")
    public ArrayList<Discount> queryAllDiscount() {
        //TODO write your implementation code here:
        DAODiscount discountController = new MySQLDiscount();
        return discountController.queryAll();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "queryEmployee")
    public Employee queryEmployee(@WebParam(name = "infEmployee") String infEmployee) {
        DAOEmployee employeeController = new MySQLEmployee();
        return employeeController.queryEmployee(infEmployee);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "insertArea")
    public Integer insertArea(@WebParam(name = "area") Area area) {
        //TODO write your implementation code here:
        DAOArea areaController = new MySQLArea();
        return areaController.insert(area);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "updateArea")
    public Integer updateArea(@WebParam(name = "area") Area area) {
        //TODO write your implementation code here:
        DAOArea areaController = new MySQLArea();
        return areaController.update(area);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "insertBrand")
    public Integer insertBrand(@WebParam(name = "brand") Brand brand) {
        //TODO write your implementation code here:
        DAOBrand brandController = new MySQLBrand();
        return brandController.insert(brand);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "updateBrand")
    public Integer updateBrand(@WebParam(name = "brand") Brand brand) {
        //TODO write your implementation code here:
        DAOBrand brandController = new MySQLBrand();
        return brandController.update(brand);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "queryByIdCustomer")
    public Customer queryByIdCustomer(@WebParam(name = "idCustomer") String idCustomer) {
        //TODO write your implementation code here:
        DAOCustomer customerController = new MySQLCustomer();
        return customerController.queryById(idCustomer);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "insertDiscount")
    public Integer insertDiscount(@WebParam(name = "discount") Discount discount) {
        //TODO write your implementation code here:
        DAODiscount discountController = new MySQLDiscount();
        return discountController.insert(discount);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "updateDiscount")
    public Integer updateDiscount(@WebParam(name = "discount") Discount discount) {
        //TODO write your implementation code here:
        DAODiscount discountController = new MySQLDiscount();
        return discountController.update(discount);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "queryEmployeeByDNI")
    public Employee queryEmployeeByDNI(@WebParam(name = "dni") String dni) {
        //TODO write your implementation code here:
        DAOEmployee employeeController = new MySQLEmployee();
        return employeeController.queryEmployee(dni);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "queryFamilyByCode")
    public Family queryFamilyByCode(@WebParam(name = "familyID") String familyID) {
        //TODO write your implementation code here:
        DAOFamily famliyController = new MySQLFamily();
        return famliyController.queryFamily(familyID);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "queryPremisesByDescription")
    public Premises queryPremisesByDescription(@WebParam(name = "description") String description) {
        //TODO write your implementation code here:
        DAOPremises premisesController = new MySQLPremises();
        return premisesController.queryPremises(description);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "queryProductBySKUCode")
    public Product queryProductBySKUCode(@WebParam(name = "skuCode") String skuCode) {
        //TODO write your implementation code here:
        DAOProduct productController = new MySQLProduct();
        return productController.queryProduct(skuCode);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "insertPurchase")
    public Integer insertPurchase(@WebParam(name = "purchase") Purchase purchase) {
        //TODO write your implementation code here:
        DAOPurchase purchaseController = new MySQLPurchase();
        return purchaseController.insert(purchase);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "queryAllPurchase")
    public ArrayList queryAllPurchase() {
        //TODO write your implementation code here:
        DAOPurchase purchaseController = new MySQLPurchase();
        return purchaseController.queryAll();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "queryPurchaseBySerialCode")
    public Purchase queryPurchaseBySerialCode(@WebParam(name = "serialCode") String serialCode) {
        //TODO write your implementation code here:
        DAOPurchase purchaseController = new MySQLPurchase();
        return purchaseController.queryPurchase(serialCode);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "insertRefund")
    public Integer insertRefund(@WebParam(name = "refund") Refund refund) {
        //TODO write your implementation code here:
        DAORefund refundController = new MySQLRefund();
        return refundController.insert(refund);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "querySaleBySerialCode")
    public Sale querySaleBySerialCode(@WebParam(name = "serialCode") String serialCode) {
        //TODO write your implementation code here:
        DAOSale saleController = new MySQLSale();
        return saleController.querySale(serialCode);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "updateAristSupplier")
    public Integer updateAristSupplier(@WebParam(name = "idArist") Integer idArist, @WebParam(name = "idSupplier") Integer idSupplier) {
        //TODO write your implementation code here:
        DAOSupplier supplierController = new MySQLSupplier();
        return supplierController.insertArtist(idArist, idSupplier);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "querySupplierByCode")
    public Supplier querySupplierByCode(@WebParam(name = "supplierCode") String supplierCode) {
        //TODO write your implementation code here:
        DAOSupplier supplierController = new MySQLSupplier();
        return supplierController.querySupplier(supplierCode);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "queryUserByUserName")
    public User queryUserByUserName(@WebParam(name = "user") String user) {
        //TODO write your implementation code here:
        DAOUser userController = new MySQLUser();
        return userController.queryUser(user);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "updateSale")
    public Integer updateSale(@WebParam(name = "sale") Sale sale) {
        //TODO write your implementation code here:
        DAOSale saleController = new MySQLSale();
        return saleController.update(sale);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "updatePurchase")
    public Integer updatePurchase(@WebParam(name = "purchase") Purchase purchase) {
        //TODO write your implementation code here:
        DAOPurchase purchaseController = new MySQLPurchase();
        return purchaseController.update(purchase);
    }

    
    
}
