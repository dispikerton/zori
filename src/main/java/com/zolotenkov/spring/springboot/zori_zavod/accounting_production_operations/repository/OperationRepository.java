package com.zolotenkov.spring.springboot.zori_zavod.accounting_production_operations.repository;

import com.zolotenkov.spring.springboot.zori_zavod.accounting_production_operations.entity.Operation;
import com.zolotenkov.spring.springboot.zori_zavod.accounting_production_operations.entity.Technology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OperationRepository extends JpaRepository<Operation, Long> {
    void deleteByIdAndIsDeletedFalse(Long id);

    List<Operation> findAllByIsDeletedFalse();

    List<Operation> findAllByTechnologyAndAndIsDeletedFalse(Technology technology);
}