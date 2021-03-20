package com.task.letter_counter.services;

import com.task.letter_counter.dto.RequestParamDTO;

public class RequestParamDTOService {
    public RequestParamDTO analyze(RequestParamDTO requestParamDTO) {
        String letterWithCount = requestParamDTO.getLetter() + requestParamDTO.getCount();
        return new RequestParamDTO(letterWithCount);

    }
}
