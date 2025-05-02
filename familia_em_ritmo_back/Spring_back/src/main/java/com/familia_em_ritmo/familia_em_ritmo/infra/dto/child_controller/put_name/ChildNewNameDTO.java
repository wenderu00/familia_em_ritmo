package com.familia_em_ritmo.familia_em_ritmo.infra.dto.child_controller.put_name;

public class ChildNewNameDTO {
    String name;

    public ChildNewNameDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
