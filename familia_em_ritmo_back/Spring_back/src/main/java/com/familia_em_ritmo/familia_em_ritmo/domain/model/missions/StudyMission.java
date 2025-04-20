package com.familia_em_ritmo.familia_em_ritmo.domain.model.missions;

import com.familia_em_ritmo.familia_em_ritmo.domain.model.routines.StudyRoutine;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "study_mission")
public class StudyMission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "study_routine_id")
    @JsonBackReference
    private StudyRoutine studyRoutine;

    private boolean complete = false;

    public StudyMission() {
    }

    public StudyMission(Long id, StudyRoutine studyRoutine) {
        this.id = id;
        this.studyRoutine = studyRoutine;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StudyRoutine getStudyRoutine() {
        return studyRoutine;
    }

    public void setStudyRoutine(StudyRoutine studyRoutine) {
        this.studyRoutine = studyRoutine;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }
}
