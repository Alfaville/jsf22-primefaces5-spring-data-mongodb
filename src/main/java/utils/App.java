package utils;

import model.Address;
import model.Person;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.PersonService;

public class App {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		PersonService personService = context.getBean(PersonService.class);
		
		Person p = new Person();
		p.setName("Felipe");
		p.setAge(24);

		Address address = new Address();
		address.setDescription("Todos os Santos");
		address.setCity("Teresina");
		address.setState("Piauí");
		
		p.setAddress(address);

		personService.addPerson(p);
	
		for (Person item : personService.findAllPerson()) {
			System.out.println("{\n");
			System.out.println(" _id :" + item.getId() + ", \n");
			System.out.println(" name :" + item.getName() + ", \n");
			System.out.println(" age :" + item.getAge() + ", \n");
			System.out.println(" address: { \n");
			System.out.println("    address :" + item.getAddress().getDescription() + ", \n");
			System.out.println("    city :" + item.getAddress().getCity() + ", \n");
			System.out.println("    state :" + item.getAddress().getState() + ", \n");
			System.out.println("  } \n");
			System.out.println("}");
		}
		personService.dropPersonrCollection();
	}

}
