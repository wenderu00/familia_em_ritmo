package com.familia_em_ritmo.familia_em_ritmo.domain.model.routines;

import com.familia_em_ritmo.familia_em_ritmo.domain.model.RoutineContainer;
import com.familia_em_ritmo.familia_em_ritmo.domain.model.missions.ExerciseMission;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "exercise_routine")
public class ExerciseRoutine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "exerciseRoutine")
    private RoutineContainer routineContainer;

    @OneToMany(mappedBy = "exerciseRoutine", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<ExerciseMission> exerciseMissionList = new LinkedList<ExerciseMission>();

    public ExerciseRoutine() {
    }

    public ExerciseRoutine(Long id, RoutineContainer routineContainer) {
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

    public List<ExerciseMission> getExerciseMissionList() {
        return exerciseMissionList;
    }

    public void setExerciseMissionList(List<ExerciseMission> exerciseMissionList) {
        this.exerciseMissionList = exerciseMissionList;
    }

    public void addExerciseMission(ExerciseMission mission){
        this.exerciseMissionList.add(mission);
    }

    public void removeExerciseMission(ExerciseMission mission){
        this.exerciseMissionList.remove(mission);
    }
}
