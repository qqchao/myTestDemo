package com.cf.demo.connection;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import com.rabbitmq.client.Channel;

public class TestThread extends Thread{
	
	String name;
	int i = 0;
	Channel channel;
	
	public TestThread(String name, Channel channel){
		this.name = name;
		this.channel = channel;
	}
	
	public void run(){
		while(i < 10000){
			
			try {
				channel.basicPublish("testExchange", "", null, String.valueOf("sakjdfhlksadfuioasjfdlksaufiodasjlfkdsauiod").getBytes("UTF-8"));
				System.out.println(name + " : " + i);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			i++;
		}
		
		
	}
}
