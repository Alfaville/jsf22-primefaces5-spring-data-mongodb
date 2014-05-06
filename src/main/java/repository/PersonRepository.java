package repository;

import java.util.List;

import model.Person;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends MongoRepository<Person, String> {

	public Person addPerson(Person person);

	public List<Person> listAllPerson();

	public List<Person> findPersonByName(String name);
	
	public void deletePerson(Person person);

	public Person updatePerson(Person person);

}
