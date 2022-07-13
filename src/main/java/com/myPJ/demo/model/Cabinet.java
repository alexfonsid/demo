package com.myPJ.demo.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Cabinet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String number;
    String name;
    @ManyToOne
    Department department;

    public Cabinet() {
    }

    public Cabinet(int id, String number, String name, Department department) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
