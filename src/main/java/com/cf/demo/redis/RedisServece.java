package com.cf.demo.redis;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Service
public class RedisServece {

	@Autowired
	private JedisPool jedisPool;
	
	public void runTest(String sNumber) {
		int number = Integer.parseInt(sNumber);
		
		long time1 = new Date().getTime();
		
		Jedis jedis1 = jedisPool.getResource();
		for(int i = 0; i < number; i++){
			jedis1.rpush("key1", String.valueOf(i));
		}
		jedis1.close();
		
		long time2 = new Date().getTime();
		
		for(int i = 0; i < number; i++){
			Jedis jedis2 = jedisPool.getResource();
			jedis2.rpush("key2", String.valueOf(i));
			jedis2.close();
		}
		
		long time3 = new Date().getTime();
		
		long runTime1 = (time2 - time1)/1000;
		long runTime2 = (time3 - time2)/1000;
		
		System.out.println("***************");
		System.out.println("*****Redis*****");
		System.out.println("插入值次数：" + number);
		System.out.println("方法1时长：" + runTime1);
		System.out.println("方法2时长：" + runTime2);
		System.out.println("---------------");
		
	}

	public void testPop(String sNumber) {
		
		int number = Integer.parseInt(sNumber);

		long time1 = new Date().getTime();
		Jedis jedis1 = jedisPool.getResource();
		
		List<String> values1 = jedis1.lrange("key1", 0, number);
		jedis1.ltrim("key1", number, -1);
		
		jedis1.close();

		long time2 = new Date().getTime();
		Jedis jedis2 = jedisPool.getResource();
		List<String> values2 = new ArrayList<>();
		for(int i = 0; i < number; i++){
//			String value2 = jedis2.lpop("key2");
//			if(value2 != null)
//			values2.add(value2);
			jedis2.lpop("key2");
		}
		jedis1.close();
		
		long time3 = new Date().getTime();
		
		long runTime1 = (time2 - time1);
		long runTime2 = (time3 - time2);
		
		System.out.println("***************");
		System.out.println("*****Redis*****");
		System.out.println("读取值条数：" + number);
		System.out.println("方法1时长：" + runTime1);
		System.out.println("方法2时长：" + runTime2);
		System.out.println("---------------");
	}

}
