package com.cf.demo.socket;

public class User {
	String name;
	Integer age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public User(String name, Integer age){
		this.name = name;
		this.age = age;
	}
}
