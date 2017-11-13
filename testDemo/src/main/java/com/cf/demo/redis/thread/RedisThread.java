package com.cf.demo.redis.thread;

import java.util.Date;
import java.util.List;

import com.cf.demo.util.SpringUtil;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Pipeline;

public class RedisThread extends Thread{

	private JedisPool jedisPool = (JedisPool) SpringUtil.getInstance().getBeanById("JedisPool");
	
	private String name;
	
	public RedisThread(String name){
		this.name = name;
	}
	
	public void run(){
		Jedis jedis = jedisPool.getResource();
		String list = "list";
		
		long time1 = new Date().getTime();
		
		while(true){
			Pipeline pipelined = jedis.pipelined();  
			
			pipelined.lrange(list, 0, 9);
			pipelined.ltrim(list, 10, -1);
			List<Object> results = pipelined.syncAndReturnAll();
			
			List<String> result = (List<String>)results.get(0);
			
			String[] ssResult = new String[10];
			
			if(result.isEmpty()){
				break;
			}
			
			for(int i = 0; i < result.size(); i++){
				ssResult[i] = result.get(i);
			}
			
			jedis.sadd("set", ssResult);
			
		}
		
		long runTime = new Date().getTime() - time1;
		
		System.out.println(name + " 运行时长：" + runTime);
		
		jedis.close();
	}
}
