package pe.edu.pucp.inf.mateproyecto.model.bean;

import java.io.Serializable;
import java.util.*;

/**
 * 
 */
public class Supplier implements Serializable{

    public Supplier() {
    }
    private int id;

    private String supplierCode;

    private String name;

    private int state;

    private String RUC;

    private String address;

    private String bankData;

    private String termOfSale;
	
    private String contactPerson;

    private String contactPhone;

    private String contactEmail;

    private Date creationDate;

    private Date modificationDate;

    private User creatorUser;

    private User userModifier;
    
    private Artist artist;

    public Supplier(String supplierCode, String name, int state, String RUC, String address, String bankData, String contactPerson, String contactPhone, String contactEmail, Date creationDate, Artist artist, String termOfSale) {
        this.supplierCode = supplierCode;
        this.name = name;
        this.state = state;
        this.RUC = RUC;
        this.address = address;
        this.bankData = bankData;
        this.contactPerson = contactPerson;
        this.contactPhone = contactPhone;
        this.contactEmail = contactEmail;
        this.creationDate = creationDate;
        this.artist = artist;
	this.termOfSale = termOfSale;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getRUC() {
        return RUC;
    }

    public void setRUC(String RUC) {
        this.RUC = RUC;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBankData() {
        return bankData;
    }

    public void setBankData(String bankData) {
        this.bankData = bankData;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
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

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }
    
    public String getTermOfSale() {
        return termOfSale;
    }

    public void setTermOfSale(String termOfSale) {
        this.termOfSale = termOfSale;
    }
    
    
    
    



}