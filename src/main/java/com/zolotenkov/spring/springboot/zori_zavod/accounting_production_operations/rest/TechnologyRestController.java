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
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class TechnologyRestController {

    private final TechnologyRepository technologyRepository;
    private final OperationRepository operationRepository;

    public TechnologyRestController(TechnologyRepository technologyRepository, OperationRepository operationRepository) {
        this.technologyRepository = technologyRepository;
        this.operationRepository = operationRepository;
    }

    @CrossOrigin
    @GetMapping("/tech/{id}/operation/all")
    private ResponseEntity<List<Operation>> allOperationsByTechnology(@PathVariable Long id){
        Technology technology = technologyRepository.findByIdAndIsDeletedFalse(id);
        List<Operation> list = operationRepository.findAllByTechnologyAndAndIsDeletedFalse(technology);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/tech/all", produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<List<Technology>> getAllTechnologies (){
        List<Technology> list = technologyRepository.findAllByIsDeletedFalse();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/tech/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<Technology> getTechnologyById (@PathVariable Long id){
        Technology technology = technologyRepository.findByIdAndIsDeletedFalse(id);
        return new ResponseEntity<>(technology, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping(value = "/tech/add", produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<Technology> saveTechnology(@RequestBody Technology technology){
        if (technology == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        technologyRepository.save(technology);
        return new ResponseEntity<>(technology, HttpStatus.CREATED);
    }

    @CrossOrigin
    @PostMapping(value = "/operation/add", produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<Operation> saveOperation(@RequestBody Operation operation){
        if (operation == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        this.operationRepository.save(operation);
        return new ResponseEntity<>(operation, HttpStatus.CREATED);
    }

    @CrossOrigin
    @DeleteMapping("/tech/delete/{techId}")
    private ResponseEntity<Technology> deleteTechnology(@PathVariable Long techId) {
        technologyRepository.deleteById(techId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
