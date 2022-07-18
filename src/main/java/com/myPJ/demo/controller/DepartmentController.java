package com.myPJ.demo.controller;

import com.myPJ.demo.model.Department;
import com.myPJ.demo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class DepartmentController {
    @Autowired
    DepartmentRepository departmentRepository;

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
    public String addDepartment(@ModelAttribute Department department) {
        departmentRepository.save(department);
        return "redirect:departments";
    }

    @PostMapping("/departments-add")
    public String addDepartmentFromFife
            (@ModelAttribute Department department, FileInputStream fileInputStream)
            throws IOException {
        int fileLength = fileInputStream.available();
        byte[] data = new byte[fileLength];
        fileInputStream.read(data);
        String fileData = new String(data);
        ArrayList<String[]> lineWords = new ArrayList<>();
        String[] strings = fileData.split("\n");
        for (String line : strings) {
            String[] words = line.split(";");
            departmentRepository.save(department);
        }
        return "redirect:departments";
    }
}
