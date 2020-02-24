package com.hbcmis.entity.repository;


/**
 * @author hbc-asuna
 */
public class StoreDo {
    private int id;
    private String storeName;
    private String storeAddress;
    private Long storeCapacity;
    private Long storeCapacityUse;
    private int isDelete;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public Long getStoreCapacity() {
        return storeCapacity;
    }

    public void setStoreCapacity(Long storeCapacity) {
        this.storeCapacity = storeCapacity;
    }

    public Long getStoreCapacityUse() {
        return storeCapacityUse;
    }

    public void setStoreCapacityUse(Long storeCapacityUse) {
        this.storeCapacityUse = storeCapacityUse;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "StoreDo{" +
                "id=" + id +
                ", storeName='" + storeName + '\'' +
                ", storeAddress='" + storeAddress + '\'' +
                ", storeCapacity=" + storeCapacity +
                ", storeCapacityUse=" + storeCapacityUse +
                '}';
    }
}
