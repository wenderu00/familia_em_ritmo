package com.familia_em_ritmo.familia_em_ritmo.infra.dto.relative_controller.add_observer;

public class IdsObserverToChildDTO {
    private Long relative_id;
    private Long observer_id;
    private Long child_id;

    public IdsObserverToChildDTO(Long relative_id, Long observer_id, Long child_id) {
        this.relative_id = relative_id;
        this.observer_id = observer_id;
        this.child_id = child_id;
    }

    public Long getRelative_id() {
        return relative_id;
    }

    public void setRelative_id(Long relative_id) {
        this.relative_id = relative_id;
    }

    public Long getObserver_id() {
        return observer_id;
    }

    public void setObserver_id(Long observer_id) {
        this.observer_id = observer_id;
    }

    public Long getChild_id() {
        return child_id;
    }

    public void setChild_id(Long child_id) {
        this.child_id = child_id;
    }
}
