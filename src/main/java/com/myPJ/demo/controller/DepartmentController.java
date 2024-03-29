package com.myPJ.demo.controller;

import com.myPJ.demo.model.Department;
import com.myPJ.demo.model.ErrorDB;
import com.myPJ.demo.repository.DepartmentRepository;
import com.myPJ.demo.repository.ErrorDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Controller
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
        String outPage = "redirect:departments";
        try {
            departmentRepository.save(department);
        } catch (Exception exception) {
            ErrorDB errorUpdate = new ErrorDB(1, "Такой отдел уже существует. Can't UPDATE.");
            errorDBRepository.save(errorUpdate);
            outPage = "redirect:errors";
        }
        return outPage;
    }

    @GetMapping("/departments-add")
    public String addDepartment() {
        return "departments_add";
    }

    @PostMapping("/departments-add")
    public String addDepartment(@ModelAttribute Department department) {
        String outPage = "redirect:departments";
        try {
            departmentRepository.save(department);
        } catch (Exception exception) {
            ErrorDB errorAdd = new ErrorDB(1, "Такой отдел уже существует. Can't ADD.");
            errorDBRepository.save(errorAdd);
            outPage = "redirect:errors";
        }
        return outPage;
    }
}
