package pe.edu.pucp.inf.mateproyecto.model.bean;

import java.io.Serializable;
import java.util.*;

/**
 * 
 */
public class Family implements Serializable {

    /**
     * Default constructor
     */
    

    /**
     * 
     */
    private int id;

    private String name;

    private String description;

    private int state;

    private Date creationDate;

    private Date modificationDate;

    private User creatorUser;

    private User userModifier;

    private String idFamily;
    
    public Family() {
        
    }

    public Family(String name, String description, int state  ,String idFamily) {
        this.name = name;
        this.description = description;
        this.state = state;
        this.idFamily = idFamily;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getIdFamily() {
        return idFamily;
    }

    public void setIdFamily(String idFamily) {
        this.idFamily = idFamily;
    }


}