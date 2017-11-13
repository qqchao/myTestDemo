package com.cf.demo.rabbitmq;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.concurrent.TimeoutException;

import org.springframework.stereotype.Service;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

@Service
public class RabbitService {

	public void test(String sNumber) throws IOException, TimeoutException {
		int number = Integer.parseInt(sNumber);
		
		//初始化消费者对象
    	ConnectionFactory factory1 = new ConnectionFactory();
    	
    	factory1.setHost("10.10.8.92");
		factory1.setPort(5672);
		factory1.setUsername("admin");
		factory1.setPassword("admin");
    	
    	//获取连接
    	Connection connection1;
		connection1 = factory1.newConnection();
		Channel channel1 = connection1.createChannel();
		//使用fanout交换机
		channel1.exchangeDeclare("testExchange", "fanout" ,true);
		channel1.queueDeclareNoWait("testQueue", true, false, false, null);
		channel1.queueBind("testQueue", "testExchange", "");
		
		
		
		long time1 = new Date().getTime();
		
		ConnectionFactory factory2 = new ConnectionFactory();
		
		factory2.setHost("10.10.8.92");
		factory2.setPort(5672);
		factory2.setUsername("admin");
		factory2.setPassword("admin");
		//创建一个新的连接
		Connection connection2 = factory2.newConnection();
		//创建一个通道
		Channel channel2 = connection2.createChannel();

		for(int i = 0; i < number; i++){
			//将要发布的字符串进行UTF-8编码
			String dataEncode = URLEncoder.encode(String.valueOf(i), "utf-8");
			//发送消息到队列中
			channel2.basicPublish("testExchange", "", null, dataEncode.getBytes("UTF-8"));
		}
		//关闭通道和连接
		channel2.close();
		connection2.close();
		
		long time2 = new Date().getTime();
		
//		for(int i = 0; i < number; i++){
//			ConnectionFactory factory3 = new ConnectionFactory();
//			
//			factory3.setHost("10.10.8.92");
//			factory3.setPort(5672);
//			factory3.setUsername("admin");
//			factory3.setPassword("admin");
//			//创建一个新的连接
//			Connection connection3 = factory3.newConnection();
//			//创建一个通道
//			Channel channel3 = connection3.createChannel();
//
//			//将要发布的字符串进行UTF-8编码
//			String dataEncode = URLEncoder.encode(String.valueOf(i), "utf-8");
//			//发送消息到队列中
//			channel3.basicPublish("testExchange", "", null, dataEncode.getBytes("UTF-8"));
//			//关闭通道和连接
//			channel3.close();
//			connection3.close();
//			
//		}
		
		long time3 = new Date().getTime();
		
		ConnectionFactory factory4 = new ConnectionFactory();
		
		factory4.setHost("10.10.8.92");
		factory4.setPort(5672);
		factory4.setUsername("admin");
		factory4.setPassword("admin");
		//创建一个新的连接
		Connection connection4 = factory4.newConnection();
		for(int i = 0; i < number; i++){
			//创建一个通道
			Channel channel4 = connection4.createChannel();

			//将要发布的字符串进行UTF-8编码
			String dataEncode = URLEncoder.encode(String.valueOf(i), "utf-8");
			//发送消息到队列中
			channel4.basicPublish("testExchange", "", null, dataEncode.getBytes("UTF-8"));
			//关闭通道和连接
			channel4.close();
			
		}
		connection4.close();
		
		long time4 = new Date().getTime();
		
		long runTime1 = (time2 - time1);
		long runTime2 = (time3 - time2);
		long runTime3 = (time4 - time3);
		
		System.out.println("****************");
		System.out.println("****RabbitMQ****");
		System.out.println("插入值次数：" + number);
		System.out.println("方法1时长：" + runTime1);
		System.out.println("方法2时长：" + runTime2);
		System.out.println("方法3时长：" + runTime3);
		System.out.println("----------------");
	}

}
