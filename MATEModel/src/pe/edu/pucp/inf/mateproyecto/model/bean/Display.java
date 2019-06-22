package pe.edu.pucp.inf.mateproyecto.model.bean;

import java.io.Serializable;
import java.util.*;

/**
 * 
 */
public class Display  implements Serializable{

    public Display() {
    }

    private int id;
    private String description;
    private int state;

    private Date initialDate;

    private Date finalDate;

    private float totalDebt;

    private float percentage;

    private Date creationDate;

    private Date modificationDate;

    private User creatorUser;

    private User userModifier;

    private String idDisplay;
    
    private Artist artist;
    private Space space;

    public Display(String description, int state, Date initialDate, Date finalDate, float totalDebt, float percentage, Date creationDate, String idDisplay, Artist artist, Space space) {
        this.description = description;
        this.state = state;
        this.initialDate = initialDate;
        this.finalDate = finalDate;
        this.totalDebt = totalDebt;
        this.percentage = percentage;
        this.creationDate = creationDate;
        this.idDisplay = idDisplay;
        this.artist = artist;
        this.space = space;
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

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(Date initialDate) {
        this.initialDate = initialDate;
    }

    public Date getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(Date finalDate) {
        this.finalDate = finalDate;
    }

    public float getTotalDebt() {
        return totalDebt;
    }

    public void setTotalDebt(float totalDebt) {
        this.totalDebt = totalDebt;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
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

    public String getIdDisplay() {
        return idDisplay;
    }

    public void setIdDisplay(String idDisplay) {
        this.idDisplay = idDisplay;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Space getSpace() {
        return space;
    }

    public void setSpace(Space space) {
        this.space = space;
    }
    
    
    
    

}