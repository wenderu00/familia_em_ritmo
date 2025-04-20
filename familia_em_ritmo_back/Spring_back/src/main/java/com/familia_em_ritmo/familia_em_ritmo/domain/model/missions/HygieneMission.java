package com.familia_em_ritmo.familia_em_ritmo.domain.model.missions;

import com.familia_em_ritmo.familia_em_ritmo.domain.model.routines.HygieneRoutine;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "hygiene_mission")
public class HygieneMission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "hygiene_routine_id")
    @JsonBackReference
    private HygieneRoutine hygieneRoutine;

    private boolean complete = false;

    public HygieneMission() {
    }

    public HygieneMission(Long id, HygieneRoutine hygieneRoutine) {
        this.id = id;
        this.hygieneRoutine = hygieneRoutine;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public HygieneRoutine getHygieneRoutine() {
        return hygieneRoutine;
    }

    public void setHygieneRoutine(HygieneRoutine hygieneRoutine) {
        this.hygieneRoutine = hygieneRoutine;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }
}
