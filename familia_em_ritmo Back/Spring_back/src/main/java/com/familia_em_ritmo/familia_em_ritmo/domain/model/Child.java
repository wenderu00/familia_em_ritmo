package com.familia_em_ritmo.familia_em_ritmo.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Child {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    @ManyToOne
    @JoinColumn(name = "relative_id")
    @JsonBackReference
    private Relative relative;

    public Child(String name, int age, Relative relative) {
        this.name = name;
        this.age = age;
        this.relative = relative;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Child() {
    }

    public Relative getRelativeManager() {
        return relative;
    }

    public void setRelativeManager(Relative relative) {
        this.relative = relative;
    }
}
