package com.myPJ.demo.controller;

import com.myPJ.demo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@Controller
public class MainPageController {
    @Autowired
    DepartmentRepository departmentRepository;

    @GetMapping("/main")
    public String showMainPage() {
        return "main_page";
    }
}
