package com.myPJ.demo.repository;

import com.myPJ.demo.model.Cabinet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CabinetRepository extends JpaRepository<Cabinet, Integer> {
}