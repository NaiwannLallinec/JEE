package fr.cytech.pau.demoGr1;

import org.springframework.data.repository.CrudRepository;

public interface CommandeRepository extends CrudRepository<Commande, Long> {
	Commande findByPerson(Person person);
}
