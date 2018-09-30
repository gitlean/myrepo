package com.concurrentSkipListMapPack;

import java.util.concurrent.ConcurrentSkipListMap;

public class Contact {
	private String name;
	private String phone;

	public Contact(String name, String phone) {
		this.name = name;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

}

class Task implements Runnable {
	private String id;
	private ConcurrentSkipListMap<String, Contact> map;

	public Task(ConcurrentSkipListMap<String, Contact> map, String id) {
		this.id = id;
		this.map = map;
	}

	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			Contact contact = new Contact(id, String.valueOf(i + 1000));
			map.put(id + contact.getPhone(), contact);
		}
	}

}
