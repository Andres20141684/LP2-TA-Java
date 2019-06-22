package pe.edu.pucp.inf.mateproyecto.model.bean;

import java.io.Serializable;
import java.util.*;

/**
 * 
 */
public class Customer implements Serializable{

    private String id;

    private int idCustomer; //DNI or RUC

    private String kindOfCustomer;
    private String descriptionCustomer;
    private String occupation;
    
    private String phone;
    private String email;

    private String address;
    
    private int state;

    private Date creationDate;

    private Date modificationDate;
    private User creatorUser;

    private User userModifier;
    
    public Customer() {
    }

    public Customer(int idCustomer, String kindOfCustomer, String descriptionCustomer, String occupation, String phone, String email, String address, Date creationDate) {
        this.idCustomer = idCustomer;
        this.kindOfCustomer = kindOfCustomer;
        this.descriptionCustomer = descriptionCustomer;
        
        this.occupation = occupation;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.creationDate = creationDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getKindOfCustomer() {
        return kindOfCustomer;
    }

    public void setKindOfCustomer(String kindOfCustomer) {
        this.kindOfCustomer = kindOfCustomer;
    }

    public String getDescriptionCustomer() {
        return descriptionCustomer;
    }

    public void setDescriptionCustomer(String descriptionCustomer) {
        this.descriptionCustomer = descriptionCustomer;
    }
    
        
    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
    
    

}