package com.zolotenkov.spring.springboot.zori_zavod.accounting_production_operations.repository;

import com.zolotenkov.spring.springboot.zori_zavod.accounting_production_operations.entity.Technology;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TechnologyRepository extends JpaRepository<Technology, Long> {
    Technology findByIdAndIsDeletedFalse(Long id);

    List<Technology> findAllByIsDeletedFalse();
}
