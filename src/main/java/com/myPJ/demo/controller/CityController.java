package com.myPJ.demo.controller;

import com.myPJ.demo.model.City;
import com.myPJ.demo.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/delete")
    public String delete(@RequestParam int id) {
        cityRepository.deleteById(id);
        return "redirect:cities";
    }

    @GetMapping("/update")
    public String update(@RequestParam int id, Model model) {
        City city = cityRepository.findById(id).get();
        model.addAttribute("city", city);
        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute City city) {
        cityRepository.save(city);
        return "redirect:cities";
    }

    @GetMapping("/add")
    public String add() {
        return "add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute City city) {
        cityRepository.save(city);
        return "redirect:cities";
    }

}
