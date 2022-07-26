package com.myPJ.demo.controller;

import com.myPJ.demo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

@Controller
public class MainPageController {
    @Autowired
    DepartmentRepository departmentRepository;

    @GetMapping("/main")
    public String showMainPage() {
        return "main_page";
    }

//    @PostMapping("uploadFileDepartment")
//    public String uploadFileDepartment(@RequestParam("file")MultipartFile file, Model model) throws IOException {
//        FileInputStream stream = new FileInputStream((File) file);
//        int length = stream.available();
//        byte[] data = new byte[length];
//        stream.read(data);
//        String text = new String(data);
//
//
//
//        return null;
//    }
}
