package fr.cytech.pau.demoGr1;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends CrudRepository<Product, Long> {

	@Query(value = "SELECT COULEUR FROM PRODUCT WHERE ID IN ( SELECT PRODUCT_ID FROM COMMANDE_LIGNE , COMMANDE  WHERE COMMANDE.PERSON_ID = 1 AND COMMANDE.ID = COMMANDE_LIGNE.COMMANDE_DES_LIGNES_ID ) GROUP BY COULEUR ORDER BY COUNT(COULEUR) DESC LIMIT 1", nativeQuery = true)
	String findMostCommonColor(@Param("personId") Long personId);

	@Query(value = "SELECT TYPE FROM PRODUCT WHERE ID IN ( SELECT PRODUCT_ID FROM COMMANDE_LIGNE , COMMANDE  WHERE COMMANDE.PERSON_ID = 1 AND COMMANDE.ID = COMMANDE_LIGNE.COMMANDE_DES_LIGNES_ID ) GROUP BY TYPE ORDER BY COUNT(TYPE) DESC LIMIT 1", nativeQuery = true)
	Byte findMostCommonType(@Param("personId") Long personId);

	@Query(value = "SELECT TAILLE FROM PRODUCT WHERE ID IN ( SELECT PRODUCT_ID FROM COMMANDE_LIGNE , COMMANDE  WHERE COMMANDE.PERSON_ID = 1 AND COMMANDE.ID = COMMANDE_LIGNE.COMMANDE_DES_LIGNES_ID ) GROUP BY TAILLE ORDER BY COUNT(TAILLE) DESC LIMIT 1", nativeQuery = true)
	Integer findMostCommonSize(@Param("personId") Long personId);

}