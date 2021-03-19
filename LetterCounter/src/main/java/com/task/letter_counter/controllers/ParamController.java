package com.task.letter_counter.controllers;

import com.task.letter_counter.dto.RequestParamDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParamController {
    @GetMapping("/params/requestParams")
    public ResponseEntity responseParam(@RequestParam("word") String word) {
        return new ResponseEntity(new RequestParamDTO(word), HttpStatus.OK);
    }
}
