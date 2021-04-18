package com.zolotenkov.spring.springboot.zori_zavod.accounting_production_operations.rest;

import com.zolotenkov.spring.springboot.zori_zavod.accounting_production_operations.entity.Technology;
import com.zolotenkov.spring.springboot.zori_zavod.accounting_production_operations.repository.OperationRepository;
import com.zolotenkov.spring.springboot.zori_zavod.accounting_production_operations.entity.Operation;
import com.zolotenkov.spring.springboot.zori_zavod.accounting_production_operations.repository.TechnologyRepository;
import org.springframework.http.HttpHeaders;
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
    private final TechnologyRepository technologyRepository;

    public OperationController(OperationRepository operationRepository, TechnologyRepository technologyRepository) {
        this.operationRepository = operationRepository;
        this.technologyRepository = technologyRepository;
    }

    @CrossOrigin
    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<List<Operation>> getAllOperations (){
        List<Operation> list = operationRepository.findAllByIsDeletedFalse();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<Operation> getTechnologyById (@PathVariable Long id){
        Operation operation = operationRepository.findById(id).get();
        return new ResponseEntity<>(operation, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping("/tech/add/{techId}")
    public ResponseEntity<Operation> addOperation(@PathVariable Long techId,
                                                  @RequestBody Operation operation) {
        HttpHeaders headers = new HttpHeaders();

        if (operation == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Technology technology = technologyRepository.findById(techId).get();
        operation.setTechnology(technology);
        operationRepository.save(operation);

        return new ResponseEntity<>(operation, headers, HttpStatus.CREATED);
    }

    @CrossOrigin
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Operation> deleteOperation(@PathVariable Long id){
        operationRepository.deleteByIdAndIsDeletedFalse(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
