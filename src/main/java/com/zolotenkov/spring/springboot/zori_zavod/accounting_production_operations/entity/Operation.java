package com.zolotenkov.spring.springboot.zori_zavod.accounting_production_operations.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.context.annotation.Bean;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "operation_directory")
public class Operation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "standard")
    private int standard;

    @Column(name = "ratio")
    private double ratio;

    @ManyToOne
    @JoinColumn(name = "technology_id")
    @JsonBackReference
    private Technology technology;

    public Operation() {
    }

    public Operation(String name) {
        this.name = name;
    }

    public Operation(String name, int standard, double ratio, Technology technology) {
        this.name = name;
        this.standard = standard;
        this.ratio = ratio;
        this.technology = technology;
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

    public int getStandard() {
        return standard;
    }

    public void setStandard(int standard) {
        this.standard = standard;
    }

    public double getRatio() {
        return ratio;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }

    public Technology getTechnology() {
        return technology;
    }

    public void setTechnology(Technology technology) {
        this.technology = technology;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", standard=" + standard +
                ", ratio=" + ratio +
                ", technology=" + technology +
                '}';
    }
}
