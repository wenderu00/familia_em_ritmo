package com.familia_em_ritmo.familia_em_ritmo.infra.dto.child_controller.get_by_id;

public class ObserverListItemResponseDTO {
    private Long id;
    private String name;

    public ObserverListItemResponseDTO(Long id, String name) {
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
