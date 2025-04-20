package com.familia_em_ritmo.familia_em_ritmo.domain.model.routines;

import com.familia_em_ritmo.familia_em_ritmo.domain.model.RoutineContainer;
import com.familia_em_ritmo.familia_em_ritmo.domain.model.missions.FeedingMission;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "feeding_routine")
public class FeedingRoutine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "feedingRoutine")
    private RoutineContainer routineContainer;

    @OneToMany(mappedBy = "feedingRoutine", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<FeedingMission> feedingMissionList = new LinkedList<FeedingMission>();

    public FeedingRoutine() {
    }

    public FeedingRoutine(Long id, RoutineContainer routineContainer) {
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

    public List<FeedingMission> getFeedingMissionList() {
        return feedingMissionList;
    }

    public void setFeedingMissionList(List<FeedingMission> feedingMissionList) {
        this.feedingMissionList = feedingMissionList;
    }

    public void addFeedingMission(FeedingMission mission){
        this.feedingMissionList.add(mission);
    }

    public void removeFeedingMission(FeedingMission mission){
        this.feedingMissionList.remove(mission);
    }
}
