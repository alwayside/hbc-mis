package com.hbcmis.service;

/**
 * @author hbc-asuna
 */
public interface TransactionService {

    public void purchaseExec(Long purchaseBill, int purchaseType, int purchaseNumber, int purchaseStore);

    public void sellExec(Long sellBill, int sellType, int sellNumber, int sellStore);
}
