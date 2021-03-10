package com.zolotenkov.spring.springboot.zori_zavod.accounting_production_operations.rest;


import com.zolotenkov.spring.springboot.zori_zavod.accounting_production_operations.entity.Operation;
import com.zolotenkov.spring.springboot.zori_zavod.accounting_production_operations.entity.OperationRecord;
import com.zolotenkov.spring.springboot.zori_zavod.accounting_production_operations.repository.OperationRecordRepository;
import com.zolotenkov.spring.springboot.zori_zavod.accounting_production_operations.repository.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OperationRecordController {

    @Autowired
    private OperationRepository operationRepository;

    @Autowired
    private OperationRecordRepository recordRepository;

    @PostMapping(value = "/operationAdd", produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<List<OperationRecord>> saveOperations(@RequestBody long[] array){
        for (long id : array){
            Operation operation = operationRepository.findById(id).get();
            OperationRecord or = new OperationRecord();
            or.setOperation(operation);
            recordRepository.save(or);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

