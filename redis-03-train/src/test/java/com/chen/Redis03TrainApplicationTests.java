package com.chen;

import com.chen.dao.entity.User;
import com.chen.util.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;

@SpringBootTest
class Redis03TrainApplicationTests {



    @Resource(name = "strKeyRedisTemplate")
    RedisTemplate redisTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisUtil redisUtil;

    @Test
    void contextLoads() {

        redisTemplate.opsForValue().set("name","zuhai");

        System.out.println(redisTemplate.opsForValue().get("name"));

    }

    @Test
    void test02(){
        redisTemplate.opsForValue().set("user:"+1,new User(1,"zuhai",20));

        User user = (User) redisTemplate.opsForValue().get("user:"+1);

        user.hashCode();

        System.out.println(user);
    }

    @Test
    void test03(){


        stringRedisTemplate.opsForValue().setIfAbsent("num","0");
        for (int i = 0; i < 100; i++) {
            stringRedisTemplate.opsForValue().increment("num");
        }
        System.out.println(stringRedisTemplate.opsForValue().get("num"));


    }

}
