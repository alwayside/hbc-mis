package com.hbcmis.controller;

import com.hbcmis.entity.repository.StoreDo;
import com.hbcmis.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author hbc-asuna
 */
@RestController
@RequestMapping("/Store")
public class StoreController {

    @Autowired
    StoreService storeService;

    @PutMapping("/add")
    public ResponseEntity<?> addNewStore(@RequestBody StoreDo storeDo){
        storeService.addNewStore(storeDo);
        return new ResponseEntity<>("success",HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateStore(@RequestBody StoreDo storeDo){
        storeService.updateStore(storeDo);
        return new ResponseEntity<>("success",HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteStore(@RequestBody StoreDo storeDo){
        storeService.deleteStore(storeDo);
        return new ResponseEntity<>("success",HttpStatus.OK);
    }

    @GetMapping("all")
    public ResponseEntity<?> selectAllRecord(){
        List<StoreDo> storeDoList = storeService.selectAllRecord();
        return new ResponseEntity<>(storeDoList,HttpStatus.OK);
    }

    @GetMapping("/record")
    public ResponseEntity<?> selectRecordByFilter(@RequestParam(required = false) String storeName,
                                                  @RequestParam(required = false) String storeAddress) {
        List<StoreDo> medicineDoList;
        medicineDoList = storeService.selectRecordByFilter(storeName, storeAddress);
        return new ResponseEntity<>(medicineDoList, HttpStatus.OK);
    }
}
