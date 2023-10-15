package com.soigo.count.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * Объект данных (DTO), представляющий строку символов для обработки.
 */
public record SymbolsDto(
        @ApiModelProperty(example = "aaaaabcccc")
        String symbols
) {
    /**
     * Создает новый объект `SymbolsDto` с заданной строкой символов.
     *
     * @param symbols Строка символов.
     */
    public SymbolsDto {
    }
}
