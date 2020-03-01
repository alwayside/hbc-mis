package com.hbcmis.mapper;

import com.hbcmis.entity.repository.FinanceDo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author hbc-asuna
 */
@Repository
public interface FinanceMapper {
    void addRecord(@Param("financeBill") Long financeBill, @Param("financeSum") BigDecimal financeSum, @Param("financeType") int financeType);

    List<FinanceDo> selectByFilter(@Param("financeType")Integer financeType,@Param("bill")  Long bill, @Param("begin") Timestamp begin, @Param("end") Timestamp end);
}
