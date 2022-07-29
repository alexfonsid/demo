package com.myPJ.demo.controller;

import com.myPJ.demo.model.Cabinet;
import com.myPJ.demo.model.Department;
import com.myPJ.demo.repository.CabinetRepository;
import com.myPJ.demo.repository.DepartmentRepository;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.SecondaryTable;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class MainPageController extends HttpServlet {
    private Set<Department> departmentSet = new HashSet<>(3000);

    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    CabinetRepository cabinetRepository;
    @Autowired

    @GetMapping("/main")
    public String showMainPage() {
        return "main_page";
    }

    private String[] fromFileToLines(MultipartFile multipartFile) throws IOException {
        InputStream stream = multipartFile.getInputStream();
        int length = stream.available();
        byte[] data = new byte[length];
        stream.read(data);
        String text = new String(data);
        return text.split("\n");
    }

    @PostMapping("/upload-file-department")
    public String uploadFileDepartment(@RequestParam("fileDepartments") MultipartFile multipartFile) throws IOException {
        String[] lines = fromFileToLines(multipartFile);
        for (String line : lines) {
            if(line != null){
                departmentRepository.save(new Department(line));
//                departmentSet.add(new Department(line));
            }
        }
//        for (Department curDepartment: departmentSet) {
//            departmentRepository.save(curDepartment);
//        }
        return "redirect:departments";
    }

    @PostMapping("/upload-file-cabinet")
    public String uploadFileCabinet(@RequestParam("fileCabinets") MultipartFile multipartFile) throws IOException {
        String[] lines = fromFileToLines(multipartFile);
        for (String line : lines) {
            String[] words = line.split(";");
            for (int i = 0; i < words.length; ) {
                cabinetRepository.save(new Cabinet(words[i], words[i + 1]));
                i += 2;
            }
        }
        return "redirect:cabinets";
    }

}
