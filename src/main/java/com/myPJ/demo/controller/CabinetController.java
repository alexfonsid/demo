package com.myPJ.demo.controller;

import com.myPJ.demo.model.Cabinet;
import com.myPJ.demo.model.Department;
import com.myPJ.demo.repository.CabinetRepository;
import com.myPJ.demo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CabinetController {
    @Autowired
    CabinetRepository cabinetRepository;
    @Autowired
    DepartmentRepository departmentRepository;

    @GetMapping("/cabinets")
    public String showTableCabinet(Model model) {
        List<Cabinet> cabinets = cabinetRepository.findAll();
        model.addAttribute("cabinets", cabinets);
        return "cabinets";
    }

    @GetMapping("/cabinets-add")
    public String addCabinet(Model model) {
        model.addAttribute("departments", departmentRepository.findAll());
        return "cabinets_add";
    }

    @PostMapping("/cabinets-add")
    public String addCabinet(@ModelAttribute Cabinet cabinet) {
        cabinetRepository.save(cabinet);
        return "redirect:cabinets";
    }
}
