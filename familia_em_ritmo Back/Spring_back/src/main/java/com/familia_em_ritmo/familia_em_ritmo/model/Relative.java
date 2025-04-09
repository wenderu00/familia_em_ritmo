package com.familia_em_ritmo.familia_em_ritmo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JsonManagedReference
    private List<Child> managedChildren;

    public List<Child> getManagedChildren() {
        return managedChildren;
    }

    public void setManagedChildren(List<Child> managedChildren) {
        this.managedChildren = managedChildren;
    }

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
