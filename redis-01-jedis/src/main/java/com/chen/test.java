package com.chen;


import redis.clients.jedis.Jedis;

/**
 * @author Zuhai Chen
 * @version 1.0
 * @date 2020/12/10
 */

public class test {
    public static void main(String[] args) {
        //1. jedis对象
        Jedis jedis = new Jedis("192.168.31.90",6379);
        jedis.flushAll();
        jedis.sadd("name","chenzuhai","666");

        jedis.srem("name","chenzuhai");

        System.out.println(jedis.smembers("name"));


    }
}
