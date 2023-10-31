package fr.cytech.pau.demoGr1;

import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {
	Person findByFirstNameAndLastName(String firstName, String lastName);
}
