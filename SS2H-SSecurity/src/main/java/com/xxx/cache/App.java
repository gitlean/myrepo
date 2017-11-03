package com.xxx.cache;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UtilTool u=UtilsCache.getUtil();
		if(null==u){
			u=new UtilTool();     //如果必须自己创建，可以用单例模式
			UtilsCache.setUtil(u);
		}
		u.dosth("America");
		
		UtilTool u2=UtilsCache.getUtil();
		u2.dosth("China");

	}

}
