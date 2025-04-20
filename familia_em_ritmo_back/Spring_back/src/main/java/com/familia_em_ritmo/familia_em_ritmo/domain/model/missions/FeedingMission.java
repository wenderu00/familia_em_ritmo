package com.familia_em_ritmo.familia_em_ritmo.domain.model.missions;

import com.familia_em_ritmo.familia_em_ritmo.domain.model.routines.FeedingRoutine;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "feeding_mission")
public class FeedingMission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "feeding_routine_id")
    @JsonBackReference
    private FeedingRoutine feedingRoutine;

    private boolean complete = false;

    public FeedingMission() {
    }

    public FeedingMission(Long id, FeedingRoutine feedingRoutine) {
        this.id = id;
        this.feedingRoutine = feedingRoutine;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FeedingRoutine getFeedingRoutine() {
        return feedingRoutine;
    }

    public void setFeedingRoutine(FeedingRoutine feedingRoutine) {
        this.feedingRoutine = feedingRoutine;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }
}
