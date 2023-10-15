package com.soigo.count;

import com.soigo.count.controllers.CountCharacters;
import com.soigo.count.dto.CharactersDto;
import com.soigo.count.services.CountCharactersService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountCharactersControllerTest {

    private CountCharacters countCharactersController;

    @Mock
    private CountCharactersService countCharactersService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        countCharactersController = new CountCharacters(countCharactersService);
    }

    @Test
    public void testCountCharacters() {
        CharactersDto charactersDto = new CharactersDto("aabbcc");

        Map<Character, Integer> expectedMap = new HashMap<>();
        expectedMap.put('a', 2);
        expectedMap.put('b', 2);
        expectedMap.put('c', 2);

        Mockito.when(countCharactersService.count(Mockito.any())).thenReturn(expectedMap);

        ResponseEntity<Map<Character, Integer>> responseEntity = countCharactersController.count(charactersDto);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(expectedMap, responseEntity.getBody());
    }

    @Test
    public void testCountCharactersEmpty() {
        CharactersDto charactersDto = new CharactersDto("");

        Map<Character, Integer> expectedMap = new HashMap<>();

        ResponseEntity<Map<Character, Integer>> responseEntity = countCharactersController.count(charactersDto);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(expectedMap, responseEntity.getBody());
    }

    @Test
    public void testCountWithSingleCharacter() {
        CharactersDto charactersDto = new CharactersDto("a");

        Map<Character, Integer> expectedMap = new HashMap<>();
        expectedMap.put('a', 1);

        Mockito.when(countCharactersService.count(Mockito.any())).thenReturn(expectedMap);

        ResponseEntity<Map<Character, Integer>> responseEntity = countCharactersController.count(charactersDto);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(expectedMap, responseEntity.getBody());
    }
}
