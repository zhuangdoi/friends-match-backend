package com.yupi.usercenter;

import com.yupi.usercenter.model.domain.User;
import com.yupi.usercenter.service.UserService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.redisson.api.RList;
import org.redisson.api.RedissonClient;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.SpringVersion;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;

/**
 * 启动类测试
 *
 */
@SpringBootTest
class UserCenterApplicationTests {

    @Resource
    private UserService userService;

    @Resource
    private RedissonClient redissonClient;


//    @Test
//    void testSearchUserByTags() {
//        List<String> tagNameList = Arrays.asList("男");
//         List<User> userList = userService.searchUsersByTags(tagNameList);
//         System.out.println(userList);
//    }

//    @Test
//    void mainTest(){
//        String springVersion = SpringVersion.getVersion();
//        String springBootVersion = SpringBootVersion.getVersion();
//        System.out.println("Spring版本:"+springVersion+"\nSpringBoot版本:"+springBootVersion);
//    }

//    @Test
//    void test(){
//        RList<String> rList = redissonClient.getList("test-list");
//        rList.add("yupi");
//        System.out.println(rList.get(0));
//        rList.remove(0);
//    }



}

