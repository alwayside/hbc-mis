package com.hbcmis.entity.dto;

import java.sql.Timestamp;

/**
 * @author hbc-asuna
 */
public class PurchaseDto {
    private int id;
    private Long purchaseBill;
    private int purchaseNumber;
    private int purchaseType;
    private String medicineName;
    private int purchaseStore;
    private String storeName;
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

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public int getPurchaseStore() {
        return purchaseStore;
    }

    public void setPurchaseStore(int purchaseStore) {
        this.purchaseStore = purchaseStore;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Timestamp getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Timestamp purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    @Override
    public String toString() {
        return "PurchaseDto{" +
                "id=" + id +
                ", purchaseBill=" + purchaseBill +
                ", purchaseNumber=" + purchaseNumber +
                ", purchaseType=" + purchaseType +
                ", medicineName='" + medicineName + '\'' +
                ", purchaseStore=" + purchaseStore +
                ", storeName='" + storeName + '\'' +
                ", purchaseDate=" + purchaseDate +
                '}';
    }
}
