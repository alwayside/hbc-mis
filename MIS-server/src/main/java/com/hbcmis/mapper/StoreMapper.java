package com.hbcmis.mapper;

import com.hbcmis.entity.repository.StoreDo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author hbc-asuna
 */
@Repository
public interface StoreMapper {
    /**
     * select store by id
     * @param id
     * @return
     */
    List<StoreDo> selectById(int id);

    /**
     * add a new store
     * @param storeName
     * @param storeAddress
     * @param storeCapacity
     * @param storeCapacityUse
     * @return
     */
    void addNewStore(@Param("storeName") String storeName, @Param("storeAddress") String storeAddress,@Param("storeCapacity") Long storeCapacity,@Param("storeCapacityUse") Long storeCapacityUse);

    /**
     * update a store that already have
     * @param id
     * @param storeName
     * @param storeAddress
     * @param storeCapacity
     */
    void updateStore(@Param("id")int id,@Param("storeName") String storeName, @Param("storeAddress") String storeAddress,@Param("storeCapacity") Long storeCapacity);

    /**
     * delete a store
     * @param id
     */
    void deleteStore(@Param("id")int id);

    /**
     * find record
     * @param id
     * @return
     */
    public List<StoreDo> findById(@Param("id") int id);
}
