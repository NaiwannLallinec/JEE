package fr.cytech.pau.demoGr1;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LigneCommandeRepository extends CrudRepository<CommandeLigne, Long> {
	List<CommandeLigne> findByCommandeDesLignes(Commande commandeDesLignes);

	List<CommandeLigne> findByCommandeDesLignesAndProduct(Commande commande, Product product);
}