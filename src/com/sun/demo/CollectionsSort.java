package com.sun.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 测试java7与java8语法下List排序的不同代码风格
 * @author Vivian
 *
 */
public class CollectionsSort {

	public static void main(String[] args) {
		List<String> aList = new ArrayList<String>();
		aList.add("zade");
		aList.add("deq");
		aList.add("aerf");
		aList.add("bec");
		
		List<String> bList = new ArrayList<String>();
		bList.add("zade");
		bList.add("deq");
		bList.add("aerf");
		bList.add("bec");
		
		Collections.sort(aList, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return s1.compareTo(s2);
			}
			
		});
		System.out.println("排序前List:"+aList);
		System.out.println("使用java7排序后List:"+aList);
		
		System.out.println("================================");
		
		
		Collections.sort(bList, (s1,s2)->s1.compareTo(s2));
		System.out.println("排序前List:"+bList);
		System.out.println("使用java8排序后List:"+bList);
	}

}
