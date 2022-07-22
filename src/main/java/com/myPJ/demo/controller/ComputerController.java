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

import java.sql.SQLException;
import java.util.List;

@Controller
public class ComputerController extends SQLException {
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
        int id = 1;
        String outPage = "redirect:computers";
        try {
            computerRepository.save(computer);
        } catch (Exception e) {
            ErrorDB errorDB = new ErrorDB(id, "Такой компьютер уже существует");
            errorDBRepository.save(errorDB);
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
    public String addComputer(@ModelAttribute Computer computer){
        int id = 1;
        String outPage = "redirect:computers";
        try {
        computerRepository.save(computer);
        } catch (Exception e) {
            ErrorDB errorDB = new ErrorDB(id, "Такой компьютер уже существует");
            errorDBRepository.save(errorDB);
            outPage = "redirect:errors";
        }
        return outPage;
    }
}

