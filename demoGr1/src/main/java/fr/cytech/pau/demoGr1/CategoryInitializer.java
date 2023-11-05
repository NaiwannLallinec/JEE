package fr.cytech.pau.demoGr1;

import java.util.Arrays;

import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;

@Component
public class CategoryInitializer {

	private final CategoryRepository categoryRepository;

	public CategoryInitializer(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@PostConstruct
	public void initializeCategories() {
		Arrays.stream(Vetement.values()).forEach(vetement -> {
			Category existingCategory = categoryRepository.findByCategoryType(vetement);
			if (existingCategory == null) {
				Category category = new Category();
				category.setName(vetement.getDescription());
				category.setCategoryType(vetement);
				categoryRepository.save(category);
			}
		});
	}
}
