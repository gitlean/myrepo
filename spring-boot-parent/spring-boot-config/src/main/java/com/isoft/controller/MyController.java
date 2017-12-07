package com.isoft.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isoft.services.FilmService;
import com.isoft.vo.Film;

@RestController
public class MyController {

	private static Logger logger = LoggerFactory.getLogger(MyController.class);

	@Autowired
	private FilmService service;

	@GetMapping(value = "/query")
	public List<Film> query() {
		//List<Film> list = new ArrayList<Film>();
		
		return service.query();

	}
}
