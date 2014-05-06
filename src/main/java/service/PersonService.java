package service;

import java.util.List;

import model.Person;


public interface PersonService {
	
	public void addPerson(Person person);

	public List<Person> findAllPerson();

	public List<Person> findPersonByName(String name);
	
	public void dropPersonrCollection();
	
	public void deletePerson(Person person);
	
	public void updatePerson(Person person);
	
}
