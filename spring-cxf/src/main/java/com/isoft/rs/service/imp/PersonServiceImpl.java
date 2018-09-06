package com.isoft.rs.service.imp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.isoft.rs.entity.Person;
import com.isoft.rs.service.PersonService;


//@Produces(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_XML)
public class PersonServiceImpl implements PersonService {
	private static Map<String, Person> ps = new HashMap<String, Person>();
	static {
		Person p1 = new Person();
		p1.setId("1");
		p1.setName("zhangsan");
		p1.setDescription("hello");

		Person p2 = new Person();
		p2.setId("2");
		p2.setName("lisi");
		p2.setDescription("lisi hehe");

		ps.put(p1.getId(), p1);
		ps.put(p2.getId(), p2);
	}

	@Override
	public Person getPerson(String id) {
		return ps.get(id);
	}

	@Override
	public List<Person> getPersons() {
		return new ArrayList(ps.values());
	}
}
