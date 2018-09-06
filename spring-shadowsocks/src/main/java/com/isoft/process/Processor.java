package com.isoft.process;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.isoft.crawler.HttpVisitor;
import com.isoft.file.WriteFile;
import com.isoft.vo.SSocks;

public class Processor {

	private static final String URL = "https://free-ss.site/ss.php";
	private static Map<String, SSocks> map = new HashMap<String, SSocks>();

	public static void execute() {
		int count = 0;
		String dataHtml = null;
		for (count = 0; count <2; count++) {
			dataHtml = HttpVisitor.getHtmlbyGet(URL);
			if (!StringUtils.isEmpty(dataHtml)) {
				JSONObject json = JSONObject.parseObject(dataHtml);
				if (json.containsKey("data")) {
					JSONArray jarr = json.getJSONArray("data");
					
					for (int i = 0; i < jarr.size(); i++) {
						JSONArray jt = (JSONArray) jarr.get(i);
						executeSingleRecord(jt);

					}
				}
			}

//			try {
//				Thread.currentThread().sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}

		
		List<SSocks> list = new ArrayList<SSocks>();
		Iterator iter = map.entrySet().iterator();
		while (iter.hasNext()) {
			Entry<String, SSocks> entry = (Entry<String, SSocks>) iter.next();
			list.add(entry.getValue());
		}

		Collections.sort(list, new MyComparator());
		
		WriteFile.write(list);

	}

	public static void executeSingleRecord(JSONArray jt) {
		SSocks ss = new SSocks();
		ss.setScore((Integer) jt.get(0));
		ss.setIp((String) jt.get(1));
		ss.setPort((String) jt.get(2));
		ss.setPwd((String) jt.get(3));
		ss.setCodeType((String) jt.get(4));
		ss.setTimestamp((String) jt.get(5));
		ss.setNation((String) jt.get(6));
		// System.out.println(ss);
		map.put(ss.getIp() + ss.getPort(), ss);

	}

	public static void main(String[] args) {
		execute();
		System.out.println("<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>");
	}

}

class MyComparator implements Comparator {

	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		SSocks s1 = (SSocks) o1;
		SSocks s2 = (SSocks) o2;
		return s1.getScore() >= s2.getScore() ? -1 : 1;
	}

}
