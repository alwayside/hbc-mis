package com.hbcmis.controller;

/**
 * @author hbc-asuna
 */

import com.hbcmis.entity.repository.MedicineDo;
import com.hbcmis.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Medicine")
public class MedicineController {

    @Autowired
    MedicineService medicineService;

    @PostMapping("/add")
    public ResponseEntity<?> addNewMedicine(@RequestBody MedicineDo medicineDo) {
        if (medicineDo.getMedicineName() == null || medicineDo.getMedicineProducer() == null) {
            return new ResponseEntity<>("need producer and name", HttpStatus.BAD_REQUEST);
        }
        medicineService.addType(medicineDo);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteMedicine(@RequestBody MedicineDo medicineDo) {
        if (medicineDo.getId() == 0) {
            return new ResponseEntity<>("Invalid values", HttpStatus.BAD_REQUEST);
        }
        medicineService.deleteType(medicineDo);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateMedicine(@RequestBody MedicineDo medicineDo) {
        if (medicineDo.getId() == 0) {
            return new ResponseEntity<>("Invalid values", HttpStatus.BAD_REQUEST);
        }
        medicineService.updateType(medicineDo);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @GetMapping("all")
    public ResponseEntity<?> selectAllRecord() {
        List<MedicineDo> medicineDoList = medicineService.selectAllRecord();
        return new ResponseEntity<>(medicineDoList, HttpStatus.OK);
    }

    @GetMapping("/name")
    public ResponseEntity<?> selectByName(@RequestParam String name) {
        List<MedicineDo> medicineDoList = medicineService.selectByName(name);
        return new ResponseEntity<>(medicineDoList, HttpStatus.OK);
    }

    @GetMapping("/producer")
    public ResponseEntity<?> selectByProducer(@RequestParam String producer) {
        List<MedicineDo> medicineDoList = medicineService.selectByProducer(producer);
        return new ResponseEntity<>(medicineDoList, HttpStatus.OK);
    }

    @GetMapping("/record")
    public ResponseEntity<?> selectRecordByFilter(@RequestParam(required = false) String producer,
                                                  @RequestParam(required = false) String name) {
        List<MedicineDo> medicineDoList;
        if (producer == null || "".equals(producer)) {
            medicineDoList = medicineService.selectByName(name);
        } else if (name == null || "".equals(name)) {
            medicineDoList = medicineService.selectByProducer(producer);
        } else if (!(producer == null || "".equals(producer)) && !(name == null || "".equals(name))) {
            medicineDoList = medicineService.selectRecordByFilter(producer, name);
        } else {
            medicineDoList = medicineService.selectAll();
        }
        return new ResponseEntity<>(medicineDoList, HttpStatus.OK);
    }

}
