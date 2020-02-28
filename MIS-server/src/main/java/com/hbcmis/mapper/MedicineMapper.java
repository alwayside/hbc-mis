package com.hbcmis.mapper;

import com.hbcmis.entity.repository.MedicineDo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author hbc-asuna
 */
@Repository
public interface MedicineMapper {

    /**
     * select record by name and producer
     *
     * @param medicineName
     * @param medicineProducer
     * @return
     */
    public List<MedicineDo> selectByNameAndProducer(@Param("medicineName") String medicineName, @Param("medicineProducer") String medicineProducer);

    /**
     * add a new record
     *
     * @param medicineName
     * @param medicineProducer
     * @param medicinePrice
     * @param medicineUnit
     * @param medicineDescription
     */
    public void addMedicine(@Param("medicineName") String medicineName, @Param("medicineProducer") String medicineProducer, @Param("medicinePrice") double medicinePrice, @Param("medicineUnit") String medicineUnit, @Param("medicineDescription") String medicineDescription);

    /**
     * update a record
     *
     * @param id
     * @param medicineName
     * @param medicineProducer
     * @param medicinePrice
     * @param medicineUnit
     * @param medicineDescription
     */
    public void updateMedicine(@Param("id") int id, @Param("medicineName") String medicineName, @Param("medicineProducer") String medicineProducer, @Param("medicinePrice") double medicinePrice, @Param("medicineUnit") String medicineUnit, @Param("medicineDescription") String medicineDescription);

    /**
     * sign a record is delete
     *
     * @param id
     */
    public void deleteMedicine(@Param("id") int id);

    /**
     * select all
     * @return
     */
    public List<MedicineDo> selectAll();

    /**
     * select record by name
     * @param medicineName
     * @return
     */
    public List<MedicineDo> selectByName(@Param("medicineName") String medicineName);

    /**
     * select record by producer
     *
     * @param medicineProducer
     * @return
     */
    public List<MedicineDo> selectByProducer(@Param("medicineProducer") String medicineProducer);

    /**
     * test
     * @param id
     * @return
     */
    public List<MedicineDo> selectById(@Param("id") int id);

    /**
     * find record
     * @param id
     * @return
     */
    public List<MedicineDo> findById(@Param("id") int id);

    List<MedicineDo> selectByFilter(@Param("medicineProducer") String medicineProducer,@Param("medicineName")  String medicineName);
}
