package com.sun.demo;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * 函数式接口：有且仅有一个抽象方法，但是可以有多个非抽象方法的接口
 * 传统的接口：所有的变量默认都是public static final修饰，所有的方法都是默认public abstract修饰，
 * 但是在java8中，接口里方法可以用static修饰，且必须要有实现。也可以定义default方法。
 * 
 * java.util.function包含了很多类，用来支持java8的函数式编程
 * @author Vivian
 *
 */
public class FunctionalInterfaceTest {

	public static void main(String[] args) {
		List<Integer> aList = Arrays.asList(1,2,5,3,8,9);
		System.out.println("输出所有数据：");
		eval(aList, n -> true);
	
		System.out.println("输出所有偶数：");
		eval(aList,n -> n%2==0);
		
		System.out.println("输出所有大于3的数：");
		eval(aList,n -> n>3);
		
	}
	
	public static void eval(List<Integer> list,Predicate<Integer> predicate){
		for(Integer n:list){
			if(predicate.test(n)){
				System.out.println(n+" ");
			}
		}
	}

}
