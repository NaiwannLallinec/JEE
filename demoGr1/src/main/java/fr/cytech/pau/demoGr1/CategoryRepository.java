package fr.cytech.pau.demoGr1;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
    Category findByCategoryType(Vetement categoryType);
}

