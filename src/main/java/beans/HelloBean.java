package beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import model.Person;
import service.PersonService;

@Named
@ViewScoped
public class HelloBean {

	@Inject
	private PersonService dao;

	private Person person;

	@PostConstruct
	public void init() {
		person = new Person();
	}

	public void insertPerson(ActionEvent event) {
		dao.addPerson(person);
		init();
	}

	public void deletePerson(ActionEvent event) {
		dao.dropPersonrCollection();
	}

	public List<Person> getHello() {
		return dao.findAllPerson();
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	public String getTeste() {
		return "oi";
	}

}
