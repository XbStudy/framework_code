package com.dl.jedis;


import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 操作集群：
 */
public class JedisDemo {
    public static void main(String[] args) {

        HostAndPort hostAndPort = new HostAndPort("192.168.184.100", 6379);

        JedisPoolConfig config = new JedisPoolConfig();
        config .setMaxTotal(500);
        config .setMinIdle(2);
        config .setMaxIdle(500);
        config .setMaxWaitMillis(10000);
        config .setTestOnBorrow(true);
        config .setTestOnReturn(true);

        JedisCluster jedisCluster = new JedisCluster(hostAndPort,15000,15000,100,"root",config);

        jedisCluster.set("hello", "hello");
        String hello = jedisCluster.get("hello");
        System.out.println(hello);

    }
}
