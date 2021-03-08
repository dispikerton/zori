package com.zolotenkov.spring.springboot.zori_zavod.accounting_production_operations.repository;

import com.zolotenkov.spring.springboot.zori_zavod.accounting_production_operations.entity.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRepository extends JpaRepository<Operation, Long> {

}
