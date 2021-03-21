package com.task.letter_counter.controllers;

import com.task.letter_counter.dto.RequestParamDTO;
import com.task.letter_counter.dto.ResponseParamDTO;
import com.task.letter_counter.services.RequestParamDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParamController {
    @Autowired
    private RequestParamDTOService requestParamDTOService;
    @GetMapping("/wordanalyzer/analyze")
    public ResponseEntity<RequestParamDTO> responseParam(@RequestParam("word") String word) {
        String letter;
        int count = 0;
        RequestParamDTOService requestParamDTOService = new RequestParamDTOService();
        RequestParamDTO requestParamDTO = requestParamDTOService.analyze(word);
        letter = requestParamDTO.getLetter();
        count = requestParamDTO.getCount();
        return new ResponseEntity(new ResponseParamDTO(letter, count), HttpStatus.OK);
    }
}
