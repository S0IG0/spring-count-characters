package com.soigo.count.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * Объект данных (DTO), представляющий строку символов для обработки.
 */
public record CharactersDto(
        @ApiModelProperty(example = "aaaaabcccc")
        String symbols
) {
    /**
     * Создает новый объект {@link CharactersDto} с заданной строкой символов.
     *
     * @param symbols Строка символов.
     */
    public CharactersDto {
    }
}
