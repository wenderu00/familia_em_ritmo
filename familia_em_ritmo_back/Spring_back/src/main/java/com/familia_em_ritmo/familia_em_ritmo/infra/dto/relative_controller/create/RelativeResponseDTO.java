package com.familia_em_ritmo.familia_em_ritmo.infra.dto.relative_controller.create;

public class RelativeResponseDTO {
    private Long id;
    private String name;

    public RelativeResponseDTO(Long id, String name) {
        this.id = id;
        this.name = name;
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
