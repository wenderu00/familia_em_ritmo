package com.familia_em_ritmo.familia_em_ritmo.domain.model.missions;

import com.familia_em_ritmo.familia_em_ritmo.domain.model.routines.FamilyRoutine;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "family_mission")
public class FamilyMission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "family_routine_id")
    @JsonBackReference
    private FamilyRoutine familyRoutine;

    private boolean complete = false;

    public FamilyMission() {
    }

    public FamilyMission(Long id, FamilyRoutine familyRoutine) {
        this.id = id;
        this.familyRoutine = familyRoutine;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FamilyRoutine getFamilyRoutine() {
        return familyRoutine;
    }

    public void setFamilyRoutine(FamilyRoutine familyRoutine) {
        this.familyRoutine = familyRoutine;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }
}
