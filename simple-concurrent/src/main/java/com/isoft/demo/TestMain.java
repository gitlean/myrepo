package com.isoft.demo;
//http://blog.csdn.net/kjfcpua/article/details/7288900
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.sql.ConnectionPoolDataSource;

import com.isoft.beans.User;
/**
 *  java.util 包中的集合类都返回 fail-fast 迭代器，这意味着它们假设线程在集合内容中进行迭代时，集合不会更改它的内容。如果 fail-fast 迭代器检测到在迭代过程中进行了更改操作，那么它会抛出 ConcurrentModificationException，这是不可控异常。
 *  @author john
 *
 */
public class TestMain {

	public static void main(String[] args) {
		try{
			List<User> list=new ArrayList<User>();
			
			//Collections.synchronizedList(list);     // 这种上同步  只能对多线程起作用     此处不起作用，因为此处是在同一线程内修改了list
			//进一步说，当使用 fail-fast iterator 对 Collection 或 Map 进行迭代操作过程中尝试直接修改 Collection / Map 的内容时，即使是在单线程下运行,java.util.ConcurrentModificationException 异常也将被抛出。
			

			
			
			//List<User> list=new CopyOnWriteArrayList<User>();       //方法1
			
			
			User user1=new User("Tome","2000/10/01");
			list.add(user1);
			
			User user2=new User("Jerry","2001/11/01");
			list.add(user2);
			
			User user3=new User("Ketty","2005/11/01");
			list.add(user3);
			
			
	        Iterator<User> iter=list.iterator();
	        while(iter.hasNext()){
	        	User user=iter.next();
	        	System.out.println(user.getName()+"\t"+user.getBirth());
	            if(user.getName().equalsIgnoreCase("Tome")){
	            	System.out.println("Got one");
	            	
	            	
	            	//iter.remove();        //方法2          当使用ArrayList  加此句也可以解决
	            	list.remove(user);
	            	
	            }
	        }
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		

	}

}
