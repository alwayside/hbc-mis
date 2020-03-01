package com.hbcmis.controller;

import com.hbcmis.entity.dto.TimeDto;
import com.hbcmis.entity.repository.FinanceDo;
import com.hbcmis.entity.repository.StoreDo;
import com.hbcmis.service.FinanceService;
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
@RequestMapping("/Finance")
public class FinanceController {

    @Autowired
    private FinanceService financeService;


    @PostMapping("/record")
    public ResponseEntity<?> selectRecordByFilter(@RequestBody TimeDto timeDto,
                                                  @RequestParam(value = "financeType", required = false) Integer financeType,
                                                  @RequestParam(required = false) Long bill) {

        List<FinanceDo> financeDoList = financeService.selectRecordByFilter(financeType,bill,timeDto);
        return new ResponseEntity<>(financeDoList, HttpStatus.OK);
    }
}
