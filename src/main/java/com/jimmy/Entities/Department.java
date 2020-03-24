package com.jimmy.Entities;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@ToString
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;

    @OneToMany(mappedBy="department",cascade=CascadeType.PERSIST)
    private List<Employee> employees = new ArrayList<Employee>();

    public Department() {
        super();
    }
    public Department(String name) {
        this.name = name;
    }
}
