package com.hbcmis.entity.repository;

/**
 * @author hbc-asuna
 */
public class RemainDo {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRemainStore() {
        return remainStore;
    }

    public void setRemainStore(int remainStore) {
        this.remainStore = remainStore;
    }

    public int getRemainNumber() {
        return remainNumber;
    }

    public void setRemainNumber(int remainNumber) {
        this.remainNumber = remainNumber;
    }

    public int getRemainType() {
        return remainType;
    }

    public void setRemainType(int remainType) {
        this.remainType = remainType;
    }

    private int id;
    private int remainStore;
    private int remainNumber;
    private int remainType;

    @Override
    public String toString() {
        return "RemainDo{" +
                "id=" + id +
                ", remainStore=" + remainStore +
                ", remainNumber=" + remainNumber +
                ", remainType=" + remainType +
                '}';
    }
}
