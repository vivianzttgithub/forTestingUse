package com.sun.demo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.Date;

public class TimeTest {

	public static void main(String[] args) {
		LocalDateTime currentTime = LocalDateTime.now();
		//旧的当前时间打印不够友好:System.out.println(new Date());
		System.out.println("当前日期时间:"+currentTime);
		
		LocalDate currentDate = currentTime.toLocalDate();
		System.out.println("当前日期："+currentDate);
		
		Month month = currentTime.getMonth();
		int day = currentTime.getDayOfMonth();
		int seconds = currentTime.getSecond();
		
		System.out.println("月:"+month+" 日:"+day+" 秒："+seconds);
		
		LocalDateTime newTime = currentTime.withDayOfMonth(10).withYear(2012);
		System.out.println("新的日期:"+newTime);
		
		LocalDate date3 = LocalDate.of(2019, 12, 13);
		System.out.println("date3:"+date3);
		
		//没有给定的时间字段就不显示，不会给默认值
		LocalTime time3 = LocalTime.of(12, 49);
		System.out.println("time3:"+time3);
		
		//毫秒固定以.开始，位数不限，均可识别。时分秒均以2位表示，否则不可识别。
		LocalTime time4 = LocalTime.parse("09:12:23.1202");
		System.out.println("time4:"+time4);
	}

}
