package footmark.springdata.jpa.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import footmark.springdata.jpa.domain.UserInfo;
import footmark.springdata.jpa.service.UserService;

public class MainApp {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-demo-cfg.xml");
		UserService userService = ctx.getBean("userService", UserService.class);
		UserInfo user = new UserInfo();
		user.setUsername("Tom");
		userService.save(user);
	}
}
