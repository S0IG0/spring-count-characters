package com.soigo.count.controllers;

import com.soigo.count.dto.SymbolsDto;
import com.soigo.count.services.CountSymbolsService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Controller
@RestController
public class CountSymbols {
    final CountSymbolsService countSymbolsService;

    @Autowired
    public CountSymbols(CountSymbolsService countSymbolsService) {
        this.countSymbolsService = countSymbolsService;
    }

    @GetMapping(path = "/count")
    @Cacheable(value = "count")
    public Map<Character, Integer> count(@RequestBody @NotNull SymbolsDto symbols) {
        return countSymbolsService.count(symbols.symbols().toCharArray());
    }
}
