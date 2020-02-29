package com.hbcmis.entity.dto;

/**
 * @author hbc-asuna
 */
public class RemainDto {
    private int id;
    private int remainStore;
    private int remainNumber;
    private int remainType;
    private String storeName;
    private String medicineName;
    private String medicineUnit;

    public String getMedicineUnit() {
        return medicineUnit;
    }

    public void setMedicineUnit(String medicineUnit) {
        this.medicineUnit = medicineUnit;
    }

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

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }


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
