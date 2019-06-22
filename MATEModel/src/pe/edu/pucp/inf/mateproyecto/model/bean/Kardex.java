/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.inf.mateproyecto.model.bean;

/**
 *
 * @author Usuario
 */
public class Kardex {
    private int id;
    private int dateOp;
    private SaleLane salelane;
    private PurchaseLane purchaselane;
    private RefundLane refundlane;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDateOp() {
        return dateOp;
    }

    public void setDateOp(int dateOp) {
        this.dateOp = dateOp;
    }

    public SaleLane getSalelane() {
        return salelane;
    }

    public void setSalelane(SaleLane salelane) {
        this.salelane = salelane;
    }

    public PurchaseLane getPurchaselane() {
        return purchaselane;
    }

    public void setPurchaselane(PurchaseLane purchaselane) {
        this.purchaselane = purchaselane;
    }

    public RefundLane getRefundlane() {
        return refundlane;
    }

    public void setRefundlane(RefundLane refundlane) {
        this.refundlane = refundlane;
    }
    
    
    
    
    
}
