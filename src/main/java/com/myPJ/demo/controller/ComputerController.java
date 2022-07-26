package com.myPJ.demo.controller;

import com.myPJ.demo.model.Computer;
import com.myPJ.demo.model.ErrorDB;
import com.myPJ.demo.repository.CabinetRepository;
import com.myPJ.demo.repository.ComputerRepository;
import com.myPJ.demo.repository.ErrorDBRepository;
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
    @Autowired
    ErrorDBRepository errorDBRepository;

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
    public String updateComputer(@RequestParam int id, Model model) {
        Computer computer = computerRepository.findById(id).get();
        model.addAttribute("cabinets", cabinetRepository.findAll());
        model.addAttribute("computer", computer);
        return "computers_update";
    }

    @PostMapping("/computers-update")
    public String updateComputer(@ModelAttribute Computer computer) {
        String outPage = "redirect:computers";
        try {
            computerRepository.save(computer);
        } catch (Exception exception) {
            ErrorDB errorUpdate = new ErrorDB(1, "Такой компьютер уже существует. Can't UPDATE.");
            errorDBRepository.save(errorUpdate);
            outPage = "redirect:errors";
        }
        return outPage;
    }

    @GetMapping("/computers-add")
    public String addComputer(Model model) {
        model.addAttribute("cabinets", cabinetRepository.findAll());
        return "computers_add";
    }

    @PostMapping("/computers-add")
    public String addComputer(@ModelAttribute Computer computer) {
        String outPage = "redirect:computers";
        try {
            computerRepository.save(computer);
        } catch (Exception exception) {
            ErrorDB errorAdd = new ErrorDB(1, "Такой компьютер уже существует. Can't ADD.");
            errorDBRepository.save(errorAdd);
            outPage = "redirect:errors";
        }
        return outPage;
    }
}

