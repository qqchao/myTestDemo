package com.cf.demo.redis.thread;

import org.springframework.stereotype.Service;

@Service
public class RedisThreadService {

	public void runTest() {
		
		RedisThread redisThread1 = new RedisThread("Thread1");
		RedisThread redisThread2 = new RedisThread("Thread2");
		RedisThread redisThread3 = new RedisThread("Thread3");
		
		redisThread1.start();
		redisThread2.start();
		redisThread3.start();
	}

}
