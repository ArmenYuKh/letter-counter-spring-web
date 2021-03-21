package com.task.letter_counter.dto;

public class ResponseParamDTO {
    private String letter;
    private int count;

    public ResponseParamDTO(String letter, int count) {
        this.letter = letter;
        this.count = count;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
