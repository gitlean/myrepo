package com.xxx.cache;

/**
 * Cache的使用
 * 将常用对象 放入 cache中
 * 
 * 对于那些 没有使用单例模式创建的对象，可以使用此种方法
 * 
 * @author john
 * @date   2017年11月3日
 * @description
 */
public class UtilsCache {
	private static ThreadLocal<UtilTool> CURRENT_UTILTOOL=new ThreadLocal<UtilTool>();
	
	public static void setUtil(UtilTool u){
		if(null!=u){
			CURRENT_UTILTOOL.set(u);
		}
	}

	public static UtilTool getUtil(){
		return CURRENT_UTILTOOL.get();
	}
}
