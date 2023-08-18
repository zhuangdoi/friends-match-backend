package com.yupi.usercenter.config;

import lombok.Data;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.boot.context.properties.ConfigurationProperties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Redisson 配置
 */
@Configuration
@ConfigurationProperties(prefix = "spring.redis")
@Data
public class RedissonConfig {


    @Bean
    public RedissonClient redissonClient() {
        // 1. Create config object
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379").setDatabase(3);

        //2.创建实例
        RedissonClient redisson = Redisson.create(config);
        return redisson;
    }
}