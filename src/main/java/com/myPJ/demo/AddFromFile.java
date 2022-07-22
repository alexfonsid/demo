package com.myPJ.demo;

import com.myPJ.demo.model.Department;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AddFromFile {
    public static void dataFromFile(File file) {

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
