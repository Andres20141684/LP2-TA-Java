package pe.edu.pucp.inf.mateproyecto.model.bean;

import java.io.Serializable;
import java.util.*;

/**
 * 
 */
public class Brand implements Serializable{

   
    private int id;

    private String description;

    private String name;

    private int state;

    private Date creationDate;

    private Date modificationDate;

    private User creatorUser;

    private User userModifier;

    private String BrandID;

    @Override
    public String toString() {
        return   name ;
    }
    
    

    public Brand() {
    }

    public Brand(String description, String name, int state,  String idBrand) {
        this.description = description;
        this.name = name;
        this.state = state;
        this.BrandID = idBrand;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getBrandID() {
        return BrandID;
    }

    public void setBrandID(String idBrand) {
        this.BrandID = idBrand;
    }
    
    
}