package com.sun.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class StreamTest {

	public static void main(String[] args) {
		System.out.println("=============java 7==============");
		List<String> aList = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
		System.out.println("列表"+aList);
		
		long count = getCountEmptyStringUsingJava7(aList);
		System.out.println("空字符串数量:"+count);
		
		count = getCountLength3UsingJava7(aList);
		System.out.println("字符串长度为3的字符串数量:"+count);
		
		//删除空字符串并返回新的字符串列表
		List<String> filtered = deleteEmptyStringsUsingJava7(aList);
		System.out.println("筛选后的列表为："+filtered);
		
		//删除空字符串并用逗号连接返回字符串
		String mergerStrs = getMergedStringUsingJava7(aList,",");
		System.out.println("合并字符串:"+mergerStrs);
		
		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
		//获取列表元素的平方数
		List<Integer> squareNumbers = getSquares(numbers);
		System.out.println("平方数列表："+squareNumbers);
		
		List<Integer> integers = Arrays.asList(1,2,13,4,15,6,17,8,19);
		System.out.println("列表:"+integers);
		System.out.println("列表中最大的值是:"+getMax(integers));
		System.out.println("列表中最小的值是:"+getMin(integers));
		System.out.println("列表中所有值得和是:"+getSum(integers));
		System.out.println("列表平均值是:"+getAvage(integers));
		System.out.println("随机值:");
		//打印10个随机数
		Random random = new Random();
		for(int i=0;i<=10;i++){
			System.out.print(random.nextInt()+"  ");
		}
		System.out.println();
		System.out.println("=============java 7==============");
		System.out.println("=============java 8==============");
		System.out.println("列表元素："+aList);
		//Stream.count 返回流的元素数量
		count = aList.stream().filter(n -> n.isEmpty()).count();
		System.out.println("空字符串数量:"+count);
		
		count = aList.stream().filter(n -> n.length()==3).count();
		System.out.println("字符串长度为3的字符串数量:"+count);
		
		//Stream.collect 
		filtered = aList.stream().filter(n -> !n.isEmpty()).collect(Collectors.toList());
		System.out.println("筛选后的列表为："+filtered);
		
		mergerStrs = aList.stream().filter(n -> !n.isEmpty()).collect(Collectors.joining(","));
		System.out.println("合并字符串:"+mergerStrs);
		
		squareNumbers = numbers.stream().map(i -> i*i).distinct().collect(Collectors.toList());
		System.out.println("平方数列表："+squareNumbers);
		
		System.out.println("列表:"+integers);
		IntSummaryStatistics stats = integers.stream().mapToInt((x) -> x).summaryStatistics();
		
		System.out.println("列表中最大的值是:"+stats.getMax());
		System.out.println("列表中最小的值是:"+stats.getMin());
		System.out.println("列表中所有值得和是:"+stats.getSum());
		System.out.println("列表平均值是:"+stats.getAverage());
		System.out.println("随机数：");
		
		random.ints().limit(10).sorted().forEach(System.out::println);
		
		
		System.out.println("=============java 8==============");
		
	}
	
	public static int getAvage(List<Integer> integers){
		return getSum(integers)/integers.size();
	}
	
	public static int getSum(List<Integer> integers){
		int total = 0;
		for(Integer ints:integers){
			total+=ints;
		}
		return total;
	}
	
	public static int getMin(List<Integer> integers){
		int mins = integers.get(0);
		for(Integer ints:integers){
			if(mins > ints.intValue()){
				mins = ints.intValue();
			}
		}
		return mins;
	}
	
	public static int getMax(List<Integer> integers){
		int maxs = integers.get(0);
		for(Integer ints:integers){
			if(maxs < ints.intValue()){
				maxs = ints.intValue();
			}
		}
		return maxs;
	}
	
	public static List<Integer> getSquares(List<Integer> numbers){
		List<Integer> returnList = new ArrayList<Integer>();
		for(Integer ints:numbers){
			int sqs = ints.intValue()*ints.intValue();
			if(!returnList.contains(sqs)){
				returnList.add(sqs);
			}
		}
		return returnList;
	}
	
	public static String getMergedStringUsingJava7(List<String> aList,String dou){
		StringBuffer sb = new StringBuffer();
		for(String str:aList){
			if(!str.isEmpty()){
				sb.append(str+dou);
			}
		}
		return sb.toString().substring(0, sb.toString().length()-1);
	}
	
	public static long getCountEmptyStringUsingJava7(List<String> aList){
		long returnLong = 0l;
		for(String str:aList){
			if(str.isEmpty()){
				returnLong+=1;
			}
		}
		return returnLong;
	}
	
	public static long getCountLength3UsingJava7(List<String> aList){
		long returnLong = 0l;
		for(String str:aList){
			if(str.length()==3){
				returnLong+=1;
			}
		}
		return returnLong;
	}
	
	public static List<String> deleteEmptyStringsUsingJava7(List<String> aList){
		List<String> returnList = new ArrayList<String>();
		for(String str:aList){
			if(!str.isEmpty()){
				returnList.add(str);
			}
		}
		return returnList;
	}

}
