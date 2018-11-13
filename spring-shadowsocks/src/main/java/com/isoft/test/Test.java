package com.isoft.test;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="jdj()";
		System.out.println(str.replaceAll("\\(", "（"));
		System.out.println(str.replaceAll("\\)", "）"));
		System.out.println(str);

	}

}
