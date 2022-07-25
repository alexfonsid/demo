package com.myPJ.demo.controller;

import com.myPJ.demo.model.ErrorDB;
import com.myPJ.demo.model.Printer;
import com.myPJ.demo.repository.CabinetRepository;
import com.myPJ.demo.repository.ErrorDBRepository;
import com.myPJ.demo.repository.PrinterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PrinterController {
    @Autowired
    PrinterRepository printerRepository;
    @Autowired
    CabinetRepository cabinetRepository;
    @Autowired
    ErrorDBRepository errorDBRepository;

    @GetMapping("/printers")
    public String showTablePrinter(Model model) {
        List<Printer> printers = printerRepository.findAll();
        model.addAttribute("printers", printers);
        return "printers";
    }

    @GetMapping("/printers-delete")
    public String deletePrinter(@RequestParam int id) {
        printerRepository.deleteById(id);
        return "redirect:printers";
    }

    @GetMapping("/printers-update")
    public String updatePrinter(@RequestParam int id, Model model) {
        Printer printer = printerRepository.findById(id).get();
        model.addAttribute("cabinets", cabinetRepository.findAll());
        model.addAttribute("printer", printer);
        return "printers_update";
    }

    @PostMapping("/printers-update")
    public String updatePrinter(@ModelAttribute Printer printer) {
        String outPage = "redirect:printers";
        try {
            printerRepository.save(printer);
        } catch (Exception e) {
            ErrorDB errorUpdate = new ErrorDB(1, "Такой принтер уже существует. Can't UPDATE.");
            errorDBRepository.save(errorUpdate);
            outPage = "redirect:errors";
        }
        return outPage;
    }

    @GetMapping("/printers-add")
    public String addPrinter(Model model) {
        model.addAttribute("cabinets", cabinetRepository.findAll());
        return "printers_add";
    }

    @PostMapping("/printers-add")
    public String addPrinter(@ModelAttribute Printer printer){
        String outPage = "redirect:printers";
        try {
            printerRepository.save(printer);
        } catch (Exception e) {
            ErrorDB errorAdd = new ErrorDB(1, "Такой принтер уже существует. Can't ADD.");
            errorDBRepository.save(errorAdd);
            outPage = "redirect:errors";
        }
        return outPage;
    }
}
