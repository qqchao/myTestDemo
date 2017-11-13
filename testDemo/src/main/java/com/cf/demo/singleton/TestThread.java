package com.cf.demo.singleton;

public class TestThread {
	public static void main(String[] args) {
		
		new Thread(new TestABThread()).start();
		new Thread(new TestCThread()).start();
		
	}
	
}

class TestABThread implements Runnable{

	@Override
	public void run() {
		while(true){
			try {
				Singleton singleton = Singleton.getInstance();
				Thread.sleep(700);
				singleton.get();
				Thread.sleep(700);
				singleton.clear();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class TestCThread implements Runnable{
	
	@Override
	public void run() {
		Singleton singleton = Singleton.getInstance();
		while(true){
			
			try {
				Thread.sleep(700);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			singleton.insert();
		}
		
	}
	
}

class Singleton {
	private Singleton(){}
	
	private static Singleton instance; 
	
	public static synchronized Singleton getInstance(){
		if(instance == null){
			instance = new Singleton();
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
			System.out.println("clear1>>>>"+System.currentTimeMillis());
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("clear2>>>>"+System.currentTimeMillis());
	}

	public void insert(){
			System.out.println("insert1>>>>"+System.currentTimeMillis());
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("insert2>>>>"+System.currentTimeMillis());
	}
	
}