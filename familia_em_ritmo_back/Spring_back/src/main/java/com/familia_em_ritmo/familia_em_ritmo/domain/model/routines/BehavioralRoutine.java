package com.familia_em_ritmo.familia_em_ritmo.domain.model.routines;

import com.familia_em_ritmo.familia_em_ritmo.domain.model.RoutineContainer;
import com.familia_em_ritmo.familia_em_ritmo.domain.model.missions.BehavioralMission;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "behavioral_routine")
public class BehavioralRoutine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "behavioralRoutine")
    private RoutineContainer routineContainer;

    @OneToMany(mappedBy = "behavioralRoutine", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<BehavioralMission> behavioralMissionList = new LinkedList<BehavioralMission>();

    public BehavioralRoutine() {
    }

    public BehavioralRoutine(Long id, RoutineContainer routineContainer) {
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

    public List<BehavioralMission> getBehavioralMissionList() {
        return behavioralMissionList;
    }

    public void setBehavioralMissionList(List<BehavioralMission> behavioralMissionList) {
        this.behavioralMissionList = behavioralMissionList;
    }

    public void addBehavioralMission(BehavioralMission mission){
        this.behavioralMissionList.add(mission);
    }

    public void removeBehavioralMission(BehavioralMission mission){
        this.behavioralMissionList.remove(mission);
    }
}
