package com.hbcmis.service;

import com.hbcmis.entity.repository.MedicineDo;
import com.hbcmis.mapper.MedicineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hbc-asuna
 */
@Service
public class MedicineService {
    @Autowired
    MedicineMapper medicineMapper;

    /**
     * 添加
     *
     * @param medicineDo
     * @return
     */
    public String addType(MedicineDo medicineDo) {
        List<MedicineDo> medicineDoList = medicineMapper.selectByNameAndProducer(medicineDo.getMedicineName(), medicineDo.getMedicineProducer());
        if (medicineDoList.size() <= 0) {
            addNewType(medicineDo);
            return "success";
        }
        MedicineDo newMedicineDo = medicineDoList.get(0);
        if (medicineDo.getMedicinePrice() != 0) {
            newMedicineDo.setMedicinePrice(medicineDo.getMedicinePrice());
        }
        if (medicineDo.getMedicineUnit() != null) {
            newMedicineDo.setMedicineUnit(medicineDo.getMedicineUnit());
        }
        newMedicineDo.setMedicineDescription(medicineDo.getMedicineDescription());
        update(newMedicineDo);
        return "success";
    }

    /**
     * 删除
     *
     * @param medicineDo
     * @return
     */
    public String deleteType(MedicineDo medicineDo) {
        delete(medicineDo);
        return "success";
    }

    /**
     * 更新
     *
     * @param medicineDo
     * @return
     */
    public String updateType(MedicineDo medicineDo) {
        update(medicineDo);
        return "success";
    }

    public List<MedicineDo> selectByName(String name) {
        name = "%" + name + "%";
        return medicineMapper.selectByName(name);
    }

    public boolean findById(int id) {
        if (medicineMapper.findById(id).size() > 0) {
            return true;
        }
        return false;
    }

    public List<MedicineDo> selectByProducer(String producer) {
        producer = "%" + producer + "%";
        return medicineMapper.selectByProducer(producer);
    }

    public List<MedicineDo> selectAll() {
        return medicineMapper.selectAll();
    }

    private void addNewType(MedicineDo medicineDo) {
        String name = medicineDo.getMedicineName();
        String producer = medicineDo.getMedicineProducer();
        double price = medicineDo.getMedicinePrice();
        String unit = medicineDo.getMedicineUnit();
        String description = medicineDo.getMedicineDescription();
        medicineMapper.addMedicine(name, producer, price, unit, description);
    }

    private void update(MedicineDo medicineDo) {
        int id = medicineDo.getId();
        String name = medicineDo.getMedicineName();
        String producer = medicineDo.getMedicineProducer();
        double price = medicineDo.getMedicinePrice();
        String unit = medicineDo.getMedicineUnit();
        String description = medicineDo.getMedicineDescription();
        medicineMapper.updateMedicine(id, name, producer, price, unit, description);
    }

    private void delete(MedicineDo medicineDo) {
        medicineMapper.deleteMedicine(medicineDo.getId());
    }

    public List<MedicineDo> selectAllRecord() {
        return medicineMapper.selectAll();
    }

    public List<MedicineDo> selectRecordByFilter(String producer, String name) {
        name = "%" + name + "%";
        producer = "%" + producer + "%";
        return medicineMapper.selectByFilter(producer, name);
    }
}
