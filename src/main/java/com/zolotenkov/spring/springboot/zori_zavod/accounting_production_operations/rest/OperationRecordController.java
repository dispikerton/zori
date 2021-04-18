package com.zolotenkov.spring.springboot.zori_zavod.accounting_production_operations.rest;


import com.zolotenkov.spring.springboot.zori_zavod.accounting_production_operations.entity.Operation;
import com.zolotenkov.spring.springboot.zori_zavod.accounting_production_operations.entity.OperationHistory;
import com.zolotenkov.spring.springboot.zori_zavod.accounting_production_operations.entity.OperationRecord;
import com.zolotenkov.spring.springboot.zori_zavod.accounting_production_operations.entity.Technology;
import com.zolotenkov.spring.springboot.zori_zavod.accounting_production_operations.repository.OperationRecordRepository;
import com.zolotenkov.spring.springboot.zori_zavod.accounting_production_operations.repository.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class OperationRecordController {
    
    private final OperationRepository operationRepository;
    private final OperationRecordRepository recordRepository;

    public OperationRecordController(OperationRepository operationRepository, OperationRecordRepository recordRepository) {
        this.operationRepository = operationRepository;
        this.recordRepository = recordRepository;
    }

    @CrossOrigin
    @GetMapping("/record/all")
    private List<OperationHistory> allOperationsRecords(){
        List<Object[]> allObjects = recordRepository.findAllJoinRecords();
        List<OperationHistory> allRecords = new ArrayList<>();
        allObjects.forEach((objects -> {
                    OperationHistory oh = new OperationHistory();
                    oh.setId((Long) objects[0]);
                    oh.setDate((LocalDate) objects[1]);
                    oh.setTechnologyName((String) objects[2]);
                    oh.setOperationName((String) objects[3]);
                    allRecords.add(oh);
                }));
        return allRecords;
    }

    @CrossOrigin
    @PostMapping(value = "/record/add", produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<List<OperationRecord>> saveOperationsRecords(@RequestBody long[] array){
        for (long id : array){
            Operation operation = operationRepository.findById(id).get();
            OperationRecord record = new OperationRecord();
            record.setOperation(operation);
            record.setDate(LocalDate.now());
            recordRepository.save(record);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @CrossOrigin
    @DeleteMapping("/record/delete/{techId}")
    private ResponseEntity<Technology> deleteOperationRecord(@PathVariable Long techId) {
        recordRepository.deleteById(techId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    };
}