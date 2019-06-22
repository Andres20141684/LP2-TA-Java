package pe.edu.pucp.inf.mateproyecto.model.bean;

import java.io.Serializable;
import java.util.*;

/**
 * 
 */
public class PurchaseLane implements Serializable{

    
    public PurchaseLane() {
    }

    private int quantity;

    private float subtotal;

    private Date creationDate;

    private Date modificationDate;

    private User creatorUser;

    private User userModifier;

    private  int idPurchaseLane;
    private  Purchase purchase;
    private  Product product; 

    public PurchaseLane(int quantity, float subtotal, Date creationDate, Purchase purchase, Product product) {
        this.quantity = quantity;
        this.subtotal = subtotal;
        this.creationDate = creationDate;
        this.purchase = purchase;
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

    public int getIdPurchaseLane() {
        return idPurchaseLane;
    }

    public void setIdPurchaseLane(int idPurchaseLane) {
        this.idPurchaseLane = idPurchaseLane;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    
    
    

}