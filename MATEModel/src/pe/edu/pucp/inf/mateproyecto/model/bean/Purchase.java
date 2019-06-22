package pe.edu.pucp.inf.mateproyecto.model.bean;

import java.io.Serializable;
import java.util.*;


public class Purchase implements Serializable{

    private int id;
    
    private float totalPurchase;

    private int state;

    private String currency; 

    private String serialCode;

    private Date creationDate;

    private Date modificationDate;

    private User creatorUser;

    private User userModifier;

    
    private Supplier supplier;

    private ArrayList<PurchaseLane> purchaseLanes;

    public Purchase() {
        this.purchaseLanes = new ArrayList<PurchaseLane> ();
    }
    public Purchase(float totalPurchase, int state, String currency, String serialCode, Date creationDate, Date modificationDate, User creatorUser, User userModifier, Supplier supplier) {
        this.totalPurchase = totalPurchase;
        this.state = state;
        this.currency = currency;
        this.serialCode = serialCode;
        this.creationDate = creationDate;
        this.modificationDate = modificationDate;
        this.creatorUser = creatorUser;
        this.userModifier = userModifier;
        this.supplier = supplier;
        this.purchaseLanes = new ArrayList<PurchaseLane> ();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getTotalPurchase() {
        return totalPurchase;
    }

    public void setTotalPurchase(float totalPurchase) {
        this.totalPurchase = totalPurchase;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
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

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public ArrayList<PurchaseLane> getPurchaseLanes() {
        return purchaseLanes;
    }

    public void setPurchaseLanes(ArrayList<PurchaseLane> purchaseLanes) {
        this.purchaseLanes = purchaseLanes;
    }

   
    
    
    
    
    


}