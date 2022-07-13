package com.myPJ.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MainPage {
    @Id
    int id;

    public MainPage() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
