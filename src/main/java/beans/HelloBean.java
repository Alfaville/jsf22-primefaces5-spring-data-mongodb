package beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import model.Address;
import model.Person;
import service.PersonService;

@Named
@ViewScoped
public class HelloBean {

	@Inject
	private PersonService personService;

	private Person person;
	
	private List<Person> persons;

	@PostConstruct
	public void init() {
		person = new Person();
		person.setAddress(new Address());
		persons = personService.findAllPerson();
	}

	public void insertPerson(ActionEvent event) {
		personService.addPerson(person);
		init();
	}

	public void deletePerson(ActionEvent event) {
		personService.dropPersonrCollection();
		init();
	}

	public String delete(Person item) {
		personService.deletePerson(item);
		persons = personService.findAllPerson();
		return null;
	}

	public String update(Person item) {
		persons.remove(item);
		personService.deletePerson(item);
		person = item;
		return null;
	}

	public List<Person> getHello() {
		return persons;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

}
