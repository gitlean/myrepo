package cn.outofmemory.spring_aop_aspect;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		PersonService personService = appContext.getBean(PersonService.class);
		String personName = "Jim";
		//personService.addPerson(personName);
		personService.deletePerson(personName);
		//personService.editPerson(personName);
		((ClassPathXmlApplicationContext) appContext).close();
	}
}
