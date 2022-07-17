package com.myPJ.demo.repository;

import com.myPJ.demo.model.Computer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComputerRepository extends JpaRepository<Computer, Integer> {
}
