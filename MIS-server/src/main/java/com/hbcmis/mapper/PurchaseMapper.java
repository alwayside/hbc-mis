package com.hbcmis.mapper;

import com.hbcmis.entity.dto.PurchaseDto;
import com.hbcmis.entity.repository.PurchaseDo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author hbc-asuna
 */
@Repository
public interface PurchaseMapper {
    List<PurchaseDto> selectId(int id);

    List<PurchaseDto> selectAll();

    List<PurchaseDto> selectByFilter(@Param("purchaseType") Integer purchaseType, @Param("purchaseStore") Integer purchaseStore, @Param("bill") Long bill, @Param("begin") Timestamp begin, @Param("end") Timestamp end);

    ;

    List<PurchaseDo> selectRecordById(int id);

    List<PurchaseDo> selectByBill(@Param("purchaseBill") Long purchaseBill);

    void addRecord(@Param("purchaseBill") Long purchaseBill, @Param("purchaseType") int purchaseType, @Param("purchaseStore") int purchaseStore, @Param("purchaseNumber") int purchaseNumber);
}
