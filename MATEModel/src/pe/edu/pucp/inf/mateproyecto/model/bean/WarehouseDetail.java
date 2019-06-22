package pe.edu.pucp.inf.mateproyecto.model.bean;
import java.io.Serializable;
import java.util.*;

/**
 * 
 */
public class WarehouseDetail implements Serializable{

    private int quantity;

    private Date creationDate;

    private Date modificationDate;

    private User creatorUser;

    private User userModifier;

    private int idWarehouseDetail;
    
    private Product product;
    private Warehouse warehouse;
    
    public WarehouseDetail() {
        
    }

    public WarehouseDetail(int quantity, Date creationDate, Product product, Warehouse warehouse) {
        this.quantity = quantity;
        this.creationDate = creationDate;
        this.product = product;
        this.warehouse = warehouse;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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

    public int getIdWarehouseDetail() {
        return idWarehouseDetail;
    }

    public void setIdWarehouseDetail(int idWarehouseDetail) {
        this.idWarehouseDetail = idWarehouseDetail;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }
    
    
    
     
}