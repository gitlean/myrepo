package com.isoft.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * https://www.cnblogs.com/zhujiabin/p/6164826.html
 * @author john
 * @date 2018年11月6日
 * @time 下午5:17:40
 * @describe:
 */
public class MapSortDemo {

	public static void main(String[] args) {

		Map<String, String> map = new TreeMap<String, String>();

		map.put("KFC", "kfc");
		map.put("WNBA", "wnba");
		map.put("NBA", "nba");
		map.put("CBA", "cba");

		// Map<String, String> resultMap = sortMapByKey(map); // 按Key进行排序
		Map<String, String> resultMap = sortMapByValue(map); //按Value进行排序

		for (Map.Entry<String, String> entry : resultMap.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
		
		
	}

	
	/**
	 * 使用 Map按value进行排序
	 * 
	 * @param map
	 * @return
	 */
	public static Map<String, String> sortMapByValue(Map<String, String> oriMap) {
		if (oriMap == null || oriMap.isEmpty()) {
			return null;
		}
		
		/**
		 * 关于LinkedHashMap更多用法见
		 * https://blog.csdn.net/justloveyou_/article/details/71713781
		 */
		Map<String, String> sortedMap = new LinkedHashMap<String, String>();
		
		
		List<Map.Entry<String, String>> entryList = new ArrayList<Map.Entry<String, String>>(oriMap.entrySet());
		Collections.sort(entryList, new MapValueComparator());

		Iterator<Map.Entry<String, String>> iter = entryList.iterator();
		Map.Entry<String, String> tmpEntry = null;
		while (iter.hasNext()) {
			tmpEntry = iter.next();
			sortedMap.put(tmpEntry.getKey(), tmpEntry.getValue());
		}
		return sortedMap;
	}

	/**
	 * 使用 Map按key进行排序
	 * 
	 * @param map
	 * @return
	 */
	public static Map<String, String> sortMapByKey(Map<String, String> map) {
		if (map == null || map.isEmpty()) {
			return null;
		}

		Map<String, String> sortMap = new TreeMap<String, String>(new MapKeyComparator());

		sortMap.putAll(map);

		return sortMap;
	}

}

// 比较器类

class MapKeyComparator implements Comparator<String> {

	@Override
	public int compare(String str1, String str2) {

		return str1.compareTo(str2);
	}
}

class MapValueComparator implements Comparator<Map.Entry<String, String>> {

	@Override
	public int compare(Entry<String, String> me1, Entry<String, String> me2) {

		return me1.getValue().compareTo(me2.getValue());
	}
}
