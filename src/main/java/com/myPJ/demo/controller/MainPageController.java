package com.myPJ.demo.controller;

import com.myPJ.demo.model.Department;
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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class MainPageController extends HttpServlet {
    private Set<Department> departmentSet = new HashSet<>();

    @Autowired
    DepartmentRepository departmentRepository;

    @GetMapping("/main")
    public String showMainPage() {
        return "main_page";
    }

    @PostMapping("/upload-file-department")
    public String uploadFileDepartment(@RequestParam("fileDepartments") MultipartFile multipartFile) throws IOException {
        InputStream stream = multipartFile.getInputStream();
        int length = stream.available();
        byte[] data = new byte[length];
        stream.read(data);
        String text = new String(data);
        String[] lines = text.split("\n");
        for (String line : lines) {
            if(line != null){
                departmentSet.add(new Department(line));
            }
        }
        for (Department curDepartment: departmentSet) {
            departmentRepository.save(curDepartment);
        }
        return "redirect:departments";
    }
}
