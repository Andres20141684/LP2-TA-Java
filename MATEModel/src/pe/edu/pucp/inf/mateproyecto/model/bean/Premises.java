package pe.edu.pucp.inf.mateproyecto.model.bean;

import java.io.Serializable;
import java.util.*;

/**
 * 
 */
public class Premises implements Serializable{

    private int id;

    private String description;

    private int state;

    private String address;

    private Date creationDate;
    
    private Date modificationDate;

    private User creatorUser;

    private User userModifier;

    private String idPremises;
    
    private ArrayList<Space> spaces;
    private ArrayList<Warehouse> warehouses;
    
     public Premises() {
         this.spaces = new ArrayList<Space>() ;
        this.warehouses = new ArrayList<Warehouse>() ;
    }

    public Premises(String description, int state, String address, Date creationDate, String idPremises) {
        this.description = description;
        this.state = state;
        this.address = address;
        this.creationDate = creationDate;
        this.idPremises = idPremises;
        this.spaces = new ArrayList<Space>() ;
        this.warehouses = new ArrayList<Warehouse>() ;
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

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getIdPremises() {
        return idPremises;
    }

    public void setIdPremises(String idPremises) {
        this.idPremises = idPremises;
    }

    public ArrayList<Space> getSpaces() {
        return spaces;
    }

    public void setSpaces(ArrayList<Space> spaces) {
        this.spaces = spaces;
    }

    public ArrayList<Warehouse> getWarehouses() {
        return warehouses;
    }

    public void setWarehouses(ArrayList<Warehouse> warehouses) {
        this.warehouses = warehouses;
    }
    
    
    



}