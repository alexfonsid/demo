package com.myPJ.demo.repository;

import com.myPJ.demo.model.Monitor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonitorRepository extends JpaRepository<Monitor, Integer> {
}
