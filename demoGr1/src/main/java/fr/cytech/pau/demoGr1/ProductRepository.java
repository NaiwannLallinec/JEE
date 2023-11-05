package fr.cytech.pau.demoGr1;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends CrudRepository<Product, Long> {

	@Query(value = "SELECT COULEUR FROM PRODUCT WHERE ID IN ( SELECT PRODUCT_ID FROM COMMANDE_LIGNE AS CL, COMMANDE AS C WHERE C.PERSON_ID = 1 AND C.ID = CL.COMMANDE_DES_LIGNES_ID ) GROUP BY COULEUR ORDER BY COUNT(COULEUR) DESC LIMIT 1", nativeQuery = true)
	String findMostCommonColor(@Param("personId") Long personId);

	@Query(value = "SELECT TYPE FROM PRODUCT P " +
	        "INNER JOIN COMMANDE_LIGNE CL ON P.ID = CL.PRODUCT_ID " +
	        "INNER JOIN COMMANDE C ON C.ID = CL.COMMANDE_DES_LIGNES_ID " +
	        "WHERE C.PERSON_ID = :personId " +
	        "GROUP BY TYPE " +
	        "ORDER BY COUNT(TYPE) DESC LIMIT 1", nativeQuery = true)
	Byte findMostCommonType(@Param("personId") Long personId);

	@Query(value = "SELECT TAILLE FROM PRODUCT P " +
	        "INNER JOIN COMMANDE_LIGNE CL ON P.ID = CL.PRODUCT_ID " +
	        "INNER JOIN COMMANDE C ON C.ID = CL.COMMANDE_DES_LIGNES_ID " +
	        "WHERE C.PERSON_ID = :personId " +
	        "GROUP BY TAILLE " +
	        "ORDER BY COUNT(TAILLE) DESC LIMIT 1", nativeQuery = true)
	Integer findMostCommonSize(@Param("personId") Long personId);

}