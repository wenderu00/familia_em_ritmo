package com.familia_em_ritmo.familia_em_ritmo.infra.dto.child_controller.put_age;

public class ChildNewAgeDTO {
    int age;

    public ChildNewAgeDTO(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
