package pe.edu.pucp.inf.mateproyecto.model.bean;

import java.io.Serializable;
import java.util.*;

/**
 * 
 */
public class SaleLane implements Serializable {


    public SaleLane() {
    }
    private int quantity;

    private float subtotal;

    private Date creationDate;

    private Date modificationDate;

    private User creatorUser;

    
    private User userModifier;

    private int idSaleLane;
    
    private Sale sale;
    private Product product;

    public SaleLane(int quantity, float subtotal, Date creationDate, Sale sale, Product product) {
        this.quantity = quantity;
        this.subtotal = subtotal;
        this.creationDate = creationDate;
        this.sale = sale;
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
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

    public int getIdSaleLane() {
        return idSaleLane;
    }

    public void setIdSaleLane(int idSaleLane) {
        this.idSaleLane = idSaleLane;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    
    
    
    
    

}