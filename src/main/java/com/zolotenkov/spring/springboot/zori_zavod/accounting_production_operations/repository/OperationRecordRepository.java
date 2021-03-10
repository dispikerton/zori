package com.zolotenkov.spring.springboot.zori_zavod.accounting_production_operations.repository;

import com.zolotenkov.spring.springboot.zori_zavod.accounting_production_operations.entity.OperationRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRecordRepository extends JpaRepository<OperationRecord, Long> {
}
