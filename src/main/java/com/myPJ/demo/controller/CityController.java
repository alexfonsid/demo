package com.myPJ.demo.controller;

import com.myPJ.demo.model.City;
import com.myPJ.demo.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CityController {
    @Autowired
    CityRepository cityRepository;

    @GetMapping("/cities")
    public String showTableCity(Model model) {
        List<City> cities = cityRepository.findAll();
        model.addAttribute("cities", cities);
        return "cities";
    }
}
