package com.familia_em_ritmo.familia_em_ritmo.application.controller;

import com.familia_em_ritmo.familia_em_ritmo.domain.model.routines.GenericRoutine;
import com.familia_em_ritmo.familia_em_ritmo.domain.repository.routines.GenericRoutineRepository;
import com.familia_em_ritmo.familia_em_ritmo.domain.service.routines.GenericRoutineService;
import com.familia_em_ritmo.familia_em_ritmo.infra.dto.child_controller.create.ChildRequestDTO;
import com.familia_em_ritmo.familia_em_ritmo.domain.model.Child;
import com.familia_em_ritmo.familia_em_ritmo.domain.model.Relative;
import com.familia_em_ritmo.familia_em_ritmo.domain.service.ChildService;
import com.familia_em_ritmo.familia_em_ritmo.domain.service.RelativeService;
import com.familia_em_ritmo.familia_em_ritmo.infra.dto.child_controller.create.ChildResponseDTO;
import com.familia_em_ritmo.familia_em_ritmo.infra.dto.child_controller.get_all.ChildItemListResponseDTO;
import com.familia_em_ritmo.familia_em_ritmo.infra.dto.child_controller.get_all.ListChildResponseDTO;
import com.familia_em_ritmo.familia_em_ritmo.infra.dto.child_controller.get_by_id.ChildGetByIdResponseDTO;
import com.familia_em_ritmo.familia_em_ritmo.infra.dto.child_controller.get_by_id.ObserverListItemResponseDTO;
import com.familia_em_ritmo.familia_em_ritmo.infra.dto.child_controller.get_by_id.RoutineContainerGetByIdResponseDTO;
import com.familia_em_ritmo.familia_em_ritmo.infra.dto.child_controller.put_age.ChildNewAgeDTO;
import com.familia_em_ritmo.familia_em_ritmo.infra.dto.child_controller.put_name.ChildNewNameDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/child")
public class ChildController {
    private ChildService childService;
    private RelativeService relativeService;
    private GenericRoutineService genericRoutineService;
    public ChildController(ChildService childService, RelativeService relativeService, GenericRoutineService genericRoutineService) {
        this.childService = childService;
        this.relativeService = relativeService;
        this.genericRoutineService = genericRoutineService;
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

    @GetMapping("/by_id")
    public ChildGetByIdResponseDTO getById(@RequestParam(value = "child_id") Long childId){
        Child searchedChild = this.childService.getById(childId);
        ChildGetByIdResponseDTO response = new ChildGetByIdResponseDTO(
                searchedChild.getId(),
                searchedChild.getName(),
                searchedChild.getAge(),
                new ObserverListItemResponseDTO(
                        searchedChild.getRelativeManager().getId(),
                        searchedChild.getRelativeManager().getName()
                ),
                searchedChild.getObservers()
                        .stream()
                        .map(relative -> new ObserverListItemResponseDTO(relative.getId(), relative.getName()))
                        .toList(),
                new RoutineContainerGetByIdResponseDTO(
                        searchedChild.getRoutineContainer().getId(),
                        searchedChild.getRoutineContainer().getSleepRoutine().getId(),
                        searchedChild.getRoutineContainer().getBehavioralRoutine().getId(),
                        searchedChild.getRoutineContainer().getExerciseRoutine().getId(),
                        searchedChild.getRoutineContainer().getFamilyRoutine().getId(),
                        searchedChild.getRoutineContainer().getFeedingRoutine().getId(),
                        searchedChild.getRoutineContainer().getFunRoutine().getId(),
                        searchedChild.getRoutineContainer().getHygieneRoutine().getId(),
                        searchedChild.getRoutineContainer().getStudyRoutine().getId(),
                        searchedChild.getRoutineContainer().getGenericRoutineList()
                                .stream()
                                .map(GenericRoutine::getId)
                                .toList()
                )
        );
        return response;
    }

    @PutMapping("/name")
    public ResponseEntity<Void> putChildName(@RequestParam(value = "id", required = true) Long id, @RequestBody ChildNewNameDTO name){
        Child child = this.childService.getById(id);
        child.setName(name.getName());
        this.childService.create(child);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/age")
    public ResponseEntity<Void> putChildAge(@RequestParam(value = "id", required = true) Long id, @RequestBody ChildNewAgeDTO age){
        Child child = this.childService.getById(id);
        child.setAge(age.getAge());
        this.childService.create(child);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteChild(@RequestParam(value = "id", required = true) Long id){
        this.childService.remove(id);
        return ResponseEntity.noContent().build();
    }
}
