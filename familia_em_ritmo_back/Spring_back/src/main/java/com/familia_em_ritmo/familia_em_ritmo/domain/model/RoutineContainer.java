package com.familia_em_ritmo.familia_em_ritmo.domain.model;

import com.familia_em_ritmo.familia_em_ritmo.domain.model.routines.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "routine_container")
public class RoutineContainer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "routineContainer")
    private Child child;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sleep_routine_id", referencedColumnName = "id")
    private SleepRoutine sleepRoutine = new SleepRoutine();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "behavioral_routine_id", referencedColumnName = "id")
    private BehavioralRoutine behavioralRoutine = new BehavioralRoutine();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "exercise_routine_id", referencedColumnName = "id")
    private ExerciseRoutine exerciseRoutine = new ExerciseRoutine();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "family_routine_id", referencedColumnName = "id")
    private FamilyRoutine familyRoutine = new FamilyRoutine();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "feeding_routine_id", referencedColumnName = "id")
    private FeedingRoutine feedingRoutine = new FeedingRoutine();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fun_routine_id", referencedColumnName = "id")
    private FunRoutine funRoutine = new FunRoutine();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hygiene_routine_id", referencedColumnName = "id")
    private HygieneRoutine hygieneRoutine = new HygieneRoutine();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "study_routine_id", referencedColumnName = "id")
    private StudyRoutine studyRoutine = new StudyRoutine();

    @OneToMany(mappedBy = "routineContainer", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<GenericRoutine> genericRoutineList = new LinkedList<GenericRoutine>();

    public RoutineContainer() {
    }

    public RoutineContainer(Long id, Child child) {
        this.id = id;
        this.child = child;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }

    public SleepRoutine getSleepRoutine() {
        return sleepRoutine;
    }

    public void setSleepRoutine(SleepRoutine sleepRoutine) {
        this.sleepRoutine = sleepRoutine;
    }

    public BehavioralRoutine getBehavioralRoutine() {
        return behavioralRoutine;
    }

    public void setBehavioralRoutine(BehavioralRoutine behavioralRoutine) {
        this.behavioralRoutine = behavioralRoutine;
    }

    public ExerciseRoutine getExerciseRoutine() {
        return exerciseRoutine;
    }

    public void setExerciseRoutine(ExerciseRoutine exerciseRoutine) {
        this.exerciseRoutine = exerciseRoutine;
    }

    public FamilyRoutine getFamilyRoutine() {
        return familyRoutine;
    }

    public void setFamilyRoutine(FamilyRoutine familyRoutine) {
        this.familyRoutine = familyRoutine;
    }

    public FeedingRoutine getFeedingRoutine() {
        return feedingRoutine;
    }

    public void setFeedingRoutine(FeedingRoutine feedingRoutine) {
        this.feedingRoutine = feedingRoutine;
    }

    public FunRoutine getFunRoutine() {
        return funRoutine;
    }

    public void setFunRoutine(FunRoutine funRoutine) {
        this.funRoutine = funRoutine;
    }

    public HygieneRoutine getHygieneRoutine() {
        return hygieneRoutine;
    }

    public void setHygieneRoutine(HygieneRoutine hygieneRoutine) {
        this.hygieneRoutine = hygieneRoutine;
    }

    public StudyRoutine getStudyRoutine() {
        return studyRoutine;
    }

    public void setStudyRoutine(StudyRoutine studyRoutine) {
        this.studyRoutine = studyRoutine;
    }

    public List<GenericRoutine> getGenericRoutineList() {
        return genericRoutineList;
    }

    public void setGenericRoutineList(List<GenericRoutine> genericRoutineList) {
        this.genericRoutineList = genericRoutineList;
    }

    public void addGenericRoutine(GenericRoutine genericRoutine){
        this.genericRoutineList.add(genericRoutine);
    }

    public void removeGenericRoutine(GenericRoutine genericRoutine){
        this.genericRoutineList.remove(genericRoutine);
    }
}
