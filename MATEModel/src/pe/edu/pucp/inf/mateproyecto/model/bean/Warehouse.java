package pe.edu.pucp.inf.mateproyecto.model.bean;

import java.io.Serializable;
import java.util.*;

/**
 * 
 */
public class Warehouse implements Serializable{

   
    private int id;

    private String warehouseCode;

    private String description;

    private int state;

    private Date creationDate;

    private Date modificationDate;

    private User creatorUser;

    private User userModifier;

    private String idWarehouse;
    
    private ArrayList<WarehouseDetail> warehouseDetails;

    private Premises premises;
    public Warehouse() {
        this.warehouseDetails = new ArrayList<WarehouseDetail>();
    }

    public Warehouse(String warehouseCode, String description, int state, Date creationDate, String idWarehouse, Premises premises) {
        this.warehouseCode = warehouseCode;
        this.description = description;
        this.state = state;
        this.creationDate = creationDate;
        this.idWarehouse = idWarehouse;
        this.premises = premises;
        this.warehouseDetails = new ArrayList<WarehouseDetail>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode;
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

    public String getIdWarehouse() {
        return idWarehouse;
    }

    public void setIdWarehouse(String idWarehouse) {
        this.idWarehouse = idWarehouse;
    }

    public ArrayList<WarehouseDetail> getWarehouseDetails() {
        return warehouseDetails;
    }

    public void setWarehouseDetails(ArrayList<WarehouseDetail> warehouseDetails) {
        this.warehouseDetails = warehouseDetails;
    }

    public Premises getPremises() {
        return premises;
    }

    public void setPremises(Premises premises) {
        this.premises = premises;
    }
    
    
    
    

}