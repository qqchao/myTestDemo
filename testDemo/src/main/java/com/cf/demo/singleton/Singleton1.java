package com.cf.demo.singleton;

public class Singleton1 {
	private Singleton1(){}
	
	private static Singleton1 instance; 
	
	public static synchronized Singleton1 getInstance(){
		if(instance == null){
			instance = new Singleton1();
		}
		return instance;
	}
	
	public void get(){
		synchronized (instance) {			
			System.out.println("get>>>>"+System.currentTimeMillis());
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("clear>>>>"+System.currentTimeMillis());
		}
	}

	public void clear(){
		System.out.println("clear2>>>>"+System.currentTimeMillis());
	}

	public void insert(){
		synchronized (instance){
			System.out.println("insert>>>>"+System.currentTimeMillis());
		}
	}
	
}
