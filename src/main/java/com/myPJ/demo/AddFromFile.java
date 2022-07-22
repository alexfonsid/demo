package com.myPJ.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
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

    public static void createFile() {
        try {
            File file = new File("departments from file.txt");
            if(!file.exists()) {
                file.createNewFile();
            }
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.println("Hello world");
            printWriter.close();
        } catch(IOException e) {
            System.out.println("Error: " + e);
        }
    }
}
