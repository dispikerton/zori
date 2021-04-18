package com.zolotenkov.spring.springboot.zori_zavod.accounting_production_operations.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.zolotenkov.spring.springboot.zori_zavod.accounting_production_operations.entity.Operation;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "technology")
public class Technology implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(orphanRemoval = true, mappedBy = "technology")
    @JsonManagedReference
    List<Operation> operations = new ArrayList<>();

    @Column(name = "isDeleted")
    private Boolean isDeleted;

    public Technology() {
    }

    public Technology(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }
}
