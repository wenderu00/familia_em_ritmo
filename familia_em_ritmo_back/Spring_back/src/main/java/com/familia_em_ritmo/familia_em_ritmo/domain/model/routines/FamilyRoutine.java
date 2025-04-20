package com.familia_em_ritmo.familia_em_ritmo.domain.model.routines;

import com.familia_em_ritmo.familia_em_ritmo.domain.model.RoutineContainer;
import com.familia_em_ritmo.familia_em_ritmo.domain.model.missions.FamilyMission;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "family_routine")
public class FamilyRoutine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "familyRoutine")
    private RoutineContainer routineContainer;

    @OneToMany(mappedBy = "familyRoutine", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<FamilyMission> familyMissionList = new LinkedList<FamilyMission>();

    public FamilyRoutine() {
    }

    public FamilyRoutine(Long id, RoutineContainer routineContainer) {
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

    public List<FamilyMission> getFamilyMissionList() {
        return familyMissionList;
    }

    public void setFamilyMissionList(List<FamilyMission> familyMissionList) {
        this.familyMissionList = familyMissionList;
    }

    public void addFamilyMission(FamilyMission mission){
        this.familyMissionList.add(mission);
    }

    public void removeFamilyMission(FamilyMission mission){
        this.familyMissionList.remove(mission);
    }
}
