package com.myPJ.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
//		createFile();
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
