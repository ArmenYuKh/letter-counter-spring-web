package com.task.letter_counter;

import com.task.letter_counter.dto.RequestParamDTO;
import com.task.letter_counter.services.RequestParamDTOService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class AnalyzerTest {

    @Test
    void testAnalyzeMethod(){
        RequestParamDTOService requestParamDTOService = new RequestParamDTOService();
        RequestParamDTO requestParamDTO1 = requestParamDTOService.analyze("test");
        assertThat(requestParamDTO1.getLetter()).isEqualTo("t");
        assertThat(requestParamDTO1.getCount()).isEqualTo(2);

        RequestParamDTO requestParamDTO2 = requestParamDTOService.analyze("tester");
        assertThat(requestParamDTO2.getLetter()).isEqualTo("e");
        assertThat(requestParamDTO2.getCount()).isEqualTo(2);

        System.out.println("Тесты пройдены успешно! Полученная буква и число вхождений для каждого случая верны.");
    }
}
