package com.zolotenkov.spring.springboot.zori_zavod.accounting_production_operations.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin
public class MainController {

    @GetMapping
    private String hi(){
        return "Привет";
    }
}
