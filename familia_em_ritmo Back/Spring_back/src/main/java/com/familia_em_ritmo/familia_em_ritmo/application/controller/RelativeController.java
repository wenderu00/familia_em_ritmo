package com.familia_em_ritmo.familia_em_ritmo.application.controller;

import com.familia_em_ritmo.familia_em_ritmo.domain.model.Relative;
import com.familia_em_ritmo.familia_em_ritmo.domain.service.RelativeService;
import com.familia_em_ritmo.familia_em_ritmo.infra.dto.relative_controller.create.RelativeRequestDTO;
import com.familia_em_ritmo.familia_em_ritmo.infra.dto.relative_controller.create.RelativeResponseDTO;
import com.familia_em_ritmo.familia_em_ritmo.infra.dto.relative_controller.get_all.ListRelativeResponseDTO;
import com.familia_em_ritmo.familia_em_ritmo.infra.dto.relative_controller.get_all.RelativeItemListResponseDTO;
import com.familia_em_ritmo.familia_em_ritmo.infra.dto.relative_controller.get_by_id.ChildListItemDTO;
import com.familia_em_ritmo.familia_em_ritmo.infra.dto.relative_controller.get_by_id.RelativeByIdResponseDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/relative")
public class RelativeController {
    private final RelativeService relativeService;

    public RelativeController(RelativeService relativeService) {
        this.relativeService = relativeService;
    }

    @PostMapping
    public RelativeResponseDTO create(@RequestBody RelativeRequestDTO relative){
        Relative newRelative = new Relative(relative.getName());
        Relative createdRelative = relativeService.create(newRelative);
        return new RelativeResponseDTO(createdRelative.getId(), createdRelative.getName());
    }

    @GetMapping
    public ListRelativeResponseDTO getAll(){
        List<RelativeItemListResponseDTO> relatives = relativeService.getAll()
                .stream()
                .map(relative -> new RelativeItemListResponseDTO(relative.getId(), relative.getName()))
                .toList();
        ListRelativeResponseDTO responseList = new ListRelativeResponseDTO(relatives);
        return responseList;
    }

    @GetMapping("/by_id")
    public RelativeByIdResponseDTO getById(@RequestParam(value = "id", required = true) Long id){
        Relative relativeById = relativeService.getById(id).get();
        RelativeByIdResponseDTO responseRelative = new RelativeByIdResponseDTO(
                relativeById.getId(),
                relativeById.getName(),
                relativeById.getManagedChildren()
                        .stream()
                        .map(child -> new ChildListItemDTO(child.getId(), child.getName(), child.getAge()))
                        .toList()
        );
        return responseRelative;
    }

}
