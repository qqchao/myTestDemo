package com.cf.demo.list.remove;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestRemove {

	public static void main(String[] args) {
        String[] s={"1","2","2","3","4","5","6"};
        List<String> listA = Arrays.asList(s);
        List<String> listB = new ArrayList<>(listA);
        for(int i=0;i<listB.size();i++){
            if (listB.get(i).equals("2")){
                listB.remove(i);
//                i--;
            }
        }
        for(String temp:listB){
            System.out.println(temp);
        }
    }
}
