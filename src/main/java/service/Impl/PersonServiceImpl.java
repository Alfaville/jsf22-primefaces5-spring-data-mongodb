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
	private PersonRepository dao;

	public void addPerson(Person person) {
		dao.addPerson(person);
	}

	public List<Person> findAllPerson() {
		return dao.findAll();
	}

	public void dropPersonrCollection() {
		dao.deleteAll();
	}

}
