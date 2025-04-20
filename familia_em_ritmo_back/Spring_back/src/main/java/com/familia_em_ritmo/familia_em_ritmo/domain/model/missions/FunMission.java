package com.familia_em_ritmo.familia_em_ritmo.domain.model.missions;

import com.familia_em_ritmo.familia_em_ritmo.domain.model.routines.FunRoutine;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "fun_mission")
public class FunMission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fun_routine_id")
    @JsonBackReference
    private FunRoutine funRoutine;

    private boolean complete = false;

    public FunMission() {
    }

    public FunMission(FunRoutine funRoutine, Long id) {
        this.funRoutine = funRoutine;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FunRoutine getFunRoutine() {
        return funRoutine;
    }

    public void setFunRoutine(FunRoutine funRoutine) {
        this.funRoutine = funRoutine;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }
}
