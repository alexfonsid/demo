package com.myPJ.demo.controller;

import com.myPJ.demo.model.ErrorDB;
import com.myPJ.demo.model.Monitor;
import com.myPJ.demo.model.Printer;
import com.myPJ.demo.repository.CabinetRepository;
import com.myPJ.demo.repository.ErrorDBRepository;
import com.myPJ.demo.repository.MonitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MonitorController {
    @Autowired
    MonitorRepository monitorRepository;
    @Autowired
    CabinetRepository cabinetRepository;
    @Autowired
    ErrorDBRepository errorDBRepository;

    @GetMapping("/monitors")
    public String showTableMonitor(Model model) {
        List<Monitor> monitors = monitorRepository.findAll();
        model.addAttribute("monitors", monitors);
        return "monitors";
    }

    @GetMapping("/monitors-delete")
    public String deleteMonitor(@RequestParam int id) {
        monitorRepository.deleteById(id);
        return "redirect:monitors";
    }

    @GetMapping("/monitors-update")
    public String updateMonitor(@RequestParam int id, Model model) {
        Monitor monitor = monitorRepository.findById(id).get();
        model.addAttribute("cabinets", cabinetRepository.findAll());
        model.addAttribute("monitor", monitor);
        return "monitors_update";
    }

    @PostMapping("/monitors-update")
    public String updateMonitor(@ModelAttribute Monitor monitor) {
        String outPage = "redirect:monitors";
        try {
            monitorRepository.save(monitor);
        } catch (Exception e) {
            ErrorDB errorUpdate = new ErrorDB(1, "Такой монитор уже существует. Can't UPDATE.");
            errorDBRepository.save(errorUpdate);
            outPage = "redirect:errors";
        }
        return outPage;
    }

    @GetMapping("/monitors-add")
    public String addMonitor(Model model) {
        model.addAttribute("cabinets", cabinetRepository.findAll());
        return "monitors_add";
    }

    @PostMapping("/monitors-add")
    public String addMonitor(@ModelAttribute Monitor monitor){
        String outPage = "redirect:monitors";
        try {
            monitorRepository.save(monitor);
        } catch (Exception e) {
            ErrorDB errorAdd = new ErrorDB(1, "Такой монритор уже существует. Can't ADD.");
            errorDBRepository.save(errorAdd);
            outPage = "redirect:errors";
        }
        return outPage;
    }
}
