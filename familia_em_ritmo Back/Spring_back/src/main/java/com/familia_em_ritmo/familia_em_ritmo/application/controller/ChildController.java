package com.familia_em_ritmo.familia_em_ritmo.application.controller;

import com.familia_em_ritmo.familia_em_ritmo.infra.dto.child_controller.create.ChildRequestDTO;
import com.familia_em_ritmo.familia_em_ritmo.domain.model.Child;
import com.familia_em_ritmo.familia_em_ritmo.domain.model.Relative;
import com.familia_em_ritmo.familia_em_ritmo.domain.service.ChildService;
import com.familia_em_ritmo.familia_em_ritmo.domain.service.RelativeService;
import com.familia_em_ritmo.familia_em_ritmo.infra.dto.child_controller.create.ChildResponseDTO;
import com.familia_em_ritmo.familia_em_ritmo.infra.dto.child_controller.get_all.ChildItemListResponseDTO;
import com.familia_em_ritmo.familia_em_ritmo.infra.dto.child_controller.get_all.ListChildResponseDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/child")
public class ChildController {
    private ChildService childService;
    private RelativeService relativeService;
    public ChildController(ChildService childService, RelativeService relativeService) {
        this.childService = childService;
        this.relativeService = relativeService;
    }
    @GetMapping
    public ListChildResponseDTO getAll(){
        List<Child> childs = this.childService.getAll();
        List<ChildItemListResponseDTO> responseDTOList = childs.stream()
                .map(child -> new ChildItemListResponseDTO(
                        child.getId(),
                        child.getName(),
                        child.getAge(),
                        child.getRelativeManager().getId(),
                        child.getRelativeManager().getName()
                ))
                .toList();
        return new ListChildResponseDTO(responseDTOList);
    }
    @PostMapping
    public ChildResponseDTO create(@RequestBody ChildRequestDTO childRequestDTO){
        Optional<Relative> relative = relativeService.getById(childRequestDTO.getRelativeId());
        Child child;
        ChildResponseDTO response;
        if(relative.isPresent()){
            child = new Child(childRequestDTO.getName(), childRequestDTO.getAge(), relative.get());
            Child savedChild = childService.create(child);
            response = new ChildResponseDTO(savedChild.getId(), savedChild.getName(),savedChild.getAge(), savedChild.getRelativeManager().getId(), savedChild.getRelativeManager().getName());
        } else{
            child = new Child(childRequestDTO.getName(), childRequestDTO.getAge(), null);
            response = new ChildResponseDTO(child.getId(), child.getName(),child.getAge(), 0L,"");
        }
        return response;
    }
}
