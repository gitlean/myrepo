package com.isoft.demo1;

public class TestMain {
	public static void main(String[] args) {
		String token=JWTUtil.createJWT("123", "TOme", "subs", 6000000);
		System.out.println(token);
		
		JWTUtil.parseJWT(token);
	}
}
