/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.inf.mateproyecto.model.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Usuario
 */
public class Transaction implements Serializable{
    
    private int id;

    private Date creationDate;

    private Date modificationDate;

    private User creatorUser;

    private User userModifier;
    
    private String typeTransaction;
    
    private ArrayList<SaleLane> salesDetails;
    
    private ArrayList<PurchaseLane> purchaseDetails;

    public Transaction(){
        this.salesDetails = new ArrayList<SaleLane>();
        this.purchaseDetails = new ArrayList<PurchaseLane>();
    }
    public Transaction(int id, Date creationDate, String typeTransaction) {
        this.id = id;
        this.creationDate = creationDate;
        this.typeTransaction = typeTransaction;
        this.salesDetails = new ArrayList<SaleLane>();
        this.purchaseDetails = new ArrayList<PurchaseLane>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getTypeTransaction() {
        return typeTransaction;
    }

    public void setTypeTransaction(String typeTransaction) {
        this.typeTransaction = typeTransaction;
    }

    public ArrayList<SaleLane> getSalesDetails() {
        return salesDetails;
    }

    public void setSalesDetails(ArrayList<SaleLane> salesDetails) {
        this.salesDetails = salesDetails;
    }

    public ArrayList<PurchaseLane> getPurchaseDetails() {
        return purchaseDetails;
    }

    public void setPurchaseDetails(ArrayList<PurchaseLane> purchaseDetails) {
        this.purchaseDetails = purchaseDetails;
    }

    
    
}
