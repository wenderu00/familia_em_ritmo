package com.familia_em_ritmo.familia_em_ritmo.infra.dto.child_controller.create;

public class ChildResponseDTO {
    private Long id;
    private String name;
    private int age;
    private Long relativeId;
    private String relativeName;

    public ChildResponseDTO(Long id, String name, int age, Long relativeId, String relativeName) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.relativeId = relativeId;
        this.relativeName = relativeName;
    }

    public Long getRelativeId() {
        return relativeId;
    }

    public void setRelativeId(Long relativeId) {
        this.relativeId = relativeId;
    }

    public String getRelativeName() {
        return relativeName;
    }

    public void setRelativeNAme(String relativeNAme) {
        this.relativeName = relativeNAme;
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
}
