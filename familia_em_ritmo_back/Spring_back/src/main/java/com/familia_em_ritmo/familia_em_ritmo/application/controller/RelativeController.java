package com.familia_em_ritmo.familia_em_ritmo.application.controller;

import com.familia_em_ritmo.familia_em_ritmo.domain.model.Child;
import com.familia_em_ritmo.familia_em_ritmo.domain.model.Relative;
import com.familia_em_ritmo.familia_em_ritmo.domain.service.ChildService;
import com.familia_em_ritmo.familia_em_ritmo.domain.service.RelativeService;
import com.familia_em_ritmo.familia_em_ritmo.infra.dto.relative_controller.add_observer.IdsObserverToChildDTO;
import com.familia_em_ritmo.familia_em_ritmo.infra.dto.relative_controller.add_observer.ObserverSucessMessageDTO;
import com.familia_em_ritmo.familia_em_ritmo.infra.dto.relative_controller.create.RelativeRequestDTO;
import com.familia_em_ritmo.familia_em_ritmo.infra.dto.relative_controller.create.RelativeResponseDTO;
import com.familia_em_ritmo.familia_em_ritmo.infra.dto.relative_controller.get_all.ListRelativeResponseDTO;
import com.familia_em_ritmo.familia_em_ritmo.infra.dto.relative_controller.get_all.RelativeItemListResponseDTO;
import com.familia_em_ritmo.familia_em_ritmo.infra.dto.relative_controller.get_by_id.ChildListItemDTO;
import com.familia_em_ritmo.familia_em_ritmo.infra.dto.relative_controller.get_by_id.RelativeByIdResponseDTO;
import com.familia_em_ritmo.familia_em_ritmo.infra.dto.relative_controller.put_relative_name.RelativeNewNameDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/relative")
public class RelativeController {
    private final RelativeService relativeService;
    private final ChildService childService;

    public RelativeController(RelativeService relativeService, ChildService childService) {
        this.relativeService = relativeService;
        this.childService = childService;
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
                        .toList(),
                relativeById.getObservedChildren()
                        .stream()
                        .map(child -> new ChildListItemDTO(child.getId(), child.getName(), child.getAge()))
                        .toList()
        );
        return responseRelative;
    }

    @PutMapping("/name")
    public ResponseEntity<Void> PutRelativeName(@RequestParam(value = "id", required = true) Long id, @RequestBody RelativeNewNameDTO name){
        Relative relative = this.relativeService.getById(id).get();
        relative.setName(name.getName());
        this.relativeService.create(relative);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> DeleteRelative(@RequestParam(value= "id", required = true) Long id){
        this.relativeService.remove(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/add_observer")
    public ObserverSucessMessageDTO addObserverToChild(@RequestBody IdsObserverToChildDTO request_ids){
        Relative relativeManager = this.relativeService.getById(request_ids.getRelative_id()).get();
        Relative relativeObserver = this.relativeService.getById(request_ids.getObserver_id()).get();
        Child child = this.childService.getById(request_ids.getChild_id());
        if(relativeManager.getId().equals(child.getRelativeManager().getId())){
            child.addObserver(relativeObserver);
            this.relativeService.create(relativeObserver);
            this.childService.create(child);
            return new ObserverSucessMessageDTO("Success");
        }
        return new ObserverSucessMessageDTO("Fail");
    }
}
