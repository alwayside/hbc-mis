package com.hbcmis.service;

import com.hbcmis.entity.dto.SellDto;
import com.hbcmis.entity.repository.SellDo;
import com.hbcmis.mapper.SellMapper;
import com.hbcmis.utils.BillBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hbc-asuna
 */
@Service
public class SellService {

    @Autowired
    private SellMapper sellMapper;

    @Autowired
    private TransactionService transactionService;

    public String medicineSell(int sellType, int sellNumber, int sellStore) throws Exception {
        Long sellBill = BillBuilder.sellBillCreate();
        while (sellMapper.selectByBill(sellBill).size() > 0) {
            sellBill += 1;
        }
        transactionService.sellExec(sellBill, sellType, sellNumber, sellStore);
        return "success";
    }

    public SellDto selectSell(int id) {
        return sellMapper.selectId(id).get(0);
    }

    public SellDo selectSellDoById(int id) {
        return sellMapper.selectRecordById(id).get(0);
    }

}
