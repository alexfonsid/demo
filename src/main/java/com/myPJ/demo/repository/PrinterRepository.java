package com.myPJ.demo.repository;

import com.myPJ.demo.model.Printer;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface PrinterRepository extends JpaRepository<Printer, Integer> {
}
