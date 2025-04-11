package com.familia_em_ritmo.familia_em_ritmo.infra.dto.relative_controller.add_observer;

public class ObserverSucessMessageDTO {
    public String message;

    public ObserverSucessMessageDTO(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
