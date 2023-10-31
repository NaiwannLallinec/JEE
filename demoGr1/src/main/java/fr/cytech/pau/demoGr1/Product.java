package fr.cytech.pau.demoGr1;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "PRODUCT")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Vetement type;
    private String couleur;
    private int taille;
    private int stock;

    @OneToOne
    @JoinColumn(name = "product_rating_id")
    private ProductRating productRating;

    @ManyToMany
    @JoinTable(
        name = "product_category",
        joinColumns = @JoinColumn(name = "product_id"),
        inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> categories;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Vetement getType() {
		return type;
	}

	public void setType(Vetement type) {
		this.type = type;
	}

}
