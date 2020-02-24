package com.hbcmis.entity.repository;

import java.sql.Timestamp;

/**
 * @author hbc-asuna
 */
public class TransDo {
    private int id;
    private Long transBill;
    private int transSource;
    private int transTarget;
    private int transType;
    private int transNumber;
    private Timestamp transDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getTransBill() {
        return transBill;
    }

    public void setTransBill(Long transBill) {
        this.transBill = transBill;
    }

    public int getTransSource() {
        return transSource;
    }

    public void setTransSource(int transSource) {
        this.transSource = transSource;
    }

    public int getTransTarget() {
        return transTarget;
    }

    public void setTransTarget(int transTarget) {
        this.transTarget = transTarget;
    }

    public int getTransType() {
        return transType;
    }

    public void setTransType(int transType) {
        this.transType = transType;
    }

    public int getTransNumber() {
        return transNumber;
    }

    public void setTransNumber(int transNumber) {
        this.transNumber = transNumber;
    }

    public Timestamp getTransDate() {
        return transDate;
    }

    public void setTransDate(Timestamp transDate) {
        this.transDate = transDate;
    }

    @Override
    public String toString() {
        return "TransDo{" +
                "id=" + id +
                ", transBill=" + transBill +
                ", transSource=" + transSource +
                ", transTarget=" + transTarget +
                ", transType=" + transType +
                ", transNumber=" + transNumber +
                ", transDate=" + transDate +
                '}';
    }
}
