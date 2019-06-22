package pe.edu.pucp.inf.mateproyecto.model.bean;

import java.io.Serializable;
import java.util.*;

/**
 * 
 */
public class RefundLane implements Serializable{

   
    public RefundLane() {
    }

    
    private int id;

    
    private int quantity;

    
    private String reason;

    
    private float subtotal;

    
    private Date creationDate;

    
    private Date modificationDate;

   
    private User creatorUser;

    
    private User userModifier;

    
    private String idRefundLane;
    private Product product;
    private Refund refund;

    public RefundLane(int id, int quantity, String reason, float subtotal, Date creationDate, String idRefundLane, Product product, Refund refund) {
        this.id = id;
        this.quantity = quantity;
        this.reason = reason;
        this.subtotal = subtotal;
        this.creationDate = creationDate;
        this.idRefundLane = idRefundLane;
        this.product = product;
        this.refund = refund;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
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

    public String getIdRefundLane() {
        return idRefundLane;
    }

    public void setIdRefundLane(String idRefundLane) {
        this.idRefundLane = idRefundLane;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Refund getRefund() {
        return refund;
    }

    public void setRefund(Refund refund) {
        this.refund = refund;
    }
    
    
    

}