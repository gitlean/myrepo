package com.concurrentSkipListMapPack;

import java.util.Map;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * http://ifeve.com/concurrent-collections-6/
 * @author john
 *
 */
public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//TreeMap的线程安全版
		ConcurrentSkipListMap<String, Contact> map;
		map = new ConcurrentSkipListMap<>();
		// 创建一个有25个Thread对象的数组，用来存储你将要执行的所有任务。
		Thread threads[] = new Thread[25];
		int counter = 0;

		// 创建和启动25个任务，对于每个任务指定一个大写字母作为ID。
		for (char i = 'A'; i < 'Z'; i++) {
			Task task = new Task(map, String.valueOf(i));
			threads[counter] = new Thread(task);
			threads[counter].start();
			counter++;
		}

		// 使用join()方法等待线程的结束。25个线程执行完以后，main线程才会继续执行
		for (int i = 0; i < 25; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

		// 使用firstEntry()方法获取map的第一个实体，并将它的数据写入到控制台。
		System.out.printf("Main: Size of the map: %d\n", map.size());
		Map.Entry<String, Contact> element;
		Contact contact;
		element = map.firstEntry();
		contact = element.getValue();
		System.out.printf("Main: First Entry: %s: %s\n", contact.getName(), contact.getPhone());

		
		// 使用lastEntry()方法获取map的最后一个实体，并将它的数据写入到控制台。
		element = map.lastEntry();
		contact = element.getValue();
		System.out.printf("Main: Last Entry: %s: %s\n", contact.
				getName(), contact.getPhone());

		
		// 使用subMap()方法获取map的子map，并将它们的数据写入到控制台。
		System.out.printf("Main: Submap from A1996 to B1002: \n");
		
		//特色的地方
		//subMap()方法返回map的部分元素的ConcurrentNavigableMap对象。在这个例子中，元素拥有A1996到B1002之间的key。在这种情况下，你可以使用pollFirst()方法来处理subMap()方法返回的这些元素。这个方法将返回并删除submap中的第一个Map.Entry对象
		ConcurrentNavigableMap<String, Contact> submap = map.
				subMap("A1996", "B1002");

		do {
			element = submap.pollFirstEntry();
			if (element != null) {
				contact = element.getValue();
				System.out.printf("%s: %s\n", contact.getName(), contact.
						getPhone());

			}
		} while (element != null);

		System.out.println("************************");
		//submap元素已被删除，所以下面遍历无结果
		do {
			element = submap.pollFirstEntry();
			if (element != null) {
				contact = element.getValue();
				System.out.printf("%s: %s\n", contact.getName(), contact.
						getPhone());

			}
		} while (element != null);
		System.out.println("************************");
		
		//submap实际上是map的一个部分引用，此时map中数据也已经被删除
		submap = map.subMap("A1996", "B1002");
		do {
			element = submap.pollFirstEntry();
			if (element != null) {
				contact = element.getValue();
				System.out.printf("%s: %s\n", contact.getName(), contact.
						getPhone());

			}
		} while (element != null);

		System.out.println("************************");
		
	}

}

/**
 * 不止这些...

ConcurrentSkipListMap类有其他有趣的方法，这些方法如下：

    headMap(K toKey)：K是参数化ConcurrentSkipListMap对象的Key值的类。返回此映射的部分视图，其键值小于 toKey。
    tailMap(K fromKey)：K是参数化ConcurrentSkipListMap对象的Key值的类。返回此映射的部分视图，其键大于等于 fromKey。
    putIfAbsent(K key, V Value)：如果key不存在map中，则这个方法插入指定的key和value。
    pollLastEntry()：这个方法返回并删除map中最后一个元素的Map.Entry对象。
    replace(K key, V Value)：如果这个key存在map中，则这个方法将指定key的value替换成新的value。
*/
