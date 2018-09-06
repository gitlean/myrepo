package com.isoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;



//@EnableDiscoveryClient
//@ImportResource("classpath*:META-INF/spring/*_bean.xml")
@SpringBootApplication
public class MultiDataSourceApplication {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(MultiDataSourceApplication.class, args);

	}

}
