package com.zolotenkov.spring.springboot.zori_zavod.accounting_production_operations.repository;

import com.zolotenkov.spring.springboot.zori_zavod.accounting_production_operations.entity.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OperationRepository extends JpaRepository<Operation, Long> {
}
