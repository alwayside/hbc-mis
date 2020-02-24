package com.hbcmis.service;

import com.hbcmis.entity.repository.AdminDo;
import com.hbcmis.entity.repository.MedicineDo;
import com.hbcmis.mapper.AdminMapper;
import com.hbcmis.mapper.FinanceMapper;
import com.hbcmis.mapper.MedicineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author hbc-asuna
 */
@Service
public class FinanceService {
    @Autowired
    FinanceMapper financeMapper;

    @Autowired
    MedicineMapper medicineMapper;

    public void purchase(Long financeBill,int type,int num) {
        MedicineDo medicineDo = medicineMapper.findById(type).get(0);
        BigDecimal sum = sumCalculate(medicineDo.getMedicinePrice(),num);
        financeMapper.addRecord(financeBill,sum,1);
    }

    public void sell(Long financeBill,int type,int num) {
        MedicineDo medicineDo = medicineMapper.findById(type).get(0);
        BigDecimal sum = sumCalculate(medicineDo.getMedicinePrice(),num);
        financeMapper.addRecord(financeBill,sum,0);
    }

    private  BigDecimal sumCalculate(double medicinePrice,int medicineNum){
        BigDecimal price = new BigDecimal(medicinePrice);
        BigDecimal mount = new BigDecimal(medicineNum);
        return price.multiply(mount);
    }
}
