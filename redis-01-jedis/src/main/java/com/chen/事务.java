package com.chen;

import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

/**
 * @author Zuhai Chen
 * @version 1.0
 * @date 2020/12/10
 */

public class 事务 {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("10.0.0.102",6379);

        jedis.flushAll();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("key1","value1");
        jsonObject.put("key2","value2");
        jsonObject.put("key3","value3");

        //开启事务
        Transaction multi = jedis.multi();
        String result = jsonObject.toJSONString();


        //jedis.watch("");

        try{
            multi.set("field1",result);
            multi.set("field2",result);

            int i = 1/0;

            multi.exec();
        }catch (Exception e){
            multi.discard();
            e.printStackTrace();
        }finally {
            System.out.println(jedis.get("field1"));
            jedis.close();
        }


    }
}
