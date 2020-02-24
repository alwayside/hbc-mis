package com.hbcmis.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

/**
 * @author hbc-asuna
 */
@Repository
public interface FinanceMapper {
    void addRecord(@Param("financeBill") Long financeBill, @Param("financeSum") BigDecimal financeSum, @Param("financeType") int financeType);
}
