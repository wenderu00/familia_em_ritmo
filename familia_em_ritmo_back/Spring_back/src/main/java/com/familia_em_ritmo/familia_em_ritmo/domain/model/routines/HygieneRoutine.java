package com.familia_em_ritmo.familia_em_ritmo.domain.model.routines;

import com.familia_em_ritmo.familia_em_ritmo.domain.model.RoutineContainer;
import com.familia_em_ritmo.familia_em_ritmo.domain.model.missions.HygieneMission;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "hygiene_routine")
public class HygieneRoutine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "hygieneRoutine")
    private RoutineContainer routineContainer;

    @OneToMany( mappedBy = "hygieneRoutine", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<HygieneMission> hygieneMissionList = new LinkedList<HygieneMission>();

    public HygieneRoutine() {
    }

    public HygieneRoutine(Long id, RoutineContainer routineContainer) {
        this.id = id;
        this.routineContainer = routineContainer;
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

    public List<HygieneMission> getHygieneMissionList() {
        return hygieneMissionList;
    }

    public void setHygieneMissionList(List<HygieneMission> hygieneMissionList) {
        this.hygieneMissionList = hygieneMissionList;
    }

    public void addHygieneMission(HygieneMission mission){
        this.hygieneMissionList.add(mission);
    }

    public void removeHygieneMission(HygieneMission mission){
        this.hygieneMissionList.remove(mission);
    }
}
