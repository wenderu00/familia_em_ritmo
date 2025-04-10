package com.familia_em_ritmo.familia_em_ritmo.infra.dto.child_controller.create;

public class ChildRequestDTO {
    private String name;
    private int age;
    private Long relativeId;

    public ChildRequestDTO(String name, int age, Long relativeId) {
        this.name = name;
        this.age = age;
        this.relativeId = relativeId;
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

    public Long getRelativeId() {
        return relativeId;
    }

    public void setRelativeId(Long relativeId) {
        this.relativeId = relativeId;
    }
}
