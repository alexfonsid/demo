package com.myPJ.demo.repository;

import com.myPJ.demo.model.ErrorDB;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ErrorDBRepository extends JpaRepository<ErrorDB, Integer> {
}
