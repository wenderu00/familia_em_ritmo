package com.familia_em_ritmo.familia_em_ritmo.infra.dto.relative_controller.get_by_id;

import java.util.List;

public class RelativeByIdResponseDTO {
    private Long id;
    private String name;
    private List<ChildListItemDTO> childs;

    public RelativeByIdResponseDTO(Long id, String name, List<ChildListItemDTO> childs) {
        this.id = id;
        this.name = name;
        this.childs = childs;
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

    public List<ChildListItemDTO> getChilds() {
        return childs;
    }

    public void setChilds(List<ChildListItemDTO> childs) {
        this.childs = childs;
    }
}
