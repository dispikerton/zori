package com.zolotenkov.spring.springboot.zori_zavod.accounting_production_operations.repository;

import com.zolotenkov.spring.springboot.zori_zavod.accounting_production_operations.entity.Technology;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnologyRepository extends JpaRepository<Technology, Long> {
}
