package com.accenture.springexercise.mybatis.config;

import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.*;
import java.time.Duration;


@Configuration
public class RedisConfig {

    
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory factory) {
        
        RedisCacheConfiguration cacheConfig1 = RedisCacheConfiguration.defaultCacheConfig()
                
                .entryTtl(Duration.ofMinutes(10))
                
                .prefixKeysWith("cache:student:")
                
                .disableCachingNullValues()
                
                .serializeKeysWith(keyPair())
                
                .serializeValuesWith(valuePair());
        RedisCacheConfiguration cacheConfig2 = RedisCacheConfiguration.defaultCacheConfig()
                
                .entryTtl(Duration.ofSeconds(30))
                .prefixKeysWith("cache:student_info:")
                .disableCachingNullValues()
                .serializeKeysWith(keyPair())
                .serializeValuesWith(valuePair());
        
        return RedisCacheManager.builder(factory)
                .withCacheConfiguration("student", cacheConfig1)
                .withCacheConfiguration("studentInfo", cacheConfig2)
                .build();
    }

    
    private RedisSerializationContext.SerializationPair<String> keyPair() {
        return RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer());
    }

    
    private RedisSerializationContext.SerializationPair<Object> valuePair() {
        return RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer());
    }

}
