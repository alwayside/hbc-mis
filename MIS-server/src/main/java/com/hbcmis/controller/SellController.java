package com.hbcmis.controller;

/**
 * @author hbc-asuna
 */

import com.hbcmis.entity.dto.SellDto;
import com.hbcmis.entity.dto.TimeDto;
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
        String result = "";
        if (medicineService.findById(sellType) && storeService.findById(sellStore)) {
            try {
                result = sellService.medicineSell(sellType, sellNumber, sellStore);
            }catch (Exception e){
                return new ResponseEntity<>( e.toString(), HttpStatus.BAD_REQUEST);
            }
            if ("failed".equals(result)){
                return new ResponseEntity<>("Store haven't got enough number", HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>("success", HttpStatus.OK);
        }
        return new ResponseEntity<>("Store or Type not found", HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/record")
    public ResponseEntity<?> selectRecordByFilter(@RequestBody TimeDto timeDto,
                                                  @RequestParam(value = "sellType", required = false) Integer sellType,
                                                  @RequestParam(required = false) Integer sellStore,
                                                  @RequestParam(required = false) Long bill) {
        List<SellDto> sellDtoList = sellService.selectRecordByFilter(sellType,sellStore,bill,timeDto);
        return new ResponseEntity<>(sellDtoList, HttpStatus.OK);
    }

}
