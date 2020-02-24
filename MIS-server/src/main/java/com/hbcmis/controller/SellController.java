package com.hbcmis.controller;

/**
 * @author hbc-asuna
 */

import com.hbcmis.entity.repository.MedicineDo;
import com.hbcmis.service.MedicineService;
import com.hbcmis.service.SellService;
import com.hbcmis.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Sell")
public class SellController {

    @Autowired
    SellService sellService;

    @Autowired
    StoreService storeService;

    @Autowired
    MedicineService medicineService;

    @PutMapping
    public ResponseEntity<?> medicineSell(@RequestParam int sellType,
                                              @RequestParam int sellNumber,
                                              @RequestParam int sellStore)  {
        if (medicineService.findById(sellType) && storeService.findById(sellStore)) {
            try {
                String result = sellService.medicineSell(sellType, sellNumber, sellStore);
            }catch (Exception e){
                return new ResponseEntity<>( e.toString(), HttpStatus.OK);
            }
            return new ResponseEntity<>("success", HttpStatus.OK);
        }
        return new ResponseEntity<>("Store or Type not found", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/all")
    public ResponseEntity<?> selectByProducer() {
        List<MedicineDo> medicineDoList = medicineService.selectAll();
        return new ResponseEntity<>(medicineDoList, HttpStatus.OK);
    }


}
