package com.hbcmis.service;

import com.hbcmis.entity.repository.StoreDo;
import com.hbcmis.mapper.StoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hbc-asuna
 */
@Service
public class StoreService {

    @Autowired
    StoreMapper storeMapper;

    public void addNewStore(StoreDo storeDo) {
        String name = storeDo.getStoreName();
        String address = storeDo.getStoreAddress();
        Long capacity = storeDo.getStoreCapacity();
        Long capacityUse = (storeDo.getStoreCapacityUse() != null) ? storeDo.getStoreCapacityUse() : 0L;
        storeMapper.addNewStore(name, address, capacity, capacityUse);
    }

    public void updateStore(StoreDo storeDo) {
        int id = storeDo.getId();
        String name = storeDo.getStoreName();
        String address = storeDo.getStoreAddress();
        Long capacity = storeDo.getStoreCapacity();
//        Long capacityUse = (storeDo.getGetStoreCapacityUse() != null) ? storeDo.getGetStoreCapacityUse() : 0L;
        storeMapper.updateStore(id, name, address, capacity);
    }

    public void deleteStore(StoreDo storeDo) {
        int id = storeDo.getId();
        storeMapper.deleteStore(id);
    }

    public boolean findById(int id) {
        if (storeMapper.findById(id).size() > 0) {
            return true;
        }
        return false;
    }

    public List<StoreDo> selectAllRecord() {
        return storeMapper.selectAll();
    }
}
