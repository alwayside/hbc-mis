package com.hbcmis.service.impl;

import com.hbcmis.mapper.PurchaseMapper;
import com.hbcmis.mapper.SellMapper;
import com.hbcmis.service.FinanceService;
import com.hbcmis.service.RemainService;
import com.hbcmis.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

/**
 * @author hbc-asuna
 */
@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private PurchaseMapper purchaseMapper;

    @Autowired
    private SellMapper sellMapper;

    @Autowired
    private RemainService remainService;

    @Autowired
    private FinanceService financeService;

    @Override
    @Transactional( rollbackFor = Exception.class)
    public void purchaseExec(Long purchaseBill, int purchaseType, int purchaseNumber, int purchaseStore) {
        try {
            purchaseMapper.addRecord(purchaseBill, purchaseType, purchaseStore, purchaseNumber);
            remainService.numberAdd(purchaseStore,purchaseType,purchaseNumber);
            financeService.purchase(purchaseBill,purchaseType,purchaseNumber);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            throw e;
        }
    }

    @Override
    public void sellExec(Long sellBill, int sellType, int sellNumber, int sellStore) {
        try {
            sellMapper.addRecord(sellBill, sellType, sellStore, sellNumber);
            remainService.numberReduce(sellStore,sellType,sellNumber);
            financeService.sell(sellBill,sellType,sellNumber);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            throw e;
        }
    }
}
