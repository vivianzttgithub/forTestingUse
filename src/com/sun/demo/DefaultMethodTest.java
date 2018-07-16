package com.sun.demo;

/**
 * java8的默认方法
 * @author Vivian
 *
 */
public class DefaultMethodTest {

	public static void main(String[] args) {
		Vehicle vehicle = new Car();
		vehicle.print();

	}

}

/**
 * 接口里允许有静态方法，但是必须有实现，否则编译报错
 * @author Vivian
 *
 */
interface Vehicle{
	default void print(){
		System.out.println("我是一辆车！");
	}
	static void blows(){
		System.out.println("按喇叭！");
	}
}

interface FourWheeler{
	default void print(){
		System.out.println("我是一辆四轮车！");
	}
}

/**
 * 如果实现的多个接口有相同的default方法，则必须要重写，否则编译报错
 * @author Vivian
 *
 */
class Car implements Vehicle,FourWheeler{
	public void print(){
		Vehicle.super.print();
		Vehicle.blows();
		FourWheeler.super.print();
		System.out.println("我是一辆四轮汽车！");
	}
	
}
