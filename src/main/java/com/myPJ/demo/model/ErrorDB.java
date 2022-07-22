package com.myPJ.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ErrorDB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String mistake;

    public ErrorDB() {
    }

    public ErrorDB(String mistake) {
        this.mistake = mistake;
    }

    public ErrorDB(int id, String exception) {
        this.id = id;
        this.mistake = exception;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMistake() {
        return mistake;
    }

    public void setMistake(String mistake) {
        this.mistake = mistake;
    }

    @Override
    public String toString() {
        return "ERROR:  " + mistake;
    }
}
