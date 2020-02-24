package com.hbcmis.entity.repository;

import java.sql.Timestamp;

/**
 * @author hbc-asuna
 */
public class SellDo {
    private int id;
    private Long sellBill;
    private int sellNumber;
    private int sellType;
    private int sellStore;
    private Timestamp sellDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getSellBill() {
        return sellBill;
    }

    public void setSellBill(Long sellBill) {
        this.sellBill = sellBill;
    }

    public int getSellNumber() {
        return sellNumber;
    }

    public void setSellNumber(int sellNumber) {
        this.sellNumber = sellNumber;
    }

    public int getSellType() {
        return sellType;
    }

    public void setSellType(int sellType) {
        this.sellType = sellType;
    }

    public int getSellStore() {
        return sellStore;
    }

    public void setSellStore(int sellStore) {
        this.sellStore = sellStore;
    }

    public Timestamp getSellDate() {
        return sellDate;
    }

    public void setSellDate(Timestamp sellDate) {
        this.sellDate = sellDate;
    }

    @Override
    public String toString() {
        return "SellDo{" +
                "id=" + id +
                ", sellBill=" + sellBill +
                ", sellNumber=" + sellNumber +
                ", sellType=" + sellType +
                ", sellStore=" + sellStore +
                ", sellDate=" + sellDate +
                '}';
    }
}
