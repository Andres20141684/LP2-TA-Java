package pe.edu.pucp.inf.mateproyecto.model.bean;

import java.io.Serializable;
import java.util.*;

/**
 * 
 */
public class Discount implements Serializable{

    /**
     * Default constructor
     */
    
    private int id;
    private String idDiscount;

    private String description;

    private Date startDate;

    private Date endDate;

    private float discountAmount;

    private int state;
    private ArrayList<Product> products;
    
    public Discount() {
           products = new ArrayList<Product>(); 

    }

    public Discount(String idDiscount, String description, Date startDate, Date endDate, float discountAmount, int state) {
        this.idDiscount = idDiscount;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.discountAmount = discountAmount;
        this.state = state;
        products = new ArrayList<Product>(); 
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdDiscount() {
        return idDiscount;
    }

    public void setIdDiscount(String idDiscount) {
        this.idDiscount = idDiscount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public float getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(float discountAmount) {
        this.discountAmount = discountAmount;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
    
    
    
    
    
}

