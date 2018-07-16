package com.sun.demo;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.UUID;

public class Base64Test {

	public static void main(String[] args) {
		//使用基本编码
		String encStr;
		try {
			encStr = Base64.getEncoder().encodeToString("java8encode".getBytes("utf-8"));
			System.out.println("编码后字符串为:"+encStr);
			
			//解码
			byte[] bytes = Base64.getDecoder().decode(encStr);
			System.out.println("原始字符串:"+new String(bytes,"utf-8"));
			
			encStr = Base64.getUrlEncoder().encodeToString("order/getInfo".getBytes("utf-8"));
			System.out.println("Base64编码（URL）:"+encStr);
			
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<10;i++){
				String s = UUID.randomUUID().toString();
				System.out.println(s);
				sb.append(s);
			}
			
			byte[] mimeBytes = sb.toString().getBytes("utf-8");
			encStr = Base64.getMimeEncoder().encodeToString(mimeBytes);
			System.out.println("Base64编码（mime）:"+encStr);
			
			encStr = new String(Base64.getMimeDecoder().decode(encStr),"utf-8");
			System.out.println("Base64解码（mime）："+encStr);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
