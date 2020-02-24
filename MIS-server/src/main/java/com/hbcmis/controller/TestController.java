package com.hbcmis.controller;


import com.hbcmis.service.AdminService;
import com.hbcmis.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private PurchaseService purchaseService;

    @RequestMapping("getUser/{id}")
    public String GetUser(@PathVariable int id){
        String result = adminService.selectAdmin(id).toString();
        return result;
    }

    @RequestMapping("purchase/{id}")
    public String getPurchase(@PathVariable int id){
        String result = purchaseService.selectPurchase(id).toString();
        return result;
    }

    @RequestMapping("purchaseDo/{id}")
    public String getPurchaseDo(@PathVariable int id){
        String result = purchaseService.selectPurchaseDoById(id).toString();
        return result;
    }
}

