package pe.edu.pucp.inf.mateproyecto.model.bean;

import java.io.Serializable;
import java.util.*;

/**
 * 
 */
public class Product implements Serializable{

    /**
     * Default constructor
     */
    public Product() {
    }

    private int id;

    private String SKUcode;

    private String productDescription;
    
    private String name;
    
    private String productCareDescription;

    private float purchasePrice;

    private float salePrice;

    private float igv;

    private int stock;

    private int availability;

    private String kindOfProduct;

    private int state;

    private Date creationDate;

    private Date modificationDate;

    private User creatorUser;

    private User userModifier;

    private Family family;
    
    private Brand brand;

    private Discount discount;

    public Product(String SKUcode, String productDescription, String productCareDescription, float purchasePrice, float salePrice, float igv, int stock, int availability, String kindOfProduct, int state, Date creationDate, Family family, Brand brand, Discount discount) {
        this.SKUcode = SKUcode;
        this.productDescription = productDescription;
        this.productCareDescription = productCareDescription;
        this.purchasePrice = purchasePrice;
        this.salePrice = salePrice;
        this.igv = igv;
        this.stock = stock;
        this.availability = availability;
        this.kindOfProduct = kindOfProduct;
        this.state = state;
        this.creationDate = creationDate;
        this.family = family;
        this.brand = brand;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSKUcode() {
        return SKUcode;
    }

    public void setSKUcode(String SKUcode) {
        this.SKUcode = SKUcode;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductCareDescription() {
        return productCareDescription;
    }

    public void setProductCareDescription(String productCareDescription) {
        this.productCareDescription = productCareDescription;
    }

    public float getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(float purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public float getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(float salePrice) {
        this.salePrice = salePrice;
    }

    public float getIgv() {
        return igv;
    }

    public void setIgv(float igv) {
        this.igv = igv;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    public String getKindOfProduct() {
        return kindOfProduct;
    }

    public void setKindOfProduct(String kindOfProduct) {
        this.kindOfProduct = kindOfProduct;
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

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }
    
    
    


}