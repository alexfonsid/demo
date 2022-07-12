package com.myPJ.demo.repository;

import com.myPJ.demo.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Integer> {
}
