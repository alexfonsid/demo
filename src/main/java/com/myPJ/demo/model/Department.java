package com.myPJ.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;

    Department() {
    }

    Department(int id) {
        this.id = id;
    }

    public Department(String name) {
        this.name = name;
    }

}
