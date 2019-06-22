package pe.edu.pucp.inf.mateproyecto.model.bean;

import java.io.Serializable;
import java.util.*;

/**
 * 
 */
public class Employee extends Person implements Serializable {

      
    private int idEmployee;

    private String role;

    private int state;
    private Date contractStarDate;
    private Date contractEndDate;

    private Date creationDate;

    private Date modificationDate;

    private User creatorUser;

    private User userModifier;
    
    private Area area;
    
    private User user;
    
    private ArrayList<Sale> sales;
    
    public Employee() {
        
        sales = new ArrayList<Sale>();
        
    }

    public Employee( String role, int state, Date contractStarDate, Date contractEndDate, Date creationDate,  Area area, User user, String name, String lastName, String secondLastName, String dni, String email, String phone, Date birthdate) {
        super(name, lastName, secondLastName, dni, email, phone, birthdate);
        
        this.role = role;
        this.state = state;
        this.contractStarDate = contractStarDate;
        this.contractEndDate = contractEndDate;
        this.creationDate = creationDate;
        this.area = area;
        this.user = user;
        sales = new ArrayList<Sale>();
    }

    public Employee(int idEmployee, String role, int state, Date contractStarDate, Date contractEndDate, Date creationDate, Date modificationDate, User creatorUser, User userModifier, Area area, User user) {
       
        this.role = role;
        this.state = state;
        this.contractStarDate = contractStarDate;
        this.contractEndDate = contractEndDate;
        this.creationDate = creationDate;
        this.modificationDate = modificationDate;
        this.creatorUser = creatorUser;
        this.userModifier = userModifier;
        this.area = area;
        this.user = user;
        sales = new ArrayList<Sale>();
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }
    
    

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getContractStarDate() {
        return contractStarDate;
    }

    public void setContractStarDate(Date contractStarDate) {
        this.contractStarDate = contractStarDate;
    }

    public Date getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(Date contractEndDate) {
        this.contractEndDate = contractEndDate;
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

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<Sale> getSales() {
        return sales;
    }

    public void setSales(ArrayList<Sale> sales) {
        this.sales = sales;
    }
    
    
    
    
    
    

}