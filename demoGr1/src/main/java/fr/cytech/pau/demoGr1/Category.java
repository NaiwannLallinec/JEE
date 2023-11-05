package fr.cytech.pau.demoGr1;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Vetement categoryType; 

    @ManyToMany(mappedBy = "categories")
    private Set<Product> products;
    
    public Vetement getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(Vetement categoryType) {
        this.categoryType = categoryType;
    }

    public Set<Product> getProducts() {
        return products;
    }
	
	public Long getId() {
		return id;
	}
	 
	public void addProduct(Product product) {
        if (products == null) {
            products = new HashSet<>();
        }
        products.add(product);
    }

	
	 public static void create(String[] args) {
	        EntityManager entityManager = Persistence.createEntityManagerFactory("DatePersistent").createEntityManager();

	            for (Vetement vetement : Vetement.values()) {
	                Category category = new Category();
	                category.setName(vetement.getDescription());
	                entityManager.getTransaction().begin();
	                entityManager.persist(category);
	                entityManager.getTransaction().commit();
	            }
	            entityManager.close();
	 }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name=name;
	}

	

}
