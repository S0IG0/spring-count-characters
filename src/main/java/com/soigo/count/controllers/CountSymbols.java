package com.soigo.count.controllers;

import com.soigo.count.dto.SymbolsDto;
import com.soigo.count.services.CountSymbolsService;
import io.swagger.annotations.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


/**
 * Контроллер для обработки запросов на подсчет символов в строке.
 * Использует {@link CountSymbolsService} для выполнения подсчета символов.
 */
@Api(value = "CountSymbols", description = "Операции связанные с подсчетом символов")
@Controller
@RestController
@RequestMapping("/api")
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
     * Обрабатывает Post-запрос на подсчет символов в переданной строке.
     *
     * @param symbols Объект, содержащий строку символов. См. {@link SymbolsDto}
     * @return Хеш таблица символов и их количества в переданной строке.
     */
    @ApiOperation(value = "Подсчет символов в строке")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Успешный запрос. Возвращает хеш-таблицу символов и их количества.",
                    examples = @Example({
                            @ExampleProperty(mediaType = "application/json", value = "{\"a\": 5, \"с\": 4, \"b\": 1}")
                    })),
            @ApiResponse(code = 400, message = "Неверный запрос. Возвращается в случае ошибки в запросе."),
            @ApiResponse(code = 500, message = "Внутренняя ошибка сервера. Возвращается в случае ошибки на сервере.")
    })
    @PostMapping(path = "/count", produces = "application/json")
    @Cacheable(value = "count")
    public ResponseEntity<Map<Character, Integer>> count(
            @ApiParam(value = "Объект, содержащий строку символов")
            @RequestBody
            @NotNull SymbolsDto symbols
    ) {
        return ResponseEntity.ok().body(countSymbolsService.count(symbols.symbols().toCharArray()));
    }
}
