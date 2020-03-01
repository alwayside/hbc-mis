package com.hbcmis.service;

import com.hbcmis.entity.dto.SellDto;
import com.hbcmis.entity.dto.TimeDto;
import com.hbcmis.entity.repository.RemainDo;
import com.hbcmis.entity.repository.SellDo;
import com.hbcmis.mapper.RemainMapper;
import com.hbcmis.mapper.SellMapper;
import com.hbcmis.utils.BillBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author hbc-asuna
 */
@Service
public class SellService {

    @Autowired
    private SellMapper sellMapper;

    @Autowired
    private RemainMapper remainMapper;

    @Autowired
    private TransactionService transactionService;

    public String medicineSell(int sellType, int sellNumber, int sellStore) throws Exception {
        Long sellBill = BillBuilder.sellBillCreate();
        while (sellMapper.selectByBill(sellBill).size() > 0) {
            sellBill += 1;
        }
        List<RemainDo> remainDoList = remainMapper.selectByTypeAndStore(sellStore,sellType);
        if (remainDoList.size() == 0){
            return "failed";
        }
        if (remainDoList.get(0).getRemainNumber() < sellNumber){
            return "failed";
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

    public List<SellDto> selectRecordByFilter(Integer sellType, Integer sellStore, Long bill, TimeDto timeDto) {
        Timestamp begin = timeDto.getBeginDate();
        Timestamp end = timeDto.getEndDate();
        if(end == null) {
            begin = null;
        }
        return sellMapper.selectByFilter(sellType,  sellStore, bill, begin, end);
    }
}
