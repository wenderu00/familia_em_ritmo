package com.familia_em_ritmo.familia_em_ritmo.domain.model.missions;

import com.familia_em_ritmo.familia_em_ritmo.domain.model.routines.GenericRoutine;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "generic_mission")
public class GenericMission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "generic_routine_id")
    @JsonBackReference
    private GenericRoutine genericRoutine;

    private boolean complete = false;

    public GenericMission() {
    }

    public GenericMission(Long id, GenericRoutine genericRoutine) {
        this.id = id;
        this.genericRoutine = genericRoutine;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GenericRoutine getGenericRoutine() {
        return genericRoutine;
    }

    public void setGenericRoutine(GenericRoutine genericRoutine) {
        this.genericRoutine = genericRoutine;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }
}
