package fr.cytech.pau.demoGr1;

import org.springframework.data.repository.CrudRepository;

public interface PaiementRepository extends CrudRepository<Product, Long> {

	void save(Paiement paiement);
}

