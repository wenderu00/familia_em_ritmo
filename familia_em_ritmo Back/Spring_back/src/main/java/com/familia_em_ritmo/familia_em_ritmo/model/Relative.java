package com.familia_em_ritmo.familia_em_ritmo.model;

import jakarta.persistence.*;

import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "relative")
public class Relative {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "relative", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Child> managedChildren;

    public Relative(Long id, String name) {
        this.id = id;
        this.name = name;
        this.managedChildren = new LinkedList<Child>();
    }

    public Relative() {
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
}
