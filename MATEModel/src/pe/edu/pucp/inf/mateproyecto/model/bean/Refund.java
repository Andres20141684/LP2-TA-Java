package pe.edu.pucp.inf.mateproyecto.model.bean;

import java.io.Serializable;
import java.util.*;

/**
 * 
 */
public class Refund implements Serializable{

    private int id;

    private String idRefound;

    private float totalReturned;

    private int state;

    private Date creationDate;

    private Date modificationDate;

    private User creatorUser;

    private User userModifier;
    
    private ArrayList<RefundLane> refundLanes ;
    
    private Customer customer;
    
    private Sale sale;
    
    public Refund() {
         this.refundLanes = new ArrayList<RefundLane> ();
    }

    public Refund(String idRefound, float totalReturned, int state, Date creationDate, Customer customer, Sale sale) {
        this.idRefound = idRefound;
        this.totalReturned = totalReturned;
        this.state = state;
        this.creationDate = creationDate;
        this.refundLanes = new ArrayList<RefundLane> ();
        this.customer = customer;
        this.sale =  sale;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    public String getIdRefound() {
        return idRefound;
    }

    public void setIdRefound(String idRefound) {
        this.idRefound = idRefound;
    }

    public float getTotalReturned() {
        return totalReturned;
    }

    public void setTotalReturned(float totalReturned) {
        this.totalReturned = totalReturned;
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

    public ArrayList<RefundLane> getRefundLanes() {
        return refundLanes;
    }

    public void setRefundLanes(ArrayList<RefundLane> refundLanes) {
        this.refundLanes = refundLanes;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }
    
    
     
    
    


}