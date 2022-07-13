package com.myPJ.demo.controller;

import com.myPJ.demo.model.Cabinet;
import com.myPJ.demo.repository.CabinetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CabinetController {
    @Autowired
    CabinetRepository cabinetRepository;

    @GetMapping("/cabinets")
    public String showTableCabinet(Model model) {
        List<Cabinet> cabinets = cabinetRepository.findAll();
        model.addAttribute("cabinets", cabinets);
        return "cabinets";
    }
}
