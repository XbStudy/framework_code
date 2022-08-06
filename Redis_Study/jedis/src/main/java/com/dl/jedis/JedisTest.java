package com.dl.jedis;

import jdk.nashorn.internal.scripts.JD;
import redis.clients.jedis.Jedis;

import java.util.Set;

public class JedisTest {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.184.100",6379);
        jedis.auth("root");
        System.out.println("-----------测试连接:----------");
        String ping = jedis.ping();
        System.out.println(ping);
        System.out.println("-----------测试操作:----------");
        jedis.set("string","strV");
        jedis.rpush("list","aa","bb","cc");
        jedis.sadd("set","11","22","33","22");
        jedis.hset("hash","name","xiaobai");
        jedis.zadd("zset",100d,"java");
        jedis.setbit("bitmaps",0,"1");
        jedis.pfadd("hyperloglog","xx","yy","zz");
        jedis.geoadd("china:city",106.50d,29.53d,"chongqing");
        System.out.println("-----------关于Key:----------");
        System.out.println(jedis.keys("*"));
        System.out.println(jedis.dbSize());
        jedis.close();
    }
}
