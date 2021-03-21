package com.task.letter_counter.dto;

public class RequestParamDTO {
    private String letter;
    private int count;

    public RequestParamDTO() {
    }

    public RequestParamDTO(String letter, int count) {
        this.letter = letter;
        this.count = count;
    }


    public String getLetter() {
        return letter;
    }


    public int getCount() {
        return count;
    }
}
