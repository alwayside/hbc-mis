package com.hbcmis.entity.dto;

import java.sql.Timestamp;

/**
 * @author hbc-asuna
 */
public class TimeDto {

    public Timestamp getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Timestamp beginDate) {
        this.beginDate = beginDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    private Timestamp beginDate;
    private Timestamp endDate;

}
