package com.familia_em_ritmo.familia_em_ritmo.controller;

import com.familia_em_ritmo.familia_em_ritmo.model.Relative;
import com.familia_em_ritmo.familia_em_ritmo.service.RelativeService;
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
    public Relative create(@RequestBody Relative relative){
        return relativeService.create(relative);
    }

    @GetMapping
    public List<Relative> getAll(){
        return relativeService.getAll();
    }

    @GetMapping("/by_id")
    public Optional<Relative> getById(@RequestParam(value = "id", required = true) Long id){
        return relativeService.getById(id);
    }

}
