package com.isoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @SpringBootApplication注解修饰，
 * 这包含了@ComponentScan、@Configuration和@EnableAutoConfiguration注解
 * 
 * @author john
 * @date   2017年12月8日
 * @description
 */
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
