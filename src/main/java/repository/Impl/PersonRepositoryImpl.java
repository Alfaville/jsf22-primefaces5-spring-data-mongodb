package repository.Impl;

import java.util.List;
import java.util.UUID;

import javax.inject.Inject;

import model.Person;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.support.MappingMongoEntityInformation;
import org.springframework.data.mongodb.repository.support.SimpleMongoRepository;
import org.springframework.stereotype.Repository;

import repository.PersonRepository;
import utils.QueryUtils;

@Repository
public class PersonRepositoryImpl extends SimpleMongoRepository<Person, String>
		implements PersonRepository {

	@Inject
	private MongoTemplate mongoTemplate;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Inject
	public PersonRepositoryImpl(MongoTemplate mongoTemplate) {
		super(new MappingMongoEntityInformation(mongoTemplate.getConverter()
				.getMappingContext().getPersistentEntity(Person.class)),
				mongoTemplate);
	}

	public Person addPerson(Person person) {
		person.setId(UUID.randomUUID().toString());
		return save(person);
	}

	public List<Person> listAllPerson() {
		return findAll();
	}

	public void deletePerson(Person person) {
		delete(person);
	}

	public Person updatePerson(Person person) {
		return save(person);
	}

	@Override
	public List<Person> findPersonByName(String name) {
		if (name != null && !name.trim().equals("")) {
			Query query = QueryUtils.like("name", name);
			return mongoTemplate.find(query, Person.class);
		}
		return findAll();
	}

}
