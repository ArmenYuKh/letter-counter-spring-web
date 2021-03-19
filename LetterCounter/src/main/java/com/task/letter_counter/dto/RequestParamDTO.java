package com.task.letter_counter.dto;

public class RequestParamDTO {
    private String name;

    public RequestParamDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
