package com.hbcmis.entity.dto;

import java.sql.Timestamp;

/**
 * @author hbc-asuna
 */
public class SellDto {
    private int id;
    private Long sellBill;
    private int sellNumber;
    private int sellType;
    private String medicineName;
    private int sellStore;
    private String storeName;
    private Timestamp sellDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getsellBill() {
        return sellBill;
    }

    public void setsellBill(Long sellBill) {
        this.sellBill = sellBill;
    }

    public int getsellNumber() {
        return sellNumber;
    }

    public void setsellNumber(int sellNumber) {
        this.sellNumber = sellNumber;
    }

    public int getsellType() {
        return sellType;
    }

    public void setsellType(int sellType) {
        this.sellType = sellType;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public int getsellStore() {
        return sellStore;
    }

    public void setsellStore(int sellStore) {
        this.sellStore = sellStore;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Timestamp getsellDate() {
        return sellDate;
    }

    public void setsellDate(Timestamp sellDate) {
        this.sellDate = sellDate;
    }

    @Override
    public String toString() {
        return "sellDto{" +
                "id=" + id +
                ", sellBill=" + sellBill +
                ", sellNumber=" + sellNumber +
                ", sellType=" + sellType +
                ", medicineName='" + medicineName + '\'' +
                ", sellStore=" + sellStore +
                ", storeName='" + storeName + '\'' +
                ", sellDate=" + sellDate +
                '}';
    }
}
