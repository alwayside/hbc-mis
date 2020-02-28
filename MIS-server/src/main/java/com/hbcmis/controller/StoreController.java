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

    @PostMapping("/addNewStore")
    public ResponseEntity<?> addNewStore(@RequestBody StoreDo storeDo){
        storeService.addNewStore(storeDo);
        return new ResponseEntity<>("success",HttpStatus.OK);
    }

    @PostMapping("/updateStore")
    public ResponseEntity<?> updateStore(@RequestBody StoreDo storeDo){
        storeService.updateStore(storeDo);
        return new ResponseEntity<>("success",HttpStatus.OK);
    }

    @PostMapping("/deleteStore")
    public ResponseEntity<?> deleteStore(@RequestBody StoreDo storeDo){
        storeService.deleteStore(storeDo);
        return new ResponseEntity<>("success",HttpStatus.OK);
    }

    @GetMapping("all")
    public ResponseEntity<?> selectAllRecord(){
        List<StoreDo> storeDoList = storeService.selectAllRecord();
        return new ResponseEntity<>(storeDoList,HttpStatus.OK);
    }
}
