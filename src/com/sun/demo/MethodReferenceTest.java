package com.sun.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * 方法引用：方法引用本身也是一个lambda表达式，只不过是lambda表达式的简化写法。如果lambda表达式调用的是一个已知的方法，则可以直接简写成方法引用
 * @author Vivian
 *
 */
public class MethodReferenceTest {

	public static void main(String[] args) {
		List<String> names = new ArrayList<String>();
        
		names.add("Google");
		names.add("Runoob");
		names.add("Taobao");
		names.add("Baidu");
		names.add("Sina");
		
		//下面的这两行代码是等价的，如果lambda表达式调用一个已经存在的方法，则直接简写成方法引用，不需要写参数，只需要写方法名即可。
		names.forEach(a -> System.out.println(a));
		names.forEach(System.out::println);
		
		
		MyMethodInvoked in1 = (a,b) -> (a+b);
		
		//如下两种写法也是等同的，气宗in3使用了方法调用
		MyMethodInvoked in2 = (a,b) -> a.concat(b);
		MyMethodInvoked in3 = String::concat;
		
		System.out.println(testIn("hello", "zhangsan", in2));
		System.out.println(testIn("hello", "zhangsan", in3));
	}
	
	public static String testIn(String a,String b,MyMethodInvoked ins){
		return ins.concats(a, b);
	}

}

interface MyMethodInvoked{
	String concats(String a,String b);
}
