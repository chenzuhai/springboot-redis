package com.chen;

import com.chen.util.RedisUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

@SpringBootTest
class Redis02SpringbootApplicationTests {

    @Resource(name = "strKeyRedisTemplate")
    RedisTemplate redisTemplate;

    @Autowired
    RedisUtil redisUtil;

    @Test
    void contextLoads() {
        redisTemplate.opsForValue().set("name","chenzuhai");
        System.out.println(redisTemplate.opsForValue().get("name"));

        RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();

    }

    @Test
    void test() throws JsonProcessingException {
        User user = new User("zuhai", 20);

        //String jsonUser = new ObjectMapper().writeValueAsString(user);


        redisTemplate.opsForValue().set("user",user);

        System.out.println(redisTemplate.opsForValue().get("user"));

    }

    @Test
    void test2(){

        redisUtil.set("name","zuhai");
        System.out.println(redisUtil.get("name"));
    }

}
