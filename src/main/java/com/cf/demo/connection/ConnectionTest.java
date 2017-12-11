package com.cf.demo.connection;

import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConnectionFactory;

public class ConnectionTest {

	private static Connection connection;
	private static Channel channel;
	
	public static void main(String[] args) {
		
		ConnectionFactory factory = new ConnectionFactory();
		//获取rabbitMQ配置
		factory.setHost("10.10.8.92");
		factory.setPort(5672);
		factory.setUsername("admin");
		factory.setPassword("admin");
		
		Connection connection;
		try {
			connection = factory.newConnection();
			channel = connection.createChannel();
			
			channel.exchangeDeclare("testExchange", "fanout" ,true);
			channel.queueDeclareNoWait("testQueue", true, false, false, null);
			channel.queueBind("testQueue", "testExchange", "");
			
		} catch (IOException | TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TestThread test1 = new TestThread("test1",channel);
		TestThread test2 = new TestThread("test2",channel);
		TestThread test3 = new TestThread("test3",channel);
		TestThread test4 = new TestThread("test4",channel);
		TestThread test5 = new TestThread("test4",channel);
		TestThread test6 = new TestThread("test4",channel);
		TestThread test7 = new TestThread("test4",channel);
		TestThread test8 = new TestThread("test4",channel);
		TestThread test9 = new TestThread("test4",channel);
		TestThread test0 = new TestThread("test4",channel);
		
		
		test1.start();
		test2.start();
		test3.start();
		test4.start();
		test5.start();
		test6.start();
		test7.start();
		test8.start();
		test9.start();
		test0.start();
	}
	
	
}

