package fr.cytech.pau.demoGr1;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "PRODUCT")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Vetement type;
    private String couleur;
    private double prix;
    private int taille;
    private int stock;
    private String description;
    private String image;
    
    
    @OneToOne(mappedBy="product")
    private CommandeLigne ligneCommandee;

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
    
    public void addCategory(Category category) {
		if (categories == null) {
			categories = new HashSet<>();
		}
		categories.add(category);
		category.addProduct(this);
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Vetement getType() {
		return type;
	}

	public void setType(Vetement type) {
		this.type = type;
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

	public CommandeLigne getLigneCommandee() {
		return ligneCommandee;
	}

	public void setLigneCommandee(CommandeLigne ligneCommandee) {
		this.ligneCommandee = ligneCommandee;
	}

	public ProductRating getProductRating() {
		return productRating;
	}

	public void setProductRating(ProductRating productRating) {
		this.productRating = productRating;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	@Override
	public int hashCode() {
		return Objects.hash(categories, couleur, id, ligneCommandee, productRating, stock, taille, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(categories, other.categories) && Objects.equals(couleur, other.couleur) && id == other.id
				&& Objects.equals(ligneCommandee, other.ligneCommandee)
				&& Objects.equals(productRating, other.productRating) && stock == other.stock && taille == other.taille
				&& type == other.type;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
    
	
    
	

}