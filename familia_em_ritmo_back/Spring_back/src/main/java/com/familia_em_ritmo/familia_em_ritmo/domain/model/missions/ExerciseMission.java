package com.familia_em_ritmo.familia_em_ritmo.domain.model.missions;

import com.familia_em_ritmo.familia_em_ritmo.domain.model.routines.ExerciseRoutine;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "exercise_mission")
public class ExerciseMission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "exercise_routine_id")
    @JsonBackReference
    private ExerciseRoutine exerciseRoutine;

    private boolean complete = false;

    public ExerciseMission() {
    }

    public ExerciseMission(Long id, ExerciseRoutine exerciseRoutine, boolean complete) {
        this.id = id;
        this.exerciseRoutine = exerciseRoutine;
        this.complete = complete;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ExerciseRoutine getExerciseRoutine() {
        return exerciseRoutine;
    }

    public void setExerciseRoutine(ExerciseRoutine exerciseRoutine) {
        this.exerciseRoutine = exerciseRoutine;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }
}
