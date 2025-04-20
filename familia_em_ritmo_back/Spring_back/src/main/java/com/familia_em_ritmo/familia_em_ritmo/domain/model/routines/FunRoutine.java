package com.familia_em_ritmo.familia_em_ritmo.domain.model.routines;

import com.familia_em_ritmo.familia_em_ritmo.domain.model.RoutineContainer;
import com.familia_em_ritmo.familia_em_ritmo.domain.model.missions.FunMission;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "fun_routine")
public class FunRoutine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "funRoutine")
    private RoutineContainer routineContainer;

    @OneToMany(mappedBy = "funRoutine", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<FunMission> funMissionList = new LinkedList<FunMission>();

    public FunRoutine() {
    }

    public FunRoutine(Long id, RoutineContainer routineContainer) {
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

    public List<FunMission> getFunMissionList() {
        return funMissionList;
    }

    public void setFunMissionList(List<FunMission> funMissionList) {
        this.funMissionList = funMissionList;
    }

    public void addFunMission(FunMission mission){
        this.funMissionList.add(mission);
    }

    public void removeFunMission(FunMission mission){
        this.funMissionList.remove(mission);
    }
}
