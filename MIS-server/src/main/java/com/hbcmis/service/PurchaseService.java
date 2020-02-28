package com.hbcmis.service;

import com.hbcmis.entity.dto.PurchaseDto;
import com.hbcmis.entity.dto.TimeDto;
import com.hbcmis.entity.repository.PurchaseDo;
import com.hbcmis.mapper.PurchaseMapper;
import com.hbcmis.utils.BillBuilder;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.sql.Connection;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author hbc-asuna
 */
@Service
public class PurchaseService {

    @Autowired
    private PurchaseMapper purchaseMapper;

    @Autowired
    private TransactionService transactionService;

    public String medicinePurchase(int purchaseType, int purchaseNumber, int purchaseStore) throws Exception {
        Long purchaseBill = BillBuilder.purchaseBillCreate();
        while (purchaseMapper.selectByBill(purchaseBill).size() > 0) {
            purchaseBill += 1;
        }
        transactionService.purchaseExec(purchaseBill, purchaseType, purchaseNumber, purchaseStore);
        return "success";
    }

    public PurchaseDto selectPurchase(int id) {
        return purchaseMapper.selectId(id).get(0);
    }

    public PurchaseDo selectPurchaseDoById(int id) {
        return purchaseMapper.selectRecordById(id).get(0);
    }

    public List<PurchaseDto> selectAllRecord() { return purchaseMapper.selectAll(); }

    public List<PurchaseDto> selectRecordByFilter(Integer purchaseType, Integer purchaseStore, Long bill, TimeDto timeDto) {
        Timestamp begin = timeDto.getBeginDate();
        Timestamp end = timeDto.getEndDate();
        if(end == null) {
            begin = null;
        }
        return purchaseMapper.selectByFilter(purchaseType,  purchaseStore, bill, begin, end);
    }
}
