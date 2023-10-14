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
/**
 * Контроллер для обработки запросов на подсчет символов в строке.
 * Использует {@link CountSymbolsService} для выполнения подсчета символов.
 */
@Controller
@RestController
public class CountSymbols {
    final CountSymbolsService countSymbolsService;

    /**
     * Конструктор контроллера, инъектирующий зависимость на сервис подсчета символов.
     *
     * @param countSymbolsService Сервис подсчета символов, предоставляемый {@link CountSymbolsService}.
     */
    @Autowired
    public CountSymbols(CountSymbolsService countSymbolsService) {
        this.countSymbolsService = countSymbolsService;
    }

    /**
     * Обрабатывает GET-запрос на подсчет символов в переданной строке.
     *
     * @param symbols Объект, содержащий строку символов. См. {@link SymbolsDto}
     * @return Хеш таблица символов и их количества в переданной строке.
     */
    @GetMapping(path = "/count")
    @Cacheable(value = "count")
    public Map<Character, Integer> count(@RequestBody @NotNull SymbolsDto symbols) {
        return countSymbolsService.count(symbols.symbols().toCharArray());
    }
}
