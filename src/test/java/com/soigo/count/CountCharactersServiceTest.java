package com.soigo.count;

import com.soigo.count.services.CountCharactersService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class CountCharactersServiceTest {

    private CountCharactersService countCharactersService;

    @BeforeEach
    public void setUp() {
        countCharactersService = new CountCharactersService();
    }

    @Test
    public void testCountWithEmptyArray() {
        char[] characters = {};
        Map<Character, Integer> result = countCharactersService.count(characters);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testCountWithSingleCharacter() {
        char[] characters = {'a'};
        Map<Character, Integer> result = countCharactersService.count(characters);

        assertEquals(1, result.get('a').intValue());
        assertEquals(1, result.size());
    }

    @Test
    public void testCountWithRepeatingCharacters() {
        char[] characters = {'a', 'b', 'a', 'c', 'b', 'a'};
        Map<Character, Integer> result = countCharactersService.count(characters);

        assertEquals(3, result.get('a').intValue());
        assertEquals(2, result.get('b').intValue());
        assertEquals(1, result.get('c').intValue());
    }
}
