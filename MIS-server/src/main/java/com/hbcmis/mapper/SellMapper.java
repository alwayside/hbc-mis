package com.hbcmis.mapper;

import com.hbcmis.entity.dto.SellDto;
import com.hbcmis.entity.repository.SellDo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

/**
 * @author hbc-asuna
 */
@Repository
public interface SellMapper {
    List<SellDto> selectId(int id);

    List<SellDo> selectRecordById(int id);

    List<SellDo> selectByBill(@Param("sellBill") Long sellBill);

    void addRecord(@Param("sellBill")Long sellBill, @Param("sellType")int sellType, @Param("sellStore")int sellStore, @Param("sellNumber")int sellNumber);

    List<SellDto> selectByFilter(@Param("sellType") Integer sellType, @Param("sellStore") Integer sellStore, @Param("bill") Long bill, @Param("begin") Timestamp begin, @Param("end") Timestamp end);
}
