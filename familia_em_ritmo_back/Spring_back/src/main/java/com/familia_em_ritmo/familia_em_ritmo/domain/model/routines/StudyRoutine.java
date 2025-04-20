package com.familia_em_ritmo.familia_em_ritmo.domain.model.routines;

import com.familia_em_ritmo.familia_em_ritmo.domain.model.RoutineContainer;
import com.familia_em_ritmo.familia_em_ritmo.domain.model.missions.StudyMission;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "study_routine")
public class StudyRoutine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "studyRoutine")
    private RoutineContainer routineContainer;

    @OneToMany(mappedBy = "studyRoutine")
    @JsonManagedReference
    private List<StudyMission> studyMissionList = new LinkedList<StudyMission>();

    public StudyRoutine() {
    }

    public StudyRoutine(Long id, RoutineContainer routineContainer) {
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

    public List<StudyMission> getStudyMissionList() {
        return studyMissionList;
    }

    public void setStudyMissionList(List<StudyMission> studyMissionList) {
        this.studyMissionList = studyMissionList;
    }

    public void addStudyMission(StudyMission mission){
        this.studyMissionList.add(mission);
    }

    public void removeStudyMission(StudyMission mission){
        this.studyMissionList.remove(mission);
    }
}
