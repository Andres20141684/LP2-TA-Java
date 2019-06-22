package pe.edu.pucp.inf.mateproyecto.model.bean;

import java.io.Serializable;
import java.util.*;

/**
 * 
 */
public class Sale implements Serializable{

    
    public Sale() {
    }

    private int id;

    
    private float totalSale;

    private int state;

   
    private String serialCode;

    
    private Date creationDate;

    
    private Date modificationDate;

    
    private User creatorUser;

    
    private User userModifier;

    
    
    private String receipt;
    
    private ArrayList<SaleLane> saleLanes;
    
    private Employee employee;
    
    private Customer customer;
    
   

    public Sale(float totalSale, int state, String serialCode, Date creationDate, Employee employee, Customer customer) {
        this.totalSale = totalSale;
        this.state = state;
        this.serialCode = serialCode;
        this.creationDate = creationDate;
        this.employee = employee;
        this.customer = customer;
        this.saleLanes = new ArrayList<>(saleLanes);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getTotalSale() {
        return totalSale;
    }

    public void setTotalSale(float totalSale) {
        this.totalSale = totalSale;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getSerialCode() {
        return serialCode;
    }

    public void setSerialCode(String serialCode) {
        this.serialCode = serialCode;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }

    public User getCreatorUser() {
        return creatorUser;
    }

    public void setCreatorUser(User creatorUser) {
        this.creatorUser = creatorUser;
    }

    public User getUserModifier() {
        return userModifier;
    }

    public void setUserModifier(User userModifier) {
        this.userModifier = userModifier;
    }

   

    public ArrayList<SaleLane> getSaleLanes() {
        return saleLanes;
    }

    public void setSaleLanes(ArrayList<SaleLane> saleLanes) {
        this.saleLanes = saleLanes;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    
    
    


}