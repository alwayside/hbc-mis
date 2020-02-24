package com.hbcmis.entity.repository;

import java.sql.Timestamp;

/**
 * @author hbc-asuna
 */
public class PurchaseDo {
    private int id;
    private Long purchaseBill;
    private int purchaseNumber;
    private int purchaseType;
    private int purchaseStore;
    private Timestamp purchaseDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getPurchaseBill() {
        return purchaseBill;
    }

    public void setPurchaseBill(Long purchaseBill) {
        this.purchaseBill = purchaseBill;
    }

    public int getPurchaseNumber() {
        return purchaseNumber;
    }

    public void setPurchaseNumber(int purchaseNumber) {
        this.purchaseNumber = purchaseNumber;
    }

    public int getPurchaseType() {
        return purchaseType;
    }

    public void setPurchaseType(int purchaseType) {
        this.purchaseType = purchaseType;
    }

    public int getPurchaseStore() {
        return purchaseStore;
    }

    public void setPurchaseStore(int purchaseStore) {
        this.purchaseStore = purchaseStore;
    }

    public Timestamp getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Timestamp purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    @Override
    public String toString() {
        return "PurchaseDo{" +
                "id=" + id +
                ", purchaseBill=" + purchaseBill +
                ", purchaseNumber=" + purchaseNumber +
                ", purchaseType=" + purchaseType +
                ", purchaseStore=" + purchaseStore +
                ", purchaseDate=" + purchaseDate +
                '}';
    }
}
