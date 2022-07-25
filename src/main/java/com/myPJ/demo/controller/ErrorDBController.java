package com.myPJ.demo.controller;

import com.myPJ.demo.model.ErrorDB;
import com.myPJ.demo.repository.ErrorDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorDBController {
    @Autowired
    ErrorDBRepository errorDBRepository;

    @GetMapping("/errors")
    public String errorsList(Model model) {
        ErrorDB errorDB = errorDBRepository.findById(1).get();
        model.addAttribute("error", errorDB.toString());
        return "errors";
    }
}
