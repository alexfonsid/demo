package com.myPJ.demo.controller;

import com.myPJ.demo.exception.CustomException;
import com.myPJ.demo.model.Department;
import com.myPJ.demo.model.ErrorDB;
import com.myPJ.demo.repository.DepartmentRepository;
import com.myPJ.demo.repository.ErrorDBRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@SessionAttributes("filename")
public class DepartmentController {
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    ErrorDBRepository errorDBRepository;

    @GetMapping("/departments")
    public String showTableDepartment(Model model) {
        List<Department> departments = departmentRepository.findAll();
        model.addAttribute("departments", departments);
        return "departments";
    }

    @GetMapping("/departments-delete")
    public String deleteDepartment(@RequestParam int id) {
        departmentRepository.deleteById(id);
        return "redirect:departments";
    }

    @GetMapping("/departments-update")
    public String updateDepartment(@RequestParam int id, Model model) {
        Department department = departmentRepository.findById(id).get();
        model.addAttribute("department", department);
        return "departments_update";
    }

    @PostMapping("/departments-update")
    public String updateDepartment(@ModelAttribute Department department) {
        departmentRepository.save(department);
        return "redirect:departments";
    }

    @GetMapping("/departments-add")
    public String addDepartment() {
        return "departments_add";
    }

    @PostMapping("/departments-add")
    public String addDepartment(@Validated @ModelAttribute Department department) {
        try {
            departmentRepository.save(department);
        } catch (Exception e) {
            e.printStackTrace();

            errorDBRepository.save(new ErrorDB( "Can't add department"));
        }
        return "redirect:departments";
    }
}
