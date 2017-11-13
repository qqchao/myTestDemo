package com.cf.demo.list.remove;

import java.util.ArrayList;
import java.util.List;

public class ListRemoveTest {
	public static void main(String[] args) {
		List<String> list = new ArrayList();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		list.add("6");
		list.add("7");
		list.add("8");
		list.add("9");
		
		while(list.size() > 0){
			System.out.println("----------");
			System.out.println(list.toString());
			System.out.println("do something-->>" + list.get(0));
		
			list.remove(0);
		}
	}
}
