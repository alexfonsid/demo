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
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "department_id")
    Set<Department> department;

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

    public Set<Department> getDepartment() {
        return department;
    }

    public void setDepartment(Set<Department> department) {
        this.department = department;
    }
}
