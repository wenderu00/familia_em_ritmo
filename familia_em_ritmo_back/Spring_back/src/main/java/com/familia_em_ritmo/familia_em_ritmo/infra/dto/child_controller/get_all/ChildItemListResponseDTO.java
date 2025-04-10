package com.familia_em_ritmo.familia_em_ritmo.infra.dto.child_controller.get_all;

public class ChildItemListResponseDTO {
    private Long id;
    private String name;
    private int age;
    private Long relativeManagerId;
    private String relativeManagerName;

    public ChildItemListResponseDTO(Long id, String name, int age, Long relativeManagerId, String relativeManagerName) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.relativeManagerId = relativeManagerId;
        this.relativeManagerName = relativeManagerName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Long getRelativeManagerId() {
        return relativeManagerId;
    }

    public void setRelativeManagerId(Long relativeManagerId) {
        this.relativeManagerId = relativeManagerId;
    }

    public String getRelativeManagerName() {
        return relativeManagerName;
    }

    public void setRelativeManagerName(String relativeManagerName) {
        this.relativeManagerName = relativeManagerName;
    }
}
