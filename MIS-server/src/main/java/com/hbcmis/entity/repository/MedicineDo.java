package com.hbcmis.entity.repository;

/**
 * @author hbc-asuna
 */
public class MedicineDo {
    private int id;
    private String medicineName;
    private String medicineProducer;
    private double medicinePrice;
    private int isDelete;
    private String medicineUnit;
    private String medicineDescription;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getMedicineProducer() {
        return medicineProducer;
    }

    public void setMedicineProducer(String medicineProducer) {
        this.medicineProducer = medicineProducer;
    }

    public double getMedicinePrice() {
        return medicinePrice;
    }

    public void setMedicinePrice(double medicinePrice) {
        this.medicinePrice = medicinePrice;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "MedicineDo{" +
                "id=" + id +
                ", medicineName='" + medicineName + '\'' +
                ", medicineProducer='" + medicineProducer + '\'' +
                ", medicinePrice='" + medicinePrice + '\'' +
                ", medicineUnit='" + medicineUnit + '\'' +
                '}';
    }

    public String getMedicineUnit() {
        return medicineUnit;
    }

    public void setMedicineUnit(String medicineUnit) {
        this.medicineUnit = medicineUnit;
    }

    public String getMedicineDescription() {
        return medicineDescription;
    }

    public void setMedicineDescription(String medicineDescription) {
        this.medicineDescription = medicineDescription;
    }
}
