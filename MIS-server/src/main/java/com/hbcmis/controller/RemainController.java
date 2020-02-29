package com.hbcmis.controller;

/**
 * @author hbc-asuna
 */

import com.hbcmis.entity.dto.RemainDto;
import com.hbcmis.service.RemainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Remain")
public class RemainController {

    @Autowired
    RemainService remainService;

    @GetMapping("/all")
    public ResponseEntity<?> selectAllRecord(@RequestParam(required = false) String storeName,
                                             @RequestParam(required = false) String medicineName){
        List<RemainDto> remainDtoList = null;
        remainDtoList = remainService.selectByFilter(storeName, medicineName);
        return new ResponseEntity<>(remainDtoList, HttpStatus.OK);
    }

}
