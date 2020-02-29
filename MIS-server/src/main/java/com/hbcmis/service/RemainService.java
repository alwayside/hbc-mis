package com.hbcmis.service;

import com.hbcmis.entity.dto.RemainDto;
import com.hbcmis.entity.repository.RemainDo;
import com.hbcmis.mapper.RemainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author bhc-asuna
 */
@Service
public class RemainService {

    @Autowired
    RemainMapper remainMapper;


    public List<RemainDto> selectAll() {
        return remainMapper.selectAll();
    }

    public List<RemainDto> selectByName(String storeName) {
        return remainMapper.selectByName(storeName);
    }

    /**
     * 增加库存
     *
     * @param store
     * @param type
     * @param count
     * @return
     */
    public String numberAdd(int store, int type, int count) {
        List<RemainDo> remainDoList = remainMapper.selectByTypeAndStore(store, type);
        if (remainDoList.size() <= 0) {
            if (count <= 0) {
                return "invalid value";
            }
            remainMapper.addRecord(store, type, count);
            return "success";
        }
        RemainDo remainDo = remainDoList.get(0);
        if ((remainDo.getRemainNumber() + count) > 0) {
            int newCount = remainDo.getRemainNumber() + count;
            remainDo.setRemainNumber(newCount);
            updateRemain(remainDo);
        }
        return "success";
    }

    /**
     * 减少库存
     *
     * @param store
     * @param type
     * @param count
     * @return
     */
    public String numberReduce(int store, int type, int count) {
        List<RemainDo> remainDoList = remainMapper.selectByTypeAndStore(store, type);
        if (remainDoList.size() <= 0) {
            return "no record found";
        }
        RemainDo remainDo = remainDoList.get(0);
        if ((remainDo.getRemainNumber() - count) > 0) {
            int newCount = remainDo.getRemainNumber() - count;
            remainDo.setRemainNumber(newCount);
            updateRemain(remainDo);
        }
        return "success";
    }

    private void updateRemain(RemainDo remainDo) {
        int id = remainDo.getId();
        int number = remainDo.getRemainNumber();
        remainMapper.updateRecord(id, number);
    }

    public List<RemainDto> selectByMedicine(String medicineName) {
        return remainMapper.selectByMedicine(medicineName);
    }

    public List<RemainDto> selectByFilter(String storeName, String medicineName) {
        medicineName = "%" + medicineName + "%";
        storeName = "%" + storeName + "%";
        return remainMapper.selectByFilter(medicineName, storeName);
    }
}
