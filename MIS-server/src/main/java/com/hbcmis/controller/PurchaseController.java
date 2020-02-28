package com.hbcmis.controller;

/**
 * @author hbc-asuna
 */

import com.hbcmis.entity.dto.PurchaseDto;
import com.hbcmis.entity.dto.TimeDto;
import com.hbcmis.entity.repository.MedicineDo;
import com.hbcmis.entity.repository.PurchaseDo;
import com.hbcmis.service.MedicineService;
import com.hbcmis.service.PurchaseService;
import com.hbcmis.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Purchase")
public class PurchaseController {

    @Autowired
    PurchaseService purchaseService;

    @Autowired
    StoreService storeService;

    @Autowired
    MedicineService medicineService;

    @PutMapping
    public ResponseEntity<?> medicinePurchase(@RequestParam int purchaseType,
                                              @RequestParam int purchaseNumber,
                                              @RequestParam int purchaseStore)  {
        if (medicineService.findById(purchaseType) && storeService.findById(purchaseStore)) {
            try {
                String result = purchaseService.medicinePurchase(purchaseType, purchaseNumber, purchaseStore);
            }catch (Exception e){
                return new ResponseEntity<>( e.toString(), HttpStatus.OK);
            }
            return new ResponseEntity<>("success", HttpStatus.OK);
        }
        return new ResponseEntity<>("Store or Type not found", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/all")
    public ResponseEntity<?> selectAllRecord() {
        List<PurchaseDto> purchaseDtoList = purchaseService.selectAllRecord();
        return new ResponseEntity<>(purchaseDtoList, HttpStatus.OK);
    }

    @PostMapping("/record")
    public ResponseEntity<?> selectRecordByFilter(@RequestBody TimeDto timeDto,
                                                  @RequestParam(value = "purchaseType", required = false) Integer purchaseType,
                                                  @RequestParam(required = false) Integer purchaseStore,
                                                  @RequestParam(required = false) Long bill) {
        List<PurchaseDto> purchaseDtoList = purchaseService.selectRecordByFilter(purchaseType,purchaseStore,bill,timeDto);
        return new ResponseEntity<>(purchaseDtoList, HttpStatus.OK);
    }
//    @GetMapping("/date")
//    public ResponseEntity<?> selectByProducer() {
//        List<PurchaseDto> medicineDoList = medicineService.selectAll();
//        return new ResponseEntity<>(medicineDoList, HttpStatus.OK);
//    }
}
