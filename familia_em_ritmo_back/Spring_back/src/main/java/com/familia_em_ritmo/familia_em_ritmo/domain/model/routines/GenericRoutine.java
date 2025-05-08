package com.familia_em_ritmo.familia_em_ritmo.domain.model.routines;

import com.familia_em_ritmo.familia_em_ritmo.domain.model.RoutineContainer;
import com.familia_em_ritmo.familia_em_ritmo.domain.model.missions.GenericMission;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "generic_routine")
public class GenericRoutine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "routine_container_id")
    @JsonBackReference
    private RoutineContainer routineContainer;

    @OneToMany(mappedBy = "genericRoutine", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<GenericMission> genericMissionList = new LinkedList<GenericMission>();

    public GenericRoutine() {
    }

    public GenericRoutine(Long id, RoutineContainer routineContainer, String name) {
        this.id = id;
        this.routineContainer = routineContainer;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoutineContainer getRoutineContainer() {
        return routineContainer;
    }

    public void setRoutineContainer(RoutineContainer routineContainer) {
        this.routineContainer = routineContainer;
    }

    public List<GenericMission> getGenericMissionList() {
        return genericMissionList;
    }

    public void setGenericMissionList(List<GenericMission> genericMissionList) {
        this.genericMissionList = genericMissionList;
    }
    public void addGenericMission(GenericMission mission){
        this.genericMissionList.add(mission);
    }

    public void removeGenericMission(GenericMission mission){
        this.genericMissionList.remove(mission);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
