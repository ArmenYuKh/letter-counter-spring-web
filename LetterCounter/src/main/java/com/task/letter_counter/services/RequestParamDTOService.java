package com.task.letter_counter.services;


import com.task.letter_counter.dto.RequestParamDTO;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RequestParamDTOService {
    public RequestParamDTO analyze (String word) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        List<Character> list = new LinkedList<>();

        String letter = null;
        int count = 0;

        // помещаем в map букву (без повтора) в качестве ключа и число её вхождений в качестве значения
        for (int i = 0; i < word.length(); i++) {
            char letters = word.charAt(i);
            if (map.containsKey(letters)) {
                int cnt = map.get(letters); // количество повторений
                map.put(letters, ++cnt);
            } else
                map.put(letters, 1);
        }
        // узнаём число вхождений той буквы, которая встречается наибольшее количество раз
        int maxMap = Collections.max(map.values());

        // помещаем те буквы, которые встречаются наибольшее количество раз, в коллекцию
        for (Map.Entry<Character, Integer> pair : map.entrySet()) {
            if (pair.getValue().equals(maxMap)) {
                list.add(pair.getKey());
            }
        }

        List<Integer> lastIndex = new ArrayList<>();
        char maxChar = 0;
        // сравниваем буквы из коллекции, которые имеют одинаковое количество вхождений, с буквами из исходного слова,
        // находим ту букву, которая встречается в слове последней. Для этого сначала помещаем совпавшие при сравнении
        // буквы в коллекцию в том же порядке, что и в исходном слове
        for (Character character : list) {
            String tmp = String.valueOf(character);
            if (word.contains(tmp)) {
                for (int i = 0; i < list.size(); i++) {
                    lastIndex.add(word.lastIndexOf(tmp));
                }
                // искомой буквой будет та, которая имеет максимальынй индекс в коллекции
                maxChar = word.charAt(Collections.max(lastIndex));
            }
        }

        // зная теперь искомую букву, возвращаем саму букву и число её вхождений
        for (Map.Entry<Character, Integer> pair : map.entrySet()) {
            if (pair.getKey().equals(maxChar)) {
                letter = String.valueOf(pair.getKey());
                count = pair.getValue();
            }
        }
        return new RequestParamDTO(letter, count);
    }
}
