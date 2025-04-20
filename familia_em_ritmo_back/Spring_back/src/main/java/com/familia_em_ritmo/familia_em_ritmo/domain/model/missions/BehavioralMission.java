package com.familia_em_ritmo.familia_em_ritmo.domain.model.missions;

import com.familia_em_ritmo.familia_em_ritmo.domain.model.routines.BehavioralRoutine;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name="behavioral_mission")
public class BehavioralMission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "behavioral_routine_id")
    @JsonBackReference
    private BehavioralRoutine behavioralRoutine;

    private boolean complete = false;

    public BehavioralMission() {
    }

    public BehavioralMission(Long id, BehavioralRoutine behavioralRoutine) {
        this.id = id;
        this.behavioralRoutine = behavioralRoutine;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BehavioralRoutine getBehavioralRoutine() {
        return behavioralRoutine;
    }

    public void setBehavioralRoutine(BehavioralRoutine behavioralRoutine) {
        this.behavioralRoutine = behavioralRoutine;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }
}
