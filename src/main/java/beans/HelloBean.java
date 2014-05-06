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

	private Person personAutocomplete;

	private List<Person> persons;

	@PostConstruct
	public void init() {
		person = new Person();
		person.setAddress(new Address());
		persons = personService.findAllPerson();
		personAutocomplete = null;
	}

	public void insertPerson(ActionEvent event) {
		person.setPerson(personAutocomplete);
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

	public List<Person> autocomplete(String value) {
		return personService.findPersonByName(value);
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

	public Person getPersonAutocomplete() {
		return personAutocomplete;
	}

	public void setPersonAutocomplete(Person personAutocomplete) {
		this.personAutocomplete = personAutocomplete;
	}

}
