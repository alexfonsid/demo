package com.myPJ.demo.controller;

import com.myPJ.demo.model.ErrorDB;
import com.myPJ.demo.repository.ErrorDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class ErrorDBController {
    @Autowired
    ErrorDBRepository errorDBRepository;

    @GetMapping("/errors")
    public String errorsList(Model model) {
        int id = 1;
        ErrorDB errorDB = errorDBRepository.findById(id).get();
        errorDB = new ErrorDB("INVALID DATA");
        model.addAttribute("error", errorDB.toString());
        return "errors";
    }
}
