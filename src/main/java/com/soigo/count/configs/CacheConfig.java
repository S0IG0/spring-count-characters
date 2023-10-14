package com.soigo.count.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;

import java.time.Duration;

/**
 * Конфигурационный класс для настройки кеширования с использованием Redis.
 */
@Configuration
@EnableCaching
public class CacheConfig {
    /**
     * Продолжительность жизни кеша в минутах, считываемая из конфигурации.
     */
    @Value("${redis.cache.minutes}")
    Integer lifetimeInMinutes;

    /**
     * Создает и настраивает менеджер Redis кеша.
     *
     * @param redisConnectionFactory Фабрика подключения к Redis.
     * @return Менеджер Redis кеша с настройками продолжительности жизни.
     */
    @Bean
    public RedisCacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
        RedisCacheConfiguration cacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofMinutes(lifetimeInMinutes));

        return RedisCacheManager.builder(redisConnectionFactory)
                .cacheDefaults(cacheConfiguration)
                .build();
    }
}
