package com.familia_em_ritmo.familia_em_ritmo.infra.dto.child_controller.get_by_id;

public class RoutineContainerGetByIdResponseDTO {
    private Long routineContainerId;
    private Long sleepRoutineId;
    private Long behavioralRoutineId;
    private Long exerciseRoutineId;
    private Long familyRoutineId;
    private Long feedingRoutineId;
    private Long funRoutineId;
    private Long hygieneRoutineId;
    private Long studyRoutineId;

    public RoutineContainerGetByIdResponseDTO() {
    }

    public RoutineContainerGetByIdResponseDTO(
            Long routineContainerId,
            Long sleepRoutineId,
            Long behavioralRoutineId,
            Long exerciseRoutineId,
            Long familyRoutineId,
            Long feedingRoutineId,
            Long funRoutineId,
            Long hygieneRoutineId,
            Long studyRoutineId
    ) {
        this.routineContainerId = routineContainerId;
        this.sleepRoutineId = sleepRoutineId;
        this.behavioralRoutineId = behavioralRoutineId;
        this.exerciseRoutineId = exerciseRoutineId;
        this.familyRoutineId = familyRoutineId;
        this.feedingRoutineId = feedingRoutineId;
        this.funRoutineId = funRoutineId;
        this.hygieneRoutineId = hygieneRoutineId;
        this.studyRoutineId = studyRoutineId;
    }

    public Long getRoutineContainerId() {
        return routineContainerId;
    }

    public void setRoutineContainerId(Long id) {
        this.routineContainerId = id;
    }

    public Long getSleepRoutineId() {
        return sleepRoutineId;
    }

    public void setSleepRoutineId(Long sleepRoutineId) {
        this.sleepRoutineId = sleepRoutineId;
    }

    public Long getBehavioralRoutineId() {
        return behavioralRoutineId;
    }

    public void setBehavioralRoutineId(Long behavioralRoutineId) {
        this.behavioralRoutineId = behavioralRoutineId;
    }

    public Long getExerciseRoutineId() {
        return exerciseRoutineId;
    }

    public void setExerciseRoutineId(Long exerciseRoutineId) {
        this.exerciseRoutineId = exerciseRoutineId;
    }

    public Long getFamilyRoutineId() {
        return familyRoutineId;
    }

    public void setFamilyRoutineId(Long familyRoutineId) {
        this.familyRoutineId = familyRoutineId;
    }

    public Long getFeedingRoutineId() {
        return feedingRoutineId;
    }

    public void setFeedingRoutineId(Long feedingRoutineId) {
        this.feedingRoutineId = feedingRoutineId;
    }

    public Long getFunRoutineId() {
        return funRoutineId;
    }

    public void setFunRoutineId(Long funRoutineId) {
        this.funRoutineId = funRoutineId;
    }

    public Long getHygieneRoutineId() {
        return hygieneRoutineId;
    }

    public void setHygieneRoutineId(Long hygieneRoutineId) {
        this.hygieneRoutineId = hygieneRoutineId;
    }

    public Long getStudyRoutineId() {
        return studyRoutineId;
    }

    public void setStudyRoutineId(Long studyRoutineId) {
        this.studyRoutineId = studyRoutineId;
    }
}
