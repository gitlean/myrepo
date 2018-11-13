package com.xxx.threadlocal.demo;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Data data=new Data();
		for(int i=0;i<5;i++){
			new Thread(new MyThread(data)).start();
			
			
		}

	}

}
