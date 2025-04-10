package com.familia_em_ritmo.familia_em_ritmo.application.controller;

import com.familia_em_ritmo.familia_em_ritmo.infra.dto.ChildDTO;
import com.familia_em_ritmo.familia_em_ritmo.domain.model.Child;
import com.familia_em_ritmo.familia_em_ritmo.domain.model.Relative;
import com.familia_em_ritmo.familia_em_ritmo.domain.service.ChildService;
import com.familia_em_ritmo.familia_em_ritmo.domain.service.RelativeService;
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
    public List<Child> getAll(){
        return this.childService.getAll();
    }
    @PostMapping
    public Child create(@RequestBody ChildDTO childDTO){
        Optional<Relative> relative = relativeService.getById(childDTO.getRelativeId());
        if(relative.isPresent()){
            Child child = new Child(childDTO.getName(),childDTO.getAge(), relative.get());
            return this.childService.create(child);
        }
        return new Child();
    }
}
