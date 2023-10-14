package com.soigo.count.services;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class CountSymbolsService {

    private @NotNull Map<Character, Integer> sortedMap(@NotNull Map<Character, Integer> map) {
        Map<Character, Integer> sortedCharacterCount = new LinkedHashMap<>();
        map.entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(entry -> sortedCharacterCount.put(entry.getKey(), entry.getValue()));
        return sortedCharacterCount;
    }

    public Map<Character, Integer> count(char @NotNull [] characters) {
        Map<Character, Integer> characterCount = new HashMap<>();
        for (char character : characters) {
            characterCount.put(character, characterCount.getOrDefault(character, 0) + 1);
        }

        return sortedMap(characterCount);
    }
}
