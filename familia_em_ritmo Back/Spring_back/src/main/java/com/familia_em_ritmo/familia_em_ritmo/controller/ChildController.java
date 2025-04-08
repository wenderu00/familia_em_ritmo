package com.familia_em_ritmo.familia_em_ritmo.controller;

import com.familia_em_ritmo.familia_em_ritmo.model.Child;
import com.familia_em_ritmo.familia_em_ritmo.service.ChildService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/child")
public class ChildController {
    private ChildService childService;

    public ChildController(ChildService childService) {
        this.childService = childService;
    }

    @GetMapping
    public List<Child> getAll(){
        return childService.getAll();
    }

    @PostMapping
    public Child create(@RequestBody Child child){
        return childService.save(child);
    }
}
