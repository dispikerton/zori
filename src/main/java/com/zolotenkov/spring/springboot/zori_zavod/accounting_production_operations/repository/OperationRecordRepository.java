package com.zolotenkov.spring.springboot.zori_zavod.accounting_production_operations.repository;

import com.zolotenkov.spring.springboot.zori_zavod.accounting_production_operations.entity.OperationRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OperationRecordRepository extends JpaRepository<OperationRecord, Long> {

    @Query("SELECT ol.id, ol.date, t.name, od.name " +
            "FROM OperationRecord ol " +
            "JOIN Operation od ON ol.operation.id = od.id " +
            "JOIN Technology t ON od.technology.id = t.id " +
            "ORDER BY ol.date DESC")
    List<Object[]> findAllJoinRecords();
}
