package fr.cytech.pau.demoGr1;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "categories")
    private Set<Product> products;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
