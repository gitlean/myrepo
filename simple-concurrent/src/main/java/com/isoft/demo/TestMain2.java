package com.isoft.demo;

/**
 * 
 * 
 * 为什么我们想要新的线程安全的List类？为什么Vector还不够？
 * 最简单的答案是与迭代和并发修改之间的交互有关。使用 Vector 或使用同步的 List 封装器，
 * 返回的迭代器是 fail-fast 的，这意味着如果在迭代过程中任何其他线程修改 List，迭代可能失败。
 * 

 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

import com.isoft.beans.User;

public class TestMain2 {

	public static void main(String[] args) {
		try{

			Vector<User> v=new Vector<User>();
			List<User> list=new CopyOnWriteArrayList<User>();   
			
			
			User user1=new User("Tome","2000/10/01");
			list.add(user1);
			v.add(user1);
			
			User user2=new User("Jerry","2001/11/01");
			list.add(user2);
			v.add(user2);
			
			User user3=new User("Ketty","2005/11/01");
			list.add(user3);
			v.add(user3);
			
			
			//弱一致的（weakly consistent）迭代器
			//对于这些类，如果元素自从迭代开始已经删除，且尚未由 next() 方法返回，那么它将不返回到调用者。如果元素自迭代开始已经添加，那么它可能返回调用者，也可能不返回。在一次迭代中，无论如何更改底层集合，元素不会被返回两次。
	        Iterator<User> iter=list.iterator();
	        while(iter.hasNext()){
	        	User user=iter.next();
	        	System.out.println(user.getName()+"\t"+user.getBirth());
	            if(user.getName().equalsIgnoreCase("Tome")){
	            	System.out.println("Got one");
	            	list.remove(user);
	            	
	            }
	        }
	        
	        System.out.println("*********************************");
	        
	        Iterator<User> iterv=v.iterator();
	        while(iterv.hasNext()){
	        	User user=iterv.next();
	        	System.out.println(user.getName()+"\t"+user.getBirth());
	            if(user.getName().equalsIgnoreCase("Tome")){
	            	System.out.println("Got one");
	            	v.remove(user);
	            	
	            }
	        }
	        
	        
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		

	}

}
