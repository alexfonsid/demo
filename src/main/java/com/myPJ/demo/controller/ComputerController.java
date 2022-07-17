package com.myPJ.demo.controller;

import com.myPJ.demo.model.Cabinet;
import com.myPJ.demo.model.Computer;
import com.myPJ.demo.repository.CabinetRepository;
import com.myPJ.demo.repository.ComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ComputerController {
    @Autowired
    ComputerRepository computerRepository;
    @Autowired
    CabinetRepository cabinetRepository;

    @GetMapping("/computers")
    public String showTableComputer(Model model) {
        List<Computer> computers = computerRepository.findAll();
        model.addAttribute("computers", computers);
        return "computers";
    }

    @GetMapping("/computers-delete")
    public String deleteComputer(@RequestParam int id) {
        computerRepository.deleteById(id);
        return "redirect:computers";
    }

    @GetMapping("/computers-update")
    public String updateCabinet(@RequestParam int id, Model model) {
        Computer computer = computerRepository.findById(id).get();
        model.addAttribute("cabinets", cabinetRepository.findAll());
        model.addAttribute("computer", computer);
        return "computers_update";
    }

    @PostMapping("/computers-update")
    public String updateCabinet(@ModelAttribute Computer computer) {
        computerRepository.save(computer);
        return "redirect:computers";
    }

    @GetMapping("/computers-add")
    public String addComputer(Model model) {
        model.addAttribute("cabinets", cabinetRepository.findAll());
        return "computers_add";
    }

    @PostMapping("/computers-add")
    public String addComputer(@ModelAttribute Computer computer) {
        computerRepository.save(computer);
        return "redirect:computers";
    }
}

