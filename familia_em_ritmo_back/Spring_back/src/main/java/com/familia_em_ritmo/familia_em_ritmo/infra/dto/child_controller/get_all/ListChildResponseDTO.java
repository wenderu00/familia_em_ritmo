package com.familia_em_ritmo.familia_em_ritmo.infra.dto.child_controller.get_all;

import java.util.List;

public class ListChildResponseDTO {
    private List<ChildItemListResponseDTO> childs;

    public ListChildResponseDTO(List<ChildItemListResponseDTO> childs) {
        this.childs = childs;
    }

    public List<ChildItemListResponseDTO> getChilds() {
        return childs;
    }

    public void setChilds(List<ChildItemListResponseDTO> childs) {
        this.childs = childs;
    }
}
