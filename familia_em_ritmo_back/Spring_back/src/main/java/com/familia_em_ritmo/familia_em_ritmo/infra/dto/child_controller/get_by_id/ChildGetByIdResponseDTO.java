package com.familia_em_ritmo.familia_em_ritmo.infra.dto.child_controller.get_by_id;

import com.familia_em_ritmo.familia_em_ritmo.domain.model.Relative;
import com.familia_em_ritmo.familia_em_ritmo.domain.model.RoutineContainer;

import java.util.List;

public class ChildGetByIdResponseDTO {
    private Long id;
    private String name;
    private int age;
    private ObserverListItemResponseDTO relative;
    private List<ObserverListItemResponseDTO> observers;
    private RoutineContainerGetByIdResponseDTO routineContainer;

    public ChildGetByIdResponseDTO(Long id, String name, int age, ObserverListItemResponseDTO relative, List<ObserverListItemResponseDTO> observers, RoutineContainerGetByIdResponseDTO routineContainer) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.relative = relative;
        this.observers = observers;
        this.routineContainer = routineContainer;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ObserverListItemResponseDTO getRelative() {
        return relative;
    }

    public void setRelative(ObserverListItemResponseDTO relative) {
        this.relative = relative;
    }

    public List<ObserverListItemResponseDTO> getObservers() {
        return observers;
    }

    public void setObservers(List<ObserverListItemResponseDTO> observers) {
        this.observers = observers;
    }

    public RoutineContainerGetByIdResponseDTO getRoutineContainer() {
        return routineContainer;
    }

    public void setRoutineContainer(RoutineContainerGetByIdResponseDTO routineContainer) {
        this.routineContainer = routineContainer;
    }
}
