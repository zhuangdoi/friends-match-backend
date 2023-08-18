package com.yupi.usercenter.job;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.yupi.usercenter.model.domain.User;
import com.yupi.usercenter.service.UserService;
import lombok.extern.slf4j.Slf4j;

import org.openxmlformats.schemas.spreadsheetml.x2006.main.STSourceType;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author: shayu
 * @date: 2022/12/11
 * @ClassName: yupao-backend01
 * @Description:        数据预热
 */

@Component
@Slf4j
public class PreCacheJob {

    @Resource
    private UserService userService;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    //注入redisson：操作redis的客户端
    @Resource
    private RedissonClient redissonClient;

    // 重点用户
    private List<Long> mainUserList = Arrays.asList(1L);

    // 每天执行，预热推荐用户
    @Scheduled(cron = "0 20 16 * * ? ")   //自己设置时间测试
    public void doCacheRecommendUser() {

        RLock lock = redissonClient.getLock("yupao:precachejob:docache:lock");


       try {
           //只有一个线程可以获取锁
           if (lock.tryLock(0, -1, TimeUnit.MILLISECONDS)) {
               System.out.println("getLock" + Thread.currentThread().getId());
               for (Long userId :mainUserList){
                   //查数据库
                   QueryWrapper<User> queryWrapper = new QueryWrapper<>();
                   Page<User> userPage = userService.page(new Page<>(1, 20), queryWrapper);
                   String redisKey = String.format("shayu:user:recommend:%s", userId);
                   ValueOperations valueOperations = redisTemplate.opsForValue();
                   //写缓存,30s过期
                   try {
                       valueOperations.set(redisKey, userPage, 30000, TimeUnit.MILLISECONDS);
                   } catch (Exception e) {
                       log.error("redis set key error", e);
                   }
               }
           }
       }catch (InterruptedException e){
           log.error("doCacheRecommendUser error",e);
       }finally {
           //只能释放自己的锁
           if (lock.isHeldByCurrentThread()){
               System.out.println("unLock" + Thread.currentThread().getId());
               lock.unlock();
           }
       }



    }

}