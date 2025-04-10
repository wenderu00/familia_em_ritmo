package com.familia_em_ritmo.familia_em_ritmo.infra.dto.relative_controller.get_all;

import com.familia_em_ritmo.familia_em_ritmo.domain.model.Relative;

import java.util.List;

public class ListRelativeResponseDTO {
    private List<RelativeItemListResponseDTO> relatives;

    public ListRelativeResponseDTO(List<RelativeItemListResponseDTO> relatives) {
        this.relatives = relatives;
    }

    public List<RelativeItemListResponseDTO> getRelatives() {
        return relatives;
    }

    public void setRelatives(List<RelativeItemListResponseDTO> relatives) {
        this.relatives = relatives;
    }
}
