package pe.edu.pucp.inf.mateproyecto.model.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * 
 */
public class Area implements Serializable {

    private int id;
    
    private  String description;

    private  String abbreviation;

    private  int state;

    private  Date creationDate;

    private   Date modificationDate;

    private   User creatorUser;

    private  User userModifier;

    private  String idArea;
    
    private  ArrayList<Employee> employees;
    
    
       
    public Area() {
        this.employees = new ArrayList<Employee>();
    }

    public Area(String description, String abbreviation, int state, Date creationDate, Date modificationDate, String idArea) {
        this.description = description;
        this.abbreviation = abbreviation;
        this.state = state;
        this.creationDate = creationDate;
        this.modificationDate = modificationDate;
        this.idArea = idArea;
        this.employees = new ArrayList<Employee>();
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
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

    public String getIdArea() {
        return idArea;
    }

    public void setIdArea(String idArea) {
        this.idArea = idArea;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }
    

    
    
    
    

    
    

}