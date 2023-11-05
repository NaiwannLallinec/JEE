package fr.cytech.pau.demoGr1;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class CommandeLigne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long quantite;
    
    @ManyToOne
    private Commande commandeDesLignes;
    
    @OneToOne
    private Product product;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getQuantite() {
		return quantite;
	}

	public void setQuantite(Long quantite) {
		this.quantite = quantite;
	}

	public Commande getCommandeDesLignes() {
		return commandeDesLignes;
	}

	public void setCommandeDesLignes(Commande commandeDesLignes) {
		this.commandeDesLignes = commandeDesLignes;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public int hashCode() {
	    return Objects.hash(id, quantite);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CommandeLigne other = (CommandeLigne) obj;
		return Objects.equals(commandeDesLignes, other.commandeDesLignes) && Objects.equals(id, other.id)
				&& Objects.equals(product, other.product) && Objects.equals(quantite, other.quantite);
	}
    

}