package com.yupi.usercenter.service;

import org.junit.jupiter.api.Test;
import org.redisson.api.RList;
import org.redisson.api.RedissonClient;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author xiaozhuang
 * @creat 2023-08-05-11:05
 */
@SpringBootTest
public class testRedisson {

    @Resource
    private RedissonClient redissonClient;
    @Test
    void test(){
        RList<String> rList = redissonClient.getList("test-list");
        rList.add("yupi");
        System.out.println(rList.get(0));
        rList.remove(0);
    }
}
