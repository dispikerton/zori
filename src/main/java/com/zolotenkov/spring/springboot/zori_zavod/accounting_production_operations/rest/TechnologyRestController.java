package com.zolotenkov.spring.springboot.zori_zavod.accounting_production_operations.rest;

import com.zolotenkov.spring.springboot.zori_zavod.accounting_production_operations.entity.Operation;
import com.zolotenkov.spring.springboot.zori_zavod.accounting_production_operations.entity.Technology;
import com.zolotenkov.spring.springboot.zori_zavod.accounting_production_operations.repository.OperationRepository;
import com.zolotenkov.spring.springboot.zori_zavod.accounting_production_operations.repository.TechnologyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TechnologyRestController {

    @Autowired
    private TechnologyRepository technologyRepository;

    @Autowired
    private OperationRepository operationRepository;

    @GetMapping("/tech/{id}/operation/all")
    private ResponseEntity<List<Operation>> allOperationsByTechnology(@PathVariable Long id){
        List<Operation> list = technologyRepository.findById(id).get().getOperations();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @DeleteMapping("/tech/delete/{techId}")
    private ResponseEntity<Technology> deleteTechnology(@PathVariable Long techId) {
        technologyRepository.deleteById(techId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    };

    @PostMapping(value = "/tech/add", produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<Technology> saveTechnology(@RequestBody Technology technology){
        HttpHeaders headers = new HttpHeaders();

        if (technology == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        technologyRepository.save(technology);
        return new ResponseEntity<>(technology, headers, HttpStatus.CREATED);
    }

    @PostMapping(value = "/operation/add", produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<Operation> saveOperation(@RequestBody Operation operation){
        HttpHeaders headers = new HttpHeaders();

        if (operation == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        this.operationRepository.save(operation);
        return new ResponseEntity<>(operation, headers, HttpStatus.CREATED);
    }

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


    @GetMapping(value = "/tech/all", produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<List<Technology>> getAllTechnologies (){
        List<Technology> list = technologyRepository.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping(value = "/tech/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<Technology> getTechnologyById (@PathVariable Long id){
        Technology technology = technologyRepository.findById(id).get();
        return new ResponseEntity<>(technology, HttpStatus.OK);
    }
}
