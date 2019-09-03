package com.isoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
*@author john
*@createTime 2019年9月2日 下午12:30:59
*@describe 
*/
@SpringBootApplication
public class Application {
	public static void main(String[] args) throws Exception {
		SpringApplication application = new SpringApplication(Application.class);
		application.run(args);
	}
}
