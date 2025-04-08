package com.familia_em_ritmo.familia_em_ritmo.model;

import jakarta.persistence.*;

@Entity
public class Child {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    @ManyToOne
    private Relative relativeManager;

    public Child(Long id, String name, int age, Relative relative) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.relativeManager = relative;
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
        return relativeManager;
    }

    public void setRelativeManager(Relative relativeManager) {
        this.relativeManager = relativeManager;
    }
}
