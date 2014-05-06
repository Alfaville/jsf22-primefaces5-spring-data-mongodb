package utils;

import model.Person;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.PersonService;

public class App {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"spring-application-context.xml");
		PersonService pr = context.getBean(PersonService.class);
		
		Person p = new Person();
		p.setName("Felipe");
		Person p2 = new Person();
		p2.setName("Alfaville");

		pr.addPerson(p);
		pr.addPerson(p2);
		
		for (Person item : pr.findAllPerson()) {
			System.out.println( item.getName() );
		}
		pr.dropPersonrCollection();
	}

}
