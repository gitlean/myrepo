package com.isoft.rs.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.isoft.rs.entity.Person;


public interface PersonService {
	@GET
	@Path("/persons")
	public List<Person> getPersons();

	@GET
	@Path("/persons/{id}")
	public Person getPerson(@PathParam("id") String id);
}
