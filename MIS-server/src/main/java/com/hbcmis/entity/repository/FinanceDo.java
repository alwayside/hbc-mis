package com.hbcmis.entity.repository;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author hbc-asuna
 */
public class FinanceDo {
    private int id;
    private Long financeBill;
    private BigDecimal financeSum;
    private Timestamp financeDate;
    /**
     * 1 means purchase 0 means sell
      */
    private int financeType;

    public int getFinanceType() {
        return financeType;
    }

    public void setFinanceType(int financeType) {
        this.financeType = financeType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getFinanceBill() {
        return financeBill;
    }

    public void setFinanceBill(Long financeBill) {
        this.financeBill = financeBill;
    }

    public BigDecimal getFinanceSum() {
        return financeSum;
    }

    public void setFinanceSum(BigDecimal financeSum) {
        this.financeSum = financeSum;
    }

    public Timestamp getFinanceDate() {
        return financeDate;
    }

    public void setFinanceDate(Timestamp financeDate) {
        this.financeDate = financeDate;
    }

    @Override
    public String toString() {
        return "FinanceDo{" +
                "id=" + id +
                ", financeBill=" + financeBill +
                ", financeSum=" + financeSum +
                ", financeDate=" + financeDate +
                '}';
    }
}
