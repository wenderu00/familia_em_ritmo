package com.familia_em_ritmo.familia_em_ritmo.infra.dto.relative_controller.create;

public class RelativeRequestDTO {
    private String name;

    public RelativeRequestDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
