package com.task.letter_counter.controllers;

import com.task.letter_counter.dto.RequestParamDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class ParamController {
    @GetMapping("/wordanalyzer/analyze")
    public ResponseEntity<RequestParamDTO> responseParam(@RequestParam("word") String word) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        List<Character> list = new LinkedList<>();

        String letter;
        int count;

        for (int i = 0; i < word.length(); i++) {
            char letters = word.charAt(i);
            if (map.containsKey(letters)) {
                int cnt = map.get(letters); // количество повторений
                map.put(letters, ++cnt);
            } else
                map.put(letters, 1);
        }
        int maxMap = Collections.max(map.values());

        for (Map.Entry<Character, Integer> pair : map.entrySet()) {
            if (pair.getValue().equals(maxMap)) {
                list.add(pair.getKey());
            }
        }

        List<Integer> lastIndex = new ArrayList<>();
        char maxChar = 0;

        for (Character character : list) {
            String tmp = String.valueOf(character);
            if (word.contains(tmp)) {
                for (int i = 0; i < list.size(); i++) {
                    lastIndex.add(word.lastIndexOf(tmp));
                }
                maxChar = word.charAt(Collections.max(lastIndex));
            }

        }

        for (Map.Entry<Character, Integer> pair : map.entrySet()) {
            if (pair.getKey().equals(maxChar)) {
                letter = String.valueOf(pair.getKey());
                count = pair.getValue();
                new RequestParamDTO(letter, count);
            }
        }

        return new ResponseEntity<>(new RequestParamDTO(word), HttpStatus.OK);
    }
}
