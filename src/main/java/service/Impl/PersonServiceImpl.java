package service.Impl;

import java.util.List;

import javax.inject.Inject;

import model.Person;

import org.springframework.stereotype.Service;

import repository.PersonRepository;
import service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

	@Inject
	private PersonRepository personRepository;

	public void addPerson(Person person) {		
		personRepository.addPerson(person);
	}

	public List<Person> findAllPerson() {
		return personRepository.findAll();
	}

	public void dropPersonrCollection() {
		personRepository.deleteAll();
	}

	@Override
	public void deletePerson(Person person) {
		personRepository.delete(person);
	}

	@Override
	public void updatePerson(Person person) {
		personRepository.save(person);
	}

	@Override
	public List<Person> findPersonByName(String name) {
		return personRepository.findPersonByName(name);
	}

}
