package com.soigo.count.services;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Сервис для подсчета количества вхождений символов в заданный массив символов и сортировки результатов.
 */
@Service
public class CountSymbolsService {
    /**
     * Сортирует заданную хеш таблицу по убыванию значений.
     *
     * @param map Исходная карта, которую необходимо отсортировать.
     * @return Отсортированная карта с сохранением порядка ключей.
     */
    private @NotNull Map<Character, Integer> sortedMap(@NotNull Map<Character, Integer> map) {
        Map<Character, Integer> sortedCharacterCount = new LinkedHashMap<>();
        map.entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(entry -> sortedCharacterCount.put(entry.getKey(), entry.getValue()));
        return sortedCharacterCount;
    }

    /**
     * Подсчитывает количество вхождений каждого символа в заданный массив символов.
     *
     * @param characters Массив символов, для которых нужно подсчитать количество вхождений.
     * @return Хеш таблица с символами в качестве ключей и количеством их вхождений в качестве значений.
     */
    public Map<Character, Integer> count(char @NotNull [] characters) {
        Map<Character, Integer> characterCount = new HashMap<>();
        for (char character : characters) {
            characterCount.put(character, characterCount.getOrDefault(character, 0) + 1);
        }

        return sortedMap(characterCount);
    }
}
