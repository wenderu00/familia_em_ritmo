package com.familia_em_ritmo.familia_em_ritmo.infra.dto.relative_controller.put_relative_name;

public class RelativeNewNameDTO {
    String name;

    public RelativeNewNameDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
