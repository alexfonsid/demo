package com.myPJ.demo.controller;

import com.myPJ.demo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DepartmentController {
    @Autowired
    DepartmentRepository departmentRepository;

    @GetMapping("/departments")
    public String showTableDepartment() {

        return "departments";
    }
}
