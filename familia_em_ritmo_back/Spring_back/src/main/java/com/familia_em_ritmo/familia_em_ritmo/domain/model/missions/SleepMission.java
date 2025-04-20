package com.familia_em_ritmo.familia_em_ritmo.domain.model.missions;

import com.familia_em_ritmo.familia_em_ritmo.domain.model.routines.SleepRoutine;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "sleep_mission")
public class SleepMission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sleep_routine_id")
    @JsonBackReference
    private SleepRoutine sleepRoutine;

    private boolean complete = false;

    public SleepMission() {
    }

    public SleepMission(Long id, SleepRoutine sleepRoutine) {
        this.id = id;
        this.sleepRoutine = sleepRoutine;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SleepRoutine getSleepRoutine() {
        return sleepRoutine;
    }

    public void setSleepRoutine(SleepRoutine sleepRoutine) {
        this.sleepRoutine = sleepRoutine;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }
}
