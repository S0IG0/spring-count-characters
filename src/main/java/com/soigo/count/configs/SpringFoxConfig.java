package com.soigo.count.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Конфигурационный класс для настройки Swagger (SpringFox) в приложении.
 */
@Configuration
@EnableSwagger2
public class SpringFoxConfig {
    /**
     * Создает и настраивает Docket, который предоставляет Swagger-документацию для контроллеров приложения.
     *
     * @return Объект Docket для Swagger-конфигурации.
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.soigo.count.controllers"))
                .paths(PathSelectors.any())
                .build();
    }
}