package com.yupi.usercenter.service;

import com.yupi.usercenter.model.domain.User;
import org.apache.xmlbeans.impl.xb.xsdschema.Attribute;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;

/**
 * @author xiaozhuang
 * @creat 2023-08-03-21:17
 */
@SpringBootTest
public class RedisTest {

    @Resource
    private RedisTemplate redisTemplate;

    @Test
    public void testRedis(){
        ValueOperations valueOperations = redisTemplate.opsForValue();
        //增
        valueOperations.set("name","zhiping");
        valueOperations.set("age",18);
        valueOperations.set("price",12.0);
        User user = new User();
        user.setId(1L);
        user.setPhone("123456");
        valueOperations.set("user",user);
        //查
        Object name = valueOperations.get("name");
        Assertions.assertTrue("zhiping".equals((String) name));
        //删除
     //  redisTemplate.delete("name");

    }
}
