package com.zolotenkov.spring.springboot.zori_zavod.accounting_production_operations.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class OperationHistory {
    @Id
    private Long id;

    private LocalDate date;

    private String technologyName;

    private String operationName;

    public OperationHistory() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTechnologyName(String technologyName) {
        this.technologyName = technologyName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getTechnologyName() {
        return technologyName;
    }

    public String getOperationName() {
        return operationName;
    }
}
