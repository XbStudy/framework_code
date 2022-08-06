package com.atguigu;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Transaction;

import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 *
 */
public class My_SecKill_redis {

	public static void main(String[] args) {
//		Jedis jedis =new Jedis("192.168.184.100",6379);
//		jedis.auth("root");
//		System.out.println(jedis.ping());
//		jedis.close();

		JedisPool jedisPool = JedisPoolUtil.getJedisPoolInstance();
		Jedis jedis = jedisPool.getResource();
		jedis.auth("root");
		System.out.println(jedis.ping());

	}

	//秒杀过程
	public static boolean doSecKill(String uid,String prodid) throws IOException {

		//1 uid和prodid非空判断
		if (uid == null || prodid == null){
			System.out.println("用户id或商品id为null~");
			return false;
		}

		//2 连接redis
//		Jedis jedis =new Jedis("192.168.184.100",6379);
//		jedis.auth("root");
		JedisPool jedisPool = JedisPoolUtil.getJedisPoolInstance();
		Jedis jedis = jedisPool.getResource();
		jedis.auth("root");

		//3 拼接key
		// 3.1 库存key
		String prodkey = "KEY:"+prodid+":prod";
		// 3.2 秒杀成功用户key
		String userKey = "KEY:"+prodid+":user";

		//监视库存
		jedis.watch(prodkey);

		//4 获取库存，如果库存null，秒杀还没有开始
		String amount = jedis.get(prodkey);
		if (amount==null){
			System.out.println("秒杀还没开始~~~");
			jedis.close();
			return false;
		}

		// 5 判断用户是否重复秒杀操作
		boolean contains = jedis.smembers(userKey).contains(uid);
		if (contains){
			System.out.println("你已经秒杀过了~~~");
			jedis.close();
			return false;
		}

		//6 判断如果商品数量，库存数量小于1，秒杀结束
		if (Integer.parseInt(amount) <= 0){
			System.out.println("秒完了~~~");
			jedis.close();
			return false;
		}

		//7 秒杀过程
//		//7.1 库存-1;
//		jedis.decr(prodkey);
//		//7.1 用户加1;
//		jedis.sadd(userKey,uid);

		//使用事务：
		Transaction multi = jedis.multi();
		multi.decr(prodkey);
		multi.sadd(userKey,uid);

		//执行事务：
		List<Object> exec = multi.exec();
		if (exec==null || exec.size()<=0){
			System.out.println("秒杀失败了~~~");
			jedis.close();
			return false;
		}
		System.out.println("抢到了~~~");
		jedis.close();
		return true;
	}
}
















