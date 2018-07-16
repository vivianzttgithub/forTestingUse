package com.sun.demo;

/**
 * lambda表达式免去了使用匿名类的麻烦
 * 主要用来定义行内执行的方法类型接口
 * @author Vivian
 *
 */
public class LambdaTest {

	public static void main(String[] args) {
		LambdaTest tester = new LambdaTest();
		
		//一个参数无需定义圆括号，多个参数一定要参数
		MathOperation additions = (int a,int b) -> a+b; //有类型申明
		MathOperation minusition = (a,b) -> a-b; //无类型申明
		MathOperation multisition = (a,b) -> {return a*b;};//有return 则必须加大括号
		MathOperation devision = (a,b)->a/b;//没有大括号，没有return，没有申明
		
		GreetingService hello = a -> System.out.println("Hello,"+a); //直接写表达式代表有返回值，如果没有返回值，记得打印
		GreetingService welcome = b -> System.out.println("Welcome,"+b);
		
		//lambda表达式也被称为闭包。允许把一个函数当做参数传递到方法中，如下
		//MathOperation本来只是一个接口，main方法里定义了四个实现函数，然后就把该函数当做参数传递到operate方法里。
		System.out.println(tester.operate(3, 2, additions));
		System.out.println(tester.operate(3, 2, minusition));
		System.out.println(tester.operate(3, 2, multisition));
		System.out.println(tester.operate(3, 2, devision));
		
		hello.sayMessage("zhangsan");
		welcome.sayMessage("lisi");
		
		//函数类型接口
		Cars car1 = a -> System.out.println(a+" wangwang");
	}
	
	public int operate(int a,int b,MathOperation ma){
		return ma.operation(a, b);
	}
}

/**
 * 定义一个数学操作函数
 * @author Vivian
 *
 */
interface MathOperation{
	int operation(int a,int b);
}

interface Cars{
	void types(String brand);
	static int test(int a,int b){
		return a+b;
	}
	static String blow(String message){
		return "Hello,"+message;
	}
}

/**
 * 定义一个祝福函数，打印
 * @author Vivian
 *
 */
interface GreetingService{
	void sayMessage(String message);
}
