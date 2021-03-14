package com.zolotenkov.spring.springboot.zori_zavod.accounting_production_operations.rest;

import com.zolotenkov.spring.springboot.zori_zavod.accounting_production_operations.repository.OperationRepository;
import com.zolotenkov.spring.springboot.zori_zavod.accounting_production_operations.entity.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/operation")
@CrossOrigin
public class OperationController {

    private final OperationRepository operationRepository;

    public OperationController(OperationRepository operationRepository) {
        this.operationRepository = operationRepository;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Operation> deleteOperation(@PathVariable Long id){
        operationRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<List<Operation>> getAllOperations (){
        List<Operation> list = operationRepository.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<Operation> getTechnologyById (@PathVariable Long id){
        Operation operation = operationRepository.findById(id).get();
        return new ResponseEntity<>(operation, HttpStatus.OK);
    }
}
