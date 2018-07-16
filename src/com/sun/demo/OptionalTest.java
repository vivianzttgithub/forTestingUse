package com.sun.demo;

import java.util.Optional;

public class OptionalTest {

	public static void main(String[] args) {
		Integer value1 = null;
		Integer value2 = 2;
		
		Optional op1 = Optional.ofNullable(value1);
		Optional op2 = Optional.of(value2);
		System.out.println(sum(op1,op2));
		
	}
	
	public static Integer sum(Optional<Integer> a,Optional<Integer> b){
		//判断值是否存在
		System.out.println("第一个值是否存在:"+a.isPresent());
		System.out.println("第二个值是否存在:"+b.isPresent());
		
		//如果存在值（null不算），返回值。否则返回1。
		Integer a1 = a.orElse(1);
		
		//从Optional里取值
		Integer b1 = b.get();
		
		return a1+b1;
	}

}
