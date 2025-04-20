package com.familia_em_ritmo.familia_em_ritmo.domain.model.routines;

import com.familia_em_ritmo.familia_em_ritmo.domain.model.RoutineContainer;
import com.familia_em_ritmo.familia_em_ritmo.domain.model.missions.SleepMission;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "sleep_routine")
public class SleepRoutine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "sleepRoutine")
    private RoutineContainer routineContainer;

    @OneToMany(mappedBy = "sleepRoutine", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<SleepMission> sleepMissionList = new LinkedList<SleepMission>();

    public SleepRoutine() {
    }

    public SleepRoutine(Long id, RoutineContainer routineContainer) {
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

    public List<SleepMission> getSleepMissionList() {
        return sleepMissionList;
    }

    public void setSleepMissionList(List<SleepMission> sleepMissionList) {
        this.sleepMissionList = sleepMissionList;
    }

    public void addSleepMission(SleepMission mission){
        this.sleepMissionList.add(mission);
    }

    public void removeSleepMission(SleepMission mission){
        this.sleepMissionList.remove(mission);
    }
}
